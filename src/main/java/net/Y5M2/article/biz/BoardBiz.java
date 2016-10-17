package net.Y5M2.article.biz;

import net.Y5M2.article.vo.BoardListVO;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.article.vo.SearchBoardVO;

public interface BoardBiz {

	/**
	 * 검색기능을 넣은 게시판 리스트
	 * 
	 * @param searchBoard
	 * @return
	 */
	public BoardListVO getAllBoards(SearchBoardVO searchBoard);

	/**
	 * 게시판 글쓰기
	 * 
	 * @param boardVO
	 * @return
	 */
	public boolean writeBoard(BoardVO boardVO);

	/**
	 * 게시판 글 상세보기
	 * 
	 * @param BoardId
	 * @return
	 */
	public BoardVO getBoardAt(String boardId);

	/**
	 * 게시판 글 조회수 업데이트
	 * 
	 * @param boardId
	 * @return
	 */
	public boolean hitCountUpdate(String boardId);

	/**
	 * 게시판 글 삭제
	 * 
	 * @param boardId
	 * @return
	 */
	public boolean deleteBoard(String boardId);

	/**
	 * 게시판 글 수정을 위한 게시판의 글 가져오기
	 * 
	 * @param boardId
	 * @return
	 */
	public BoardVO getBoardForModify(String boardId);

	/**
	 * 게시판 글 수정
	 * 
	 * @param boardId
	 * @return
	 */
	public boolean modifyBoard(BoardVO board);

	/**
	 * 파일 다운로드
	 * 
	 * @param articlesId
	 * @return
	 */
	public String getFileNmaeOfArticleBy(String boardId);

}
