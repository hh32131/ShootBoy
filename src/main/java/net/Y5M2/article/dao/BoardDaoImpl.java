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

public class BoardDaoImpl extends DaoSupport implements BoardDao {

	
	/* join으로 userId와 categoryId 이름 변경이 필요함.*/
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
				query.append(" , ?, ?, 1, 1, 12, 0, SYSDATE, SYSDATE) ");
				
				
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardVO.getBoardSubject());
				pstmt.setString(2, boardVO.getBoardContent());
				//pstmt.setString(3, boardVO.getUserId());
			//	pstmt.setString(3, boardVO.getFileName());
				
				return pstmt;
			}
		});
	}

}
