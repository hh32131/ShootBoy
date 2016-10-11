package net.Y5M2.article.dao;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;

public interface BoardDao {

	public List<BoardVO> selectBoards();
	
	public int writeBoard(BoardVO boardVO);

	
}
