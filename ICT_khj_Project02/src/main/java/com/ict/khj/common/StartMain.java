package com.ict.khj.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ict.khj.dao.CCenterVO;
import com.ict.khj.dao.EventVO;
import com.ict.khj.dao.UserVO;
import com.ict.khj.service.MainService;

@Controller
public class StartMain {
	@Autowired
	private MainService mainService;
	@Autowired
	private Paging paging;
	
	@GetMapping("/")
	public ModelAndView getMainIndex() {
		return new ModelAndView("index");
	}
	
	@GetMapping("event_list.do")
	public ModelAndView getEventList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("all_event");
		// 페이지기법 이전 
				/*
				List<BbsVO> list = bbsService.getBbsList();
				if(list != null) {
					mv.addObject("list", list);
					return mv;
				}
				return new ModelAndView("bbs/error");
				*/
				
				// 전체 게시물의 수를 구한다.
				int count = mainService.getTotalCount();
				paging.setTotalRecord(count);
				
				// 전체 페이지의 수를 구하자.
				if(paging.getTotalRecord() <= paging.getNumPerPage()) {
					paging.setTotalPage(1);
				}else {
					paging.setTotalPage(paging.getTotalRecord()/ paging.getNumPerPage());
					if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
						paging.setTotalPage(paging.getTotalPage() + 1 );
					}
				}
					
				// 현재 페이지 구하기 => begin, end 구한다
				String cPage = request.getParameter("cPage");
				
				// 맨 처음에 오면 cPage 없으므로 null 이다. 
				// 맨 처음 오면 무조건 1 페이지 이다.
				if(cPage == null) {
					paging.setNowPage(1);
				}else {
					paging.setNowPage(Integer.parseInt(cPage));
				}
				// 오라클 begin, end 
				// 마리아DB limit, offset
				// offset = limit * (현재페이지 -1)
				// limit = numPerPage 
				paging.setOffset(paging.getNumPerPage() * (paging.getNowPage()-1));
				
			
				// 시작블록과 끝블록 구하기 
				paging.setBeginBlock(
				   (int)(((paging.getNowPage()-1) / paging.getPagePerBlock()) * paging.getPagePerBlock()+1));
				paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);
			
				// 주의 사항
				// endBlock 과 totalPage가 endBlock이 크면 endBlock를 totalPage로 지정한다.
				if(paging.getEndBlock() >  paging.getTotalPage()) {
					paging.setEndBlock(paging.getTotalPage());
				}
				List<EventVO> event_list = mainService.getEventList(paging.getOffset(), paging.getNumPerPage());
				mv.addObject("event_list", event_list);
				mv.addObject("paging", paging);
				return mv;
	}
	
	@GetMapping("event_detail_do")
	public ModelAndView getEventDetail(String mt20id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mt20id", mt20id);
		mv.setViewName("ajax/eventDetail");
		return mv;
	}
	
	@GetMapping("event_db_refresh.do")
	public ModelAndView getEventRefresh() {
		ModelAndView mv = new ModelAndView("redirect:/");
		BufferedReader rd = null;
	    HttpURLConnection conn = null;
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		StringBuilder urlBuilder = new StringBuilder("http://kopis.or.kr/openApi/restful/pblprfr"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("service","utf-8") + "=ee2581e9309c4bc889965812dcef6c4c"); /*Service Key*/        
		urlBuilder.append("&" + URLEncoder.encode("stdate","utf-8") + "=" + URLEncoder.encode("20240501", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("eddate","utf-8") + "=" + URLEncoder.encode("20240531", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("cpage","utf-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("rows","utf-8") + "=" + URLEncoder.encode("1000", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("newsql","utf-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 
        
        URL url = new URL(urlBuilder.toString());
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "text/xml");
        
        
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        Document document = builder.parse(new InputSource(new StringReader(sb.toString())));
        NodeList nodeList = document.getElementsByTagName("db");
        
        List<EventVO> eList = new ArrayList<>();
        System.out.println(nodeList.getLength());
        for(int i = 0; i < nodeList.getLength(); i++) {
        	Node node = nodeList.item(i);
        	if(node.getNodeType() == Node.ELEMENT_NODE) {
        		EventVO evo = new EventVO();
        		Element element = (Element) node;
        		evo.setMt20id(element.getElementsByTagName("mt20id").item(0).getTextContent());
        		evo.setPrfnm(element.getElementsByTagName("prfnm").item(0).getTextContent());
        		evo.setPrfpdfrom(element.getElementsByTagName("prfpdfrom").item(0).getTextContent());
        		evo.setPrfpdto(element.getElementsByTagName("prfpdto").item(0).getTextContent());
        		evo.setFcltynm(element.getElementsByTagName("fcltynm").item(0).getTextContent());
        		evo.setPoster(element.getElementsByTagName("poster").item(0).getTextContent());
        		evo.setArea(element.getElementsByTagName("area").item(0).getTextContent());
        		evo.setGenrenm(element.getElementsByTagName("genrenm").item(0).getTextContent());
        		evo.setPrfstate(element.getElementsByTagName("prfstate").item(0).getTextContent());
        		evo.setOpenrun(element.getElementsByTagName("openrun").item(0).getTextContent());
        		
        		eList.add(evo);
        	}
        	
        }
        for (EventVO k : eList) {
//			System.out.println(k.getMt20id());
//			System.out.println(k.getPrfnm());
//			System.out.println(k.getPrfpdfrom());
//			System.out.println(k.getPrfpdto());
//			System.out.println(k.getFcltynm());
//			System.out.println(k.getPoster());
//			System.out.println(k.getArea());
//			System.out.println(k.getGenrenm());
//			System.out.println(k.getPrfstate());
//			System.out.println(k.getOpenrun());
//			System.out.println("=====================");
        	int result = 0;
        	result = mainService.getEventRefresh(k);
        	if(result != 1) {
        		return new ModelAndView("error");
        	}
		}
        
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			  try {
				rd.close();
				conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return mv;
	}
	
	@GetMapping("mypage.do")
	public ModelAndView getMyPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mypage");
		HttpSession session = request.getSession();
		SessionUserVO suvo = (SessionUserVO) session.getAttribute("suvo");
		try {
			UserVO uvo = mainService.getUserDetail(suvo.getUser_idx());
			mv.addObject("uvo", uvo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("error");
	}
		
}




























