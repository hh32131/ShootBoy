package net.Y5M2.article.biz;

import java.util.List;

import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.article.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	
	public BoardBizImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public List<BoardVO> getBoardOf() {
		return boardDao.selectBoards();
	}

	@Override
	public boolean writeBoard(BoardVO boardVO) {
		return boardDao.writeBoard(boardVO)>0;
	}

}
