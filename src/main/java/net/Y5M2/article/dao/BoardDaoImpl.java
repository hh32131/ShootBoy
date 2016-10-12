package net.Y5M2.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import oracle.jdbc.proxy.annotation.Pre;

public class BoardDaoImpl extends DaoSupport implements BoardDao {
	
	@Override
	public List<BoardVO> selectBoards() {
		
		List<BoardVO> boards = (List<BoardVO>) selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	BOARD_ID ");
				query.append(" 			, BOARD_SBJ ");
				query.append(" 			, BOARD_CONT ");
				query.append(" 			, HIT_CNT ");
				query.append(" 			, USR_ID ");
				query.append(" 			, CTGR_ID ");
				query.append("			, CRT_DT ");
				query.append("   		, LTST_MDFY_DT ");
				query.append(" FROM		BOARD ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<BoardVO> boards = new ArrayList<BoardVO>();
				BoardVO board = null;
				
				while( rs.next() ) {
					board = new BoardVO();
					board.setBoardId(rs.getString("BOARD_ID"));
					board.setBoardSubject(rs.getString("BOARD_SBJ"));
					board.setBoardContent(rs.getString("BOARD_CONT"));
					board.setHitCount(rs.getInt("HIT_CNT"));
					board.setUserId(rs.getString("USR_ID"));
					board.setCategoryId(rs.getString("CTGR_ID"));
					
					boards.add(board);
				}
				
				return boards;
			}
			
		});

		return boards;
	}

	@Override
	public int writeBoard(BoardVO boardVO) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT INTO BOARD ( ");
				query.append(" BOARD_ID, BOARD_SBJ, BOARD_CONT, ");
				query.append(" CTGR_ID, HIT_CNT, USR_ID, ");
				query.append(" FILE_NM, CRT_DT, LTST_MDFY_DT ) ");
				query.append(" VALUES ( ");
				query.append(" 'BO-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(BOARD_ID_SEQ.NEXTVAL,6,0) ");
<<<<<<< HEAD
				query.append(" , ?, ?, 1, 1, 12, 0, SYSDATE, SYSDATE) ");
				
				
=======
				query.append(" , ?, ?, 0, 0, 0, 0, SYSDATE, SYSDATE) ");
>>>>>>> 3e2354bf103bbed4f6a1adcd6b26839a7d025d37
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardVO.getBoardSubject());
				pstmt.setString(2, boardVO.getBoardContent());
				//pstmt.setString(3, boardVO.getUserId());
				//pstmt.setString(4, boardVO.getFileName());
				
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
					board.setLatestModifyDate(rs.getString("LTST_MDFY_DT"));
					
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
				if ( board.getBoardSubject() != null ) {
					
				}
				if ( board.getFileName() != null ) {
					
				}
				
				query.append(" WHERE	BOARD_ID = ? ");
				
				return null;
			}
		});
	}
}
