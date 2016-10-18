package net.Y5M2.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.article.vo.SearchBoardVO;
import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.user.vo.UserVO;

public class BoardDaoImpl extends DaoSupport implements BoardDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> getAllBoards(SearchBoardVO searchBoard, CategoryVO categoryVO) {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	B.BOARD_ID ");
				query.append(" 			, B.BOARD_SBJ ");
				query.append(" 			, B.BOARD_CONT ");
				query.append(" 			, B.HIT_CNT ");
				query.append(" 			, B.REPLY_HIT_CNT ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, B.CTGR_ID ");
				query.append(" 			, B.FILE_NM ");
				query.append("			, TO_CHAR(B.CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT ");
				query.append("   		, TO_CHAR(B.LTST_MDFY_DT, 'YYYY-DD-MM HH24:MI:SS') LTST_MDFY_DT  ");
				query.append("   		, C.CTGR_NM  ");
				query.append("   		, C.PRNT_CTGR_ID  ");
				query.append(" FROM		BOARD B ");
				query.append(" 			, USR U ");
				query.append(" 			, CTGR C ");
				query.append(" WHERE	B.USR_ID = U.USR_ID ");
				query.append(" AND		B.CTGR_ID = C.CTGR_ID ");
				
				if(categoryVO.getCategoryId() != "0"){
					query.append(" AND		B.CTGR_ID = ? ");
				}
				
				
				if ( searchBoard.getSearchType() == 1 ) {
					query.append(" AND	( B.BOARD_SBJ LIKE '%'|| ?|| '%' ");
					query.append(" OR	B.BOARD_CONT LIKE '%' || ? || '%' ) ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( B.BOARD_SBJ LIKE '%'|| ?|| '%' ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( B.BOARD_CONT LIKE '%'|| ?|| '%' ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( U.USR_NM LIKE '%'|| ?|| '%' ");
				}
				
				query.append(" ORDER	BY BOARD_ID DESC");
				
