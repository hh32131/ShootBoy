package net.Y5M2.replay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.replay.vo.ReplayVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.user.vo.UserVO;

public class ReplayDaoImpl extends DaoSupport implements ReplayDao{

	@Override
	public int writeReplay(ReplayVO replays) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
			
				StringBuffer query = new StringBuffer();
				query.append(" INSERT	INTO	REPLY ( ");
				query.append(" 					REPLY_ID ");
				query.append(" 					, REPLY_CONT ");
				query.append(" 					, CRT_DT ");
				query.append(" 					, LTST_MODY_DT ");
				query.append(" 					, BOARD_ID ");
				query.append(" 					, USR_ID ) ");
				query.append(" VALUES			( ");
				query.append(" 'RE-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(REPLY_ID_SEQ.NEXTVAL,6,0) ");
				query.append(" , ?, SYSDATE, SYSDATE, ?, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, replays.getReplayContent());
				pstmt.setString(2, replays.getBoardId());
				pstmt.setString(3, replays.getUserId());
				
				return pstmt;
			}
		});
	}

	@Override
	public List<ReplayVO> getListReplays(String boardId) {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	R.REPLY_ID ");
				query.append(" 			, R.REPLY_CONT ");
				query.append(" 			, R.BOARD_ID ");
				query.append(" 			, R.USR_ID ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, TO_CHAR(R.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, TO_CHAR(R.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" FROM		REPLY R ");
				query.append(" 			, USR U ");
				query.append(" WHERE	R.USR_ID = U.USR_ID ");
				query.append(" AND		BOARD_ID = ? ");
				query.append(" ORDER BY CRT_DT");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
			
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<ReplayVO> replays = new ArrayList<ReplayVO>();
				ReplayVO replayVO = null;
				BoardVO boardVO = null;
				UserVO userVO = null;
				
				while( rs.next() ) {
					replayVO = new ReplayVO();
					
					replayVO.setReplayId(rs.getString("REPLY_ID"));
					replayVO.setReplayContent(rs.getString("REPLY_CONT"));
					replayVO.setCreateDate(rs.getString("CRT_DT"));
					replayVO.setLeastModifyDate(rs.getString("LTST_MODY_DT"));
					
					boardVO = replayVO.getBoardVO();
					boardVO.setBoardId(rs.getString("BOARD_ID"));
					
					userVO = replayVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
					
					replays.add(replayVO);
					
				}
				
				return replays;
			}
		});
	}

	@Override
	public int replayHitCount(int hitCount) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" UPDATE	BOARD ");
				query.append(" SET		REPLY_HIT_CNT = REPLY_HIT_CNT + ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, hitCount);
				return pstmt;
			}
		});
	}
	
	@Override
	public int deletAllReplay(String boardId) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" DELETE ");
				query.append(" FROM		REPLY ");
				query.append(" WHERE	BOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, boardId);
				
				return pstmt;
			}
		});
	}

	@Override
	public int deleteOneReplay(String replayId) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();
				
				query.append(" DELETE ");
				query.append(" FROM		REPLY ");
				query.append(" WHERE	REPLY_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, replayId);
				return pstmt;
			}
		});
	}

	@Override
	public int replayModify(ReplayVO replays) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" UPDATE 	REPLY ");
				query.append(" SET		LTST_MODY_DT = SYSDATE ");
				if(replays.getReplayContent() != null){
					query.append(" 			, REPLY_CONT = ? ");
				}
				query.append(" WHERE	REPLY_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 1;
				if(replays.getReplayContent() != null){
					pstmt.setString(index++, replays.getReplayContent());
				}
				
				pstmt.setString(index++, replays.getReplayId());
				return pstmt;
			}
		});
	}
	
	@Override
	public ReplayVO getReplyAt(String replyId) {

		return (ReplayVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	R.REPLY_ID ");
				query.append(" 			, R.REPLY_CONT ");
				query.append(" 			, R.BOARD_ID ");
				query.append(" 			, R.USR_ID ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, TO_CHAR(R.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, TO_CHAR(R.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" FROM		REPLY R ");
				query.append(" 			, USR U ");
				query.append(" WHERE	R.USR_ID = U.USR_ID ");
				query.append(" AND		REPLY_ID = ? ");
				query.append(" ORDER BY CRT_DT");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, replyId);
			
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				ReplayVO replayVO = null;
				BoardVO boardVO = null;
				UserVO userVO = null;
				
				while( rs.next() ) {
					replayVO = new ReplayVO();
					
					replayVO.setReplayId(rs.getString("REPLY_ID"));
					replayVO.setReplayContent(rs.getString("REPLY_CONT"));
					replayVO.setCreateDate(rs.getString("CRT_DT"));
					replayVO.setLeastModifyDate(rs.getString("LTST_MODY_DT"));
					
					boardVO = replayVO.getBoardVO();
					boardVO.setBoardId(rs.getString("BOARD_ID"));
					
					userVO = replayVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
					
					
				}
				
				return replayVO;
			}
		});
	}

}
