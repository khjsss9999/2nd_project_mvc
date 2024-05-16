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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ict.khj.dao.EventVO;

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
	
	
		
}
