package net.Y5M2.article.biz;

import java.util.List;

import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.article.vo.BoardListVO;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.article.vo.SearchBoardVO;
import net.Y5M2.replay.dao.ReplayDao;
import net.Y5M2.replay.dao.ReplayDaoImpl;
import net.Y5M2.support.pager.Pager;
import net.Y5M2.support.pager.PagerFactory;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	private ReplayDao replayDao;
	
	public BoardBizImpl() {
		boardDao = new BoardDaoImpl();
		replayDao = new ReplayDaoImpl();
	}
	
	@Override
	public BoardListVO getAllBoards(SearchBoardVO searchBoard) {
		
		int totalCount = boardDao.getCountOfBoards(searchBoard);
		Pager pager = PagerFactory.getPager(true);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchBoard.getPageNo());
		
		searchBoard.setStartRowNumber(pager.getStartArticleNumber());
		searchBoard.setEndRowNumber(pager.getEndArticleNumber());
		
		List<BoardVO> boards = boardDao.getAllBoards(searchBoard);
		
		BoardListVO boardList = new BoardListVO();
		boardList.setPager(pager);
		boardList.setBoards(boards);
		
		return boardList;
	}

	@Override
	public boolean writeBoard(BoardVO boardVO) {
		return boardDao.writeBoard(boardVO)>0;
	}

	@Override
	public BoardVO getBoardAt(String boardId) {
		boardDao.hitCountUpdate(boardId);
		return boardDao.getBoardAt(boardId);
	}
	

	@Override
	public boolean deleteBoard(String boardId) {
		replayDao.deletAllReplay(boardId);
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
