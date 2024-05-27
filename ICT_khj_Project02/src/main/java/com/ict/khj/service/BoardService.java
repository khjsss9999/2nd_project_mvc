package com.ict.khj.service;

import java.util.List;

import com.ict.khj.dao.BoardVO;

public interface BoardService {
	public int getTotalCount();
	public List<BoardVO> getBoardList(int offset, int limit);
	public int getBoardInsert(BoardVO bovo);
}
