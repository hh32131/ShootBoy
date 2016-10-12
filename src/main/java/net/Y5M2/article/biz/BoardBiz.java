package net.Y5M2.article.biz;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;

public interface BoardBiz {

	/**
	 * 게시판 리스트
	 * @return
	 */
	public List<BoardVO> getBoardOf();
	
	/**
	 * 게시판 글쓰기
	 * @param boardVO
	 * @return
	 */
	public boolean writeBoard(BoardVO boardVO);
	
	/**
	 * 게시판 글 상세보기
	 * @param BoardId
	 * @return
	 */
	public BoardVO getBoardAt(String boardId);
	
	/**
	 * 게시판 글 조회수 업데이트
	 * @param boardId
	 * @return
	 */
	public boolean hitCountUpdate(String boardId);

	/**
	 * 게시판 글 삭제
	 * @param boardId
	 * @return
	 */
	public boolean deleteBoard(String boardId);
	
	/**
	 * 게시판 글 수정
	 * @param boardId
	 * @return
	 */
	public boolean modifyBoard(BoardVO board);
	
}
