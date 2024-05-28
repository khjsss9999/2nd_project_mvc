package com.ict.khj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.khj.dao.BoardDAO;
import com.ict.khj.dao.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public int getTotalCount() {

		return boardDAO.getTotalCount();
	}
	
	@Override
	public List<BoardVO> getBoardList(int offset, int limit) {
		return boardDAO.getBoardList(offset, limit);
	}
	
	@Override
	public int getBoardInsert(BoardVO bovo) {
		return boardDAO.getBoardInsert(bovo);
	}
	
	@Override
	public int getBoardHit(String board_idx) {
		return boardDAO.getBoardHit(board_idx);
	}
	
	@Override
	public BoardVO getBoardDetail(String board_idx) {
		return boardDAO.getBoardDetail(board_idx);
	}
	
	@Override
	public int getLevUpdate(Map<String, Integer> map) {

		return boardDAO.getLevUpdate(map);
	}
	
	@Override
	public int getAnsInsert(BoardVO bovo) {
		return boardDAO.getAnsInsert(bovo);
	}
}
