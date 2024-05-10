package com.ict.khj.common;

import org.springframework.beans.factory.annotation.Autowired;
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
}