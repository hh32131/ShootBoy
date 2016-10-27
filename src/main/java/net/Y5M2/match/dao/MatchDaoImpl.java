package net.Y5M2.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.team.vo.AwayTeamVO;
import net.Y5M2.team.vo.TeamVO;

public class MatchDaoImpl extends DaoSupport implements MatchDao {

	@Override
	public int applyMatch(MatchVO matchVO) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO MATCH ( ");
				query.append(" MATCH_ID, TEAM_ID, SCDL, LCTN_ID, PRNT_LCNT_ID, ");
				query.append(" CRT_DT, TEAM_POINT, ATEAM_ID, PLAYFIELD ) ");
				query.append(" VALUES ( ");
				query.append(" 'MA-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(MATCH_ID_SEQ.NEXTVAL,6,0), ");
				query.append(" ?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, SYSDATE, 0, ?, ? ) ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, matchVO.getTeamId());
				pstmt.setString(2, matchVO.getSchedule());
				pstmt.setString(3, matchVO.getLocationId());
				pstmt.setString(4, matchVO.getParentLocaionId());
				pstmt.setString(5, null);
				pstmt.setString(6, matchVO.getPlayField());

				return pstmt;
			}
		});
	}

	@Override
	public List<MatchVO> getMatchApplyTeamsOf(String locationId) {

		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	M.MATCH_ID ");
				query.append(" 			, M.TEAM_ID ");
				query.append(" 			, TO_CHAR(M.SCDL, 'YYYY-MM-DD') SCDL ");
				query.append(" 			, M.LCTN_ID ");
				query.append(" 			, M.CRT_DT ");
				query.append(" 			, M.TEAM_POINT ");
				query.append(" 			, M.ATEAM_ID ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		MATCH M ");
				query.append(" 			, TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	M.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.ATEAM_ID = NULL ");

				if (!locationId.equals("0")) {
					query.append(" AND		PRNT_LCNT_ID = ? ");
				}

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 1;
				if (!locationId.equals("0")) {
					pstmt.setString(index++, locationId);
				}

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<MatchVO> matchTeams = new ArrayList<MatchVO>();
				MatchVO matchTeam = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;

				while (rs.next()) {
					matchTeam = new MatchVO();
					matchTeam.setMatchId(rs.getString("MATCH_ID"));
					matchTeam.setTeamId(rs.getString("TEAM_ID"));
					matchTeam.setSchedule(rs.getString("SCDL"));
					matchTeam.setLocationId(rs.getString("LCTN_ID"));
					matchTeam.setCreateDate(rs.getString("CRT_DT"));
					matchTeam.setMatchPoint(rs.getString("TEAM_POINT"));
					matchTeam.setAwayTeamId(rs.getString("ATEAM_ID"));
					matchTeam.setPlayField(rs.getString("PLAYFIELD"));

					teamVO = matchTeam.getTeamVO();
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));

					locationVO = teamVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					locationVO = matchTeam.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchTeams.add(matchTeam);

				}

				return matchTeams;
			}
		});
	}

	@Override
	public List<MatchVO> getAllMatchTeam(SearchMatchVO searchMatch) {
		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	TO_CHAR(M.SCDL,'YYYY-MM-DD') SCDL ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			, T.TEAM_ID ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T2.TEAM_ID ATEAM_ID");
				query.append(" 			, T2.TEAM_NM ATEAM_NM ");
				query.append(" 			, T2.TEAM_PHOTO ATEAM_PHOTO ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		 MATCH M ");
				query.append(" 			, TEAM T ");
				query.append(" 			, TEAM T2 ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	M.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.ATEAM_ID = T2.TEAM_ID(+) ");
				query.append(" AND		M.ATEAM_ID NOT NULL ");
				
				String pagingQuery = appendPagingQueryFormat(query.toString());
				
				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);
				int index = 1;
				
				pstmt.setInt(index++, searchMatch.getEndRowNumber());
				pstmt.setInt(index++, searchMatch.getStartRowNumber());
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<MatchVO> matchTeams = new ArrayList<MatchVO>();
				MatchVO matchTeam = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;
				AwayTeamVO awayTeamVO = null;
				while (rs.next()) {
					matchTeam = new MatchVO();
					matchTeam.setSchedule(rs.getString("SCDL"));
					matchTeam.setPlayField(rs.getString("PLAYFIELD"));

					teamVO = matchTeam.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					
					awayTeamVO = matchTeam.getAwayTeamVO();
					awayTeamVO.setTeamId(rs.getString("ATEAM_ID"));
					awayTeamVO.setTeamName(rs.getString("ATEAM_NM"));
					awayTeamVO.setTeamPhoto(rs.getString("ATEAM_PHOTO"));

					locationVO = matchTeam.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchTeams.add(matchTeam);

				}

				return matchTeams;
			}
		});
	}

	@Override
	public int doMatch(String matchId, String awayTeamId) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	MATCH ");
				query.append(" SET		ATEAM_ID = ? ");
				query.append(" WHERE	MATCH_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, awayTeamId);
				pstmt.setString(2, matchId);

				return pstmt;
			}
		});
	}

	@Override
	public List<MatchVO> getCompleteMatch(String teamId) {

		return selectList(new QueryAndResult() {

			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	T.TEAM_PHOTO TEAM_PHOTO ");
				query.append(" 			,T2.TEAM_PHOTO ATEAM_PHOTO ");
				query.append(" 			,T.TEAM_NM TEAM_NM ");
				query.append(" 			,T2.TEAM_NM ATEAM_NM ");
				query.append(" 			,L.LCTN_NM ");
				query.append(" 			,L.PRNT_LCTN_NM ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			,TO_CHAR(M.SCDL, 'YYYY-MM-DD') SCDL ");
				query.append(" 			,T.TEAM_ID TEAM_ID ");
				query.append(" 			,T2.TEAM_ID ATEAM_ID ");
				query.append(" FROM		TEAM T ");
				query.append(" 			,TEAM T2 ");
				query.append("			, MATCH M ");
				query.append("			,LCTN L ");
				query.append(" WHERE	T.TEAM_ID = M.TEAM_ID ");
				query.append(" AND		M.ATEAM_ID = T2.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.ATEAM_ID NOT NULL ");
				query.append(" AND		( M.TEAM_ID = ? ");
				query.append(" OR		M.ATEAM_ID = ? ) ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				pstmt.setString(1, teamId);
				pstmt.setString(2, teamId);

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<MatchVO> matchCompleteTeam = new ArrayList<MatchVO>();
				TeamVO teamVO = null;
				MatchVO matchVO = null;
				LocationVO locationVO = null;
				AwayTeamVO awayTeamVO = null;

				while (rs.next()) {
					matchVO = new MatchVO();
					matchVO.setSchedule(rs.getString("SCDL"));
					matchVO.setPlayField(rs.getString("PLAYFIELD"));

					teamVO = matchVO.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					
					awayTeamVO = matchVO.getAwayTeamVO();
					awayTeamVO.setTeamId(rs.getString("ATEAM_ID"));
					awayTeamVO.setTeamPhoto(rs.getString("ATEAM_PHOTO"));
					awayTeamVO.setTeamName(rs.getString("ATEAM_NM"));
					
					locationVO = matchVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchCompleteTeam.add(matchVO);
				}

				return matchCompleteTeam;
			}
		});
	}

	@Override
	public int checkTheMatchTeam(MatchVO matchVO) {
		return (int) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		MATCH ");
				query.append(" WHERE	TEAM_ID = ?  ");

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

	@Override
	public int deleteTeamMatch(String teamId, String matchId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" DELETE ");
				query.append(" FROM		MATCH ");
				query.append(" WHERE	TEAM_ID = ?");
				query.append(" AND		MATCH_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, matchId);
				return pstmt;
			}
		});
	}
	
	@Override
	public int getCountOfMatchs(SearchMatchVO searchMatch) {

		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	 COUNT(1) CNT ");
				query.append(" FROM		 MATCH ");
				query.append(" WHERE	 ATEAM_ID NOT NULL ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
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
	public int deleteTeamMatchs(String teamId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" DELETE ");
				query.append(" FROM		MATCH ");
				query.append(" WHERE	TEAM_ID = ?");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);

				return pstmt;
			}
		});
	}

	@Override
	public List<MatchVO> getAllMatchTeams() {
		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	 M.MATCH_ID ");
				query.append(" 			, M.TEAM_ID ");
				query.append(" 			, TO_CHAR(M.SCDL, 'YYYY-MM-DD') SCDL ");
				query.append(" 			, M.LCTN_ID ");
				query.append(" 			, M.CRT_DT ");
				query.append(" 			, M.TEAM_POINT ");
				query.append(" 			, M.ATEAM_ID ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		 MATCH M ");
				query.append(" 			, TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	M.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<MatchVO> matchTeams = new ArrayList<MatchVO>();
				MatchVO matchTeam = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;

				while (rs.next()) {
					matchTeam = new MatchVO();
					matchTeam.setMatchId(rs.getString("MATCH_ID"));
					matchTeam.setTeamId(rs.getString("TEAM_ID"));
					matchTeam.setSchedule(rs.getString("SCDL"));
					matchTeam.setLocationId(rs.getString("LCTN_ID"));
					matchTeam.setCreateDate(rs.getString("CRT_DT"));
					matchTeam.setMatchPoint(rs.getString("TEAM_POINT"));
					matchTeam.setAwayTeamId(rs.getString("ATEAM_ID"));
					matchTeam.setPlayField(rs.getString("PLAYFIELD"));

					teamVO = matchTeam.getTeamVO();
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));

					locationVO = matchTeam.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchTeams.add(matchTeam);

				}
				return matchTeams;
			}
		});
	}

	@Override
	public int deleteAdminTeamMatch(String matchId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" DELETE ");
				query.append(" FROM		MATCH ");
				query.append(" WHERE	MATCH_ID = ?");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, matchId);

				return pstmt;
			}
		});
	}

	@Override
	public List<MatchVO> getAllTeamMatchs(SearchMatchVO searchTeamMatch) {
		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	TO_CHAR(M.SCDL,'YYYY-MM-DD') SCDL ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			, M.MATCH_ID ");
				query.append(" 			, M.CRT_DT ");
				query.append(" 			, T.TEAM_ID ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T2.TEAM_ID ATEAM_ID");
				query.append(" 			, T2.TEAM_NM ATEAM_NM ");
				query.append(" 			, T2.TEAM_PHOTO ATEAM_PHOTO ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		 MATCH M ");
				query.append(" 			, TEAM T ");
				query.append(" 			, TEAM T2 ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	M.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.ATEAM_ID = T2.TEAM_ID(+) ");
				
				if (searchTeamMatch.getSearchType() == 1) {
					query.append(" AND	( M.MATCH_ID LIKE '%'|| ?|| '%') ");
				}
				if (searchTeamMatch.getSearchType() == 2) {
					query.append(" AND	( T.TEAM_NM LIKE '%'|| ?|| '%') ");
				}
				if (searchTeamMatch.getSearchType() == 3) {
					query.append(" AND	( M.SCDL LIKE '%'|| ?|| '%') ");
				}
				if (searchTeamMatch.getSearchType() == 4) {
					query.append(" AND	( L.LCTN_NM LIKE '%'|| ?|| '%') ");
				}
				
				query.append(" ORDER	BY	CRT_DT DESC ");
				

				String pagingQuery = appendPagingQueryFormat(query.toString());
				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);

				int index = 1;
				if (searchTeamMatch.getSearchType() == 1) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 2) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 3) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 4) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}

				pstmt.setInt(index++, searchTeamMatch.getEndRowNumber());
				pstmt.setInt(index++, searchTeamMatch.getStartRowNumber());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<MatchVO> matchTeams = new ArrayList<MatchVO>();
				MatchVO matchTeam = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;
				AwayTeamVO awayTeamVO = null;
				while (rs.next()) {
					matchTeam = new MatchVO();
					matchTeam.setSchedule(rs.getString("SCDL"));
					matchTeam.setPlayField(rs.getString("PLAYFIELD"));
					matchTeam.setMatchId(rs.getString("MATCH_ID"));
					matchTeam.setCreateDate(rs.getString("CRT_DT"));

					teamVO = matchTeam.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					
					awayTeamVO = matchTeam.getAwayTeamVO();
					awayTeamVO.setTeamId(rs.getString("ATEAM_ID"));
					awayTeamVO.setTeamName(rs.getString("ATEAM_NM"));
					awayTeamVO.setTeamPhoto(rs.getString("ATEAM_PHOTO"));

					locationVO = matchTeam.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchTeams.add(matchTeam);

				}

				return matchTeams;
			}
		});
	}

	@Override
	public int getCountOfTeamMatchs(SearchMatchVO searchTeamMatch) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		MATCH M, LCTN L, TEAM T ");
				query.append(" WHERE	M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.TEAM_ID = T.TEAM_ID ");
			
				
				if (searchTeamMatch.getSearchType() == 1) {
					query.append(" AND	( M.MATCH_ID LIKE '%'|| ?|| '%' ) ");
				} 
				else if (searchTeamMatch.getSearchType() == 2) {
					query.append(" AND	( T.TEAM_NM LIKE '%'|| ?|| '%' ) ");
				} 
				else if (searchTeamMatch.getSearchType() == 3) {
					query.append(" AND	( M.SCDL LIKE '%'|| ?|| '%' ) ");
				} 
				else if (searchTeamMatch.getSearchType() == 4) {
					query.append(" AND	( L.LCTN_NM LIKE '%'|| ?|| '%' ) ");
				}
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				int index = 1;
				if (searchTeamMatch.getSearchType() == 1) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 2) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 3) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
				}
				if (searchTeamMatch.getSearchType() == 4) {
					pstmt.setString(index++, searchTeamMatch.getSearchKeyword());
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
	public List<MatchVO> getAllMatchList() {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();

				query.append(" SELECT	TO_CHAR(M.SCDL,'YYYY-MM-DD') SCDL ");
				query.append(" 			, M.PLAYFIELD ");
				query.append(" 			, T.TEAM_ID ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T2.TEAM_ID ATEAM_ID");
				query.append(" 			, T2.TEAM_NM ATEAM_NM ");
				query.append(" 			, T2.TEAM_PHOTO ATEAM_PHOTO ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		 MATCH M ");
				query.append(" 			, TEAM T ");
				query.append(" 			, TEAM T2 ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	M.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		M.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		M.ATEAM_ID = T2.TEAM_ID(+) ");
				query.append(" AND		M.ATEAM_ID NOT NULL ");
								
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<MatchVO> matchTeams = new ArrayList<MatchVO>();
				MatchVO matchTeam = null;
				TeamVO teamVO = null;
				LocationVO locationVO = null;
				AwayTeamVO awayTeamVO = null;
				while (rs.next()) {
					matchTeam = new MatchVO();
					matchTeam.setSchedule(rs.getString("SCDL"));
					matchTeam.setPlayField(rs.getString("PLAYFIELD"));

					teamVO = matchTeam.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					
					awayTeamVO = matchTeam.getAwayTeamVO();
					awayTeamVO.setTeamId(rs.getString("ATEAM_ID"));
					awayTeamVO.setTeamName(rs.getString("ATEAM_NM"));
					awayTeamVO.setTeamPhoto(rs.getString("ATEAM_PHOTO"));

					locationVO = matchTeam.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					matchTeams.add(matchTeam);

				}

				return matchTeams;
			}
		});
	}

}
