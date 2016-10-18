package net.Y5M2.article.dao;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.article.vo.SearchBoardVO;

public interface BoardDao {

	public List<BoardVO> getAllBoards(SearchBoardVO searchBoard);
	
	public int getCountOfBoards(SearchBoardVO searchBoard);
	
	public int writeBoard(BoardVO boardVO);

	public BoardVO getBoardAt(String boardId);
	
	public int hitCountUpdate(String boardId);

	public int deleteBoard(String boardId);

	public BoardVO getBoardForModify(String boardId);

	public int modifyBoard(BoardVO board);
	
	
	public List<BoardVO> getAllBoard();

}
