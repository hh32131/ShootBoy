package net.Y5M2.teammatch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;

public class TeamMatchDaoImpl extends DaoSupport implements TeamMatchDao {

	@Override
	public int teamMatchRequest(String teamId, MatchVO matchVO) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT	INTO	TMATCH ( ");
				query.append(" TMATCH_ID, TEAM_ID, ATEAM_ID ) ");
				query.append(" VALUES ( ");
				query.append(" TMATCH_ID_SEQ.NEXTVAL , ?, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, matchVO.getAwayTeamId());
				return pstmt;
			}
		});
	}

	@Override
	public int isExistTeam(MatchVO matchVO) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TMATCH ");
				query.append(" WHERE	TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, matchVO.getTeamId());
				return pstmt;
				
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				rs.next();
				return rs.getInt("CNT");
			}
		});

	}

}
