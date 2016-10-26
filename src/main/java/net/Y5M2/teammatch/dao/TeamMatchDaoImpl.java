package net.Y5M2.teammatch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.teammatch.vo.TeamMatchVO;

public class TeamMatchDaoImpl extends DaoSupport implements TeamMatchDao {

	@Override
	public int teamMatchRequest(String teamId,String awayTeamId, String matchId) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT	INTO	TMATCH ( ");
				query.append(" TMATCH_ID, TEAM_ID, ATEAM_ID, MATCH_ID ) ");
				query.append(" VALUES ( ");
				query.append(" TMATCH_ID_SEQ.NEXTVAL , ?, ?, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, awayTeamId);
				pstmt.setString(3, matchId);
				
				return pstmt;
			}
		});
	}

	@Override
	public int isExistTeam(String teamId, String matchId) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TMATCH ");
				query.append(" WHERE	ATEAM_ID = ? ");
				query.append(" AND		MATCH_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, matchId);
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
	public List<TeamMatchVO> getMatchApplyOf(String teamId) {

		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	TM.MATCH_ID ");
				query.append(" 			, TM.ATEAM_ID ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TMATCH TM ");
				query.append(" 			, TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.TEAM_ID = TM.ATEAM_ID ");
				query.append(" AND		T.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		TM.TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<TeamMatchVO> matchs = new ArrayList<TeamMatchVO>();
				TeamMatchVO matchVO = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;
				
				while(rs.next()){
					matchVO = new TeamMatchVO();
					matchVO.setMatchId(rs.getString("MATCH_ID"));
					matchVO.setAwayTeamId(rs.getString("ATEAM_ID"));
					
					teamVO = matchVO.getTeamVO();
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));
					
					locationVO = teamVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));
					
					matchs.add(matchVO);
				}
				
				return matchs;
			}
		});
	}
	
	@Override
	public int deleteMatchApply(String matchId) {

		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM		TMATCH ");
				query.append(" WHERE	MATCH_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, matchId);
				
				return pstmt;
			}
		});
	}

}
