package net.Y5M2.article.biz;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;

public interface BoardBiz {

	public List<BoardVO> getBoardOf();
	
	public boolean writeBoard(BoardVO boardVO);

	
}