				String pagingQuery = appendPagingQueryFormat(query.toString());
				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);
				
				int index = 1;
				
				if(categoryVO.getCategoryId() != "0"){
					pstmt.setString(index++, categoryVO.getCategoryId());
				}
				if ( searchBoard.getSearchType() == 1 ) {
					pstmt.setString(index++, searchBoard.getSearchKeyword());
					pstmt.setString(index++, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(index++, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(index++, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(index++, searchBoard.getSearchKeyword());
				}
				
				pstmt.setInt(index++, searchBoard.getEndRowNumber());
				pstmt.setInt(index++, searchBoard.getStartRowNumber());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				BoardVO boardVO = null;
				List<BoardVO> boards = new ArrayList<BoardVO>();

				UserVO userVO = null;	
				CategoryVO categoryVO = null;
				while( rs.next() ) {
					
					boardVO = new BoardVO();
					boardVO.setBoardId(rs.getString("BOARD_ID"));
					boardVO.setBoardSubject(rs.getString("BOARD_SBJ"));
					boardVO.setBoardContent(rs.getString("BOARD_CONT"));
					boardVO.setHitCount(rs.getInt("HIT_CNT"));
					boardVO.setCategoryId(rs.getString("CTGR_ID"));
					
					categoryVO = boardVO.getCategoryVO();
					categoryVO.setCategoryName(rs.getString("CTGR_NM"));
					categoryVO.setParentsCategoryId(rs.getString("PRNT_CTGR_ID"));
					
					boardVO.setFileName(rs.getString("FILE_NM"));
					boardVO.setCreateDate(rs.getString("CRT_DT"));
					boardVO.setModifyDate(rs.getString("LTST_MDFY_DT"));
					boardVO.setReplayHitCount(rs.getInt("REPLY_HIT_CNT"));
					
					userVO = boardVO.getUserVO();
					userVO.setUserName(rs.getString("USR_NM"));
					
					boards.add(boardVO);
					
				}
				
				return boards;
			}
		});
	}

	@Override
	public int getCountOfBoards(SearchBoardVO searchBoard) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		BOARD B ");
				query.append(" 			, USR U ");
				query.append(" WHERE	B.USR_ID = U.USR_ID ");
				
				if ( searchBoard.getSearchType() == 1 ) {
					query.append(" AND	( B.BOARD_SBJ LIKE '%'|| ?|| '%' ");
					query.append(" OR	B.BOARD_CONT LIKE '%' || ? || '%' ) ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( B.BOARD_SBJ LIKE '%'|| ?|| '%' ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( B.BOARD_CONT LIKE '%'|| ?|| '%' ");
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					query.append(" AND	( U.USR_NM LIKE '%'|| ?|| '%' ");
				}
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				if ( searchBoard.getSearchType() == 1 ) {
					pstmt.setString(1, searchBoard.getSearchKeyword());
					pstmt.setString(2, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(1, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(1, searchBoard.getSearchKeyword());
				}
				else if ( searchBoard.getSearchType() == 2 ) {
					pstmt.setString(1, searchBoard.getSearchKeyword());
				}
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getInt("CNT");
			}
		});
	}

	@Override
	public int writeBoard(BoardVO boardVO) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT INTO BOARD ( ");
				query.append(" 						BOARD_ID ");
				query.append(" 						, BOARD_SBJ ");
				query.append(" 						, BOARD_CONT ");
				query.append(" 						, CTGR_ID ");
				query.append(" 						, HIT_CNT ");
				query.append(" 						, USR_ID ");
				query.append(" 						, FILE_NM ");
				query.append(" 						, CRT_DT ");
				query.append(" 						, LTST_MDFY_DT ");
				query.append(" 					) ");
				query.append(" VALUES ( ");
				query.append(" 'BO-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(BOARD_ID_SEQ.NEXTVAL,6,0) ");
				query.append(" , ?, ?, ?, 0, ?, ?, SYSDATE, SYSDATE) ");

				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardVO.getBoardSubject());
				pstmt.setString(2, boardVO.getBoardContent());
				pstmt.setString(3, boardVO.getCategoryId());
				pstmt.setString(4, boardVO.getUserId());
				pstmt.setString(5, boardVO.getFileName());
				
				return pstmt;
			}
		});
	}

	@Override
	public BoardVO getBoardAt(String boardId) {
		return (BoardVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	BOARD_ID ");
				query.append(" 			, BOARD_SBJ ");
				query.append(" 			, HIT_CNT ");
				query.append(" 			, BOARD_CONT ");
				query.append(" 			, USR_ID ");
				query.append(" 			, CTGR_ID ");
				query.append(" 			, FILE_NM ");
				query.append(" 			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, TO_CHAR(LTST_MDFY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MDFY_DT ");
				query.append(" FROM		BOARD ");
				query.append(" WHERE	BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				BoardVO board = null;
				if( rs.next() ) {

					board = new BoardVO();
					board.setBoardId(rs.getString("BOARD_ID"));
					board.setBoardSubject(rs.getString("BOARD_SBJ"));
					board.setHitCount(rs.getInt("HIT_CNT"));
					board.setBoardContent(rs.getString("BOARD_CONT"));
					board.setUserId(rs.getString("USR_ID"));
					board.setCategoryId(rs.getString("CTGR_ID"));
					board.setFileName(rs.getString("FILE_NM"));
					board.setCreateDate(rs.getString("CRT_DT"));
					board.setModifyDate(rs.getString("LTST_MDFY_DT"));
					
				}
				
				return board;
			}
		});
	}
	
	@Override
	public int hitCountUpdate(String boardId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	BOARD ");
				query.append(" SET		HIT_CNT = HIT_CNT + 1 ");
				query.append(" WHERE	BOARD_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}
		});
	}

	@Override
	public int deleteBoard(String boardId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM		BOARD ");
				query.append(" WHERE	BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}
		});
	}

	@Override
	public BoardVO getBoardForModify(String boardId) {
		return (BoardVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	BOARD_ID ");
				query.append(" 			, BOARD_SBJ ");
				query.append(" 			, BOARD_CONT ");
				query.append(" 			, CTGR_ID ");
				query.append(" 			, HIT_CNT ");
				query.append(" 			, USR_ID ");
				query.append(" 			, FILE_NM ");
				query.append(" 			, CRT_DT ");
				query.append(" 			, LTST_MDFY_DT ");
				query.append(" FROM		BOARD ");
				query.append(" WHERE	BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				BoardVO board = null;
				
				while ( rs.next() ) {
					
					board = new BoardVO();
					board.setBoardId(rs.getString("BOARD_ID"));
					board.setBoardSubject(rs.getString("BOARD_SBJ"));
					board.setBoardContent(rs.getString("BOARD_CONT"));
					board.setCategoryId(rs.getString("CTGR_ID"));
					board.setHitCount(rs.getInt("HIT_CNT"));
					board.setUserId(rs.getString("USR_ID"));
					board.setFileName(rs.getString("FILE_NM"));
					board.setCreateDate(rs.getString("CRT_DT"));
					board.setModifyDate(rs.getString("LTST_MDFY_DT"));
					
				}
				
				return board;
			}
		});
	}
	
	@Override
	public int modifyBoard(BoardVO board) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	BOARD ");
				query.append(" SET		LTST_MDFY_DT = SYSDATE ");
				
				if ( board.getBoardSubject() != null ) {
					query.append(" , BOARD_SBJ = ? ");
				}
				
				if ( board.getBoardContent() != null ) {
					query.append(" , BOARD_CONT = ? ");
				}
				
				if ( board.getFileName() != null ) {
					query.append(" , FILE_NM = ? ");
				}
				
				query.append(" WHERE	BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				int index = 1;
				
				if ( board.getBoardSubject() != null ) {
					pstmt.setString(index++, board.getBoardSubject());
				}
				
				if ( board.getBoardContent() != null ) {
					pstmt.setString(index++, board.getBoardContent());
				}
				
				if ( board.getFileName() != null ) {
					pstmt.setString(index++, board.getFileName());
				}
				
				pstmt.setString(index++, board.getBoardId());
				
				return pstmt;
			}
		});
	}

}
