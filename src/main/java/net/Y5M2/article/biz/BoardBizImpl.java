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
	public BoardVO getBoardForModify(String boardId) {
		return boardDao.getBoardForModify(boardId);
	}
	
	@Override
	public boolean modifyBoard(BoardVO board) {
		
		BoardVO originalBoard = boardDao.getBoardAt(board.getBoardId());
		int modifyCount = 3;
		if ( originalBoard.getBoardSubject().equals(board.getBoardSubject()) ) {
			board.setBoardSubject(null);
			modifyCount--;
		}
		
		if ( originalBoard.getBoardContent().equals(board.getBoardContent()) ) {
			board.setBoardContent(null);
			modifyCount--;
		}
		
		if ( originalBoard.getFileName() == null ) {
			originalBoard.setFileName("");
		}
		
		if ( originalBoard.getFileName().equals(board.getFileName()) ) {
			board.setFileName(null);
			modifyCount--;
		}
		
		if ( modifyCount == 0 ) {
			return true;
		}
		
		return boardDao.modifyBoard(board) > 0;
	}

	@Override
	public String getFileNmaeOfArticleBy(String boardId) {
		BoardVO board = boardDao.getBoardAt(boardId);
		return board.getFileName();
	}

}
