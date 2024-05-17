package com.ict.khj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.khj.common.Paging;
import com.ict.khj.dao.CCenterVO;
import com.ict.khj.service.CCenterService;

@Controller
public class CCenterController {
	@Autowired
	private CCenterService cCenterService;
	@Autowired
	private Paging paging;
	
	@GetMapping("c_center_go.do")
	public ModelAndView CCenterList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("c_center");
		

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
		int count = cCenterService.getTotalCount();
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
		List<CCenterVO> faq_list = cCenterService.CCenterList(paging.getOffset(), paging.getNumPerPage());
		mv.addObject("faq_list", faq_list);
		mv.addObject("paging", paging);
	
		return mv; 
	}
	
	@GetMapping("faq_write.do")
	public ModelAndView getFaqWrite() {
		ModelAndView mv = new ModelAndView("faq_write");
		return mv;
	}
	
	@PostMapping("faq_write_ok")
	public ModelAndView getFaqWriteOK(CCenterVO ccvo) {
		ModelAndView mv = new ModelAndView("redirect:c_center_go.do");
		try {
			int result = 0;
			result = cCenterService.getFaqInsert(ccvo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return mv;
	}
	
//	@GetMapping("qna.do")
//	public ModelAndView getQnaList() {
//		ModelAndView mv = new ModelAndView("qna");
//	}
}
