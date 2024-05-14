package com.ict.khj.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartMain {
	
	@GetMapping("/")
	public ModelAndView getMainIndex() {
		return new ModelAndView("index");
	}
	
	@GetMapping("event_ajax.do")
	public ModelAndView getEventAjax() {
		return new ModelAndView("ajax/event_ajax");
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
        
        System.out.println(sb.toString());
    	
        return mv;
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
