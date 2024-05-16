package com.ict.khj.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ict.khj.dao.EventVO;

@RestController
public class AjaxController {
	
	@RequestMapping(value = "event_ajax_ok.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String eventData() {
	    BufferedReader rd = null;
	    HttpURLConnection conn = null;
		try {
		StringBuilder urlBuilder = new StringBuilder("http://kopis.or.kr/openApi/restful/pblprfr"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("service","utf-8") + "=ee2581e9309c4bc889965812dcef6c4c"); /*Service Key*/        
		urlBuilder.append("&" + URLEncoder.encode("stdate","utf-8") + "=" + URLEncoder.encode("20240501", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("eddate","utf-8") + "=" + URLEncoder.encode("20240531", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("cpage","utf-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("rows","utf-8") + "=" + URLEncoder.encode("50", "UTF-8")); /*한 페이지 결과 수*/
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
        System.out.println(sb.toString());
        return sb.toString();
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
        return null;
	}
	
	@RequestMapping(value= "event_detail_ok.do",  produces="text/xml; charset=utf-8")
	@ResponseBody
	public String eventDetail(@RequestParam("mt20id")String mt20id) {
	    BufferedReader rd = null;
	    HttpURLConnection conn = null;
		try {
			System.out.println(mt20id);
		StringBuilder urlBuilder = new StringBuilder("http://kopis.or.kr/openApi/restful/pblprfr"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("service","UTF-8") + "=ee2581e9309c4bc889965812dcef6c4c"); /*Service Key*/        
		urlBuilder.append("&" + URLEncoder.encode("mt20id","UTF-8") + "=" + URLEncoder.encode(mt20id, "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("newsql","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 
        
        
        URL url = new URL(urlBuilder.toString());
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
       // conn.setRequestProperty("Content-type", "text/xml");
        
        
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
        System.out.println(sb.toString());
        return sb.toString();
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
        return null;
	}
	
	@RequestMapping(value = "event_db_refresh.do" , produces = "text/xml; charset=utf-8")
	@ResponseBody
	public String eventRefresh() {
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
        urlBuilder.append("&" + URLEncoder.encode("rows","utf-8") + "=" + URLEncoder.encode("50", "UTF-8")); 
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
			System.out.println(k.getMt20id());
			System.out.println(k.getPrfnm());
			System.out.println(k.getPrfpdfrom());
			System.out.println(k.getPrfpdto());
			System.out.println(k.getFcltynm());
			System.out.println(k.getPoster());
			System.out.println(k.getArea());
			System.out.println(k.getGenrenm());
			System.out.println(k.getPrfstate());
			System.out.println(k.getOpenrun());
			System.out.println("=====================");
		}
        
        return sb.toString();
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
		return null;
	}
	
	
}
	





















