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

	@Override
	public BoardVO getBoardAt(String boardId) {
		return boardDao.getBoardAt(boardId);
	}
	
	@Override
	public boolean hitCountUpdate(String boardId) {
		return boardDao.hitCountUpdate(boardId) > 0;
	}

	@Override
	public boolean deleteBoard(String boardId) {
		return boardDao.deleteBoard(boardId) > 0;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return boardDao.modifyBoard(board) > 0;
	}

}
