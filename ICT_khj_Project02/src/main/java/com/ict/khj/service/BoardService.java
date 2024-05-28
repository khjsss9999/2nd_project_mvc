package com.ict.khj.service;


import java.util.List;
import java.util.Map;

import com.ict.khj.dao.BoardVO;

public interface BoardService {
	public int getTotalCount();
	public List<BoardVO> getBoardList(int offset, int limit);
	public int getBoardInsert(BoardVO bovo);
	public int getBoardHit(String board_idx);
	public BoardVO getBoardDetail(String board_idx);
	public int getLevUpdate(Map<String, Integer> map);
	public int getAnsInsert(BoardVO bovo);
}
