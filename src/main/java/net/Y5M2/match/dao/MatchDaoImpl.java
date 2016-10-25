package net.Y5M2.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
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
				query.append(" ?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, SYSDATE, 0, 0, ? ) ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, matchVO.getTeamId());
				pstmt.setString(2, matchVO.getSchedule());
				pstmt.setString(3, matchVO.getLocationId());
				pstmt.setString(4, matchVO.getParentLocaionId());
				pstmt.setString(5, matchVO.getPlayField());

				return pstmt;
			}
		});
	}

	@Override
	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate) {

		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	M.MATCH_ID ");
				query.append(" 			, M.TEAM_ID ");
				query.append(" 			, M.SCDL ");
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
				query.append(" AND		M.ATEAM_ID = '0' ");

				if (locationId != null) {
					query.append(" AND		PRNT_LCNT_ID = ? ");
				}

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 1;
				if (locationId != null) {
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
	public List<MatchVO> getAllMatchTeam(String teamId) {
		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	 M.MATCH_ID ");
				query.append(" 			, M.TEAM_ID ");
				query.append(" 			, M.SCDL ");
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
				query.append(" AND		M.ATEAM_ID = '0' ");
				query.append(" AND		T.TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
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

}
