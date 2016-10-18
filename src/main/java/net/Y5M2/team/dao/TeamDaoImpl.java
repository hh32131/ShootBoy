package net.Y5M2.team.dao;

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
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamVO;

public class TeamDaoImpl extends DaoSupport implements TeamDao{

	@Override
	public int addTeam(TeamVO teamVO) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT INTO	TEAM ( ");
				query.append(" 					TEAM_ID ");
				query.append(" 					,TEAM_CNT ");
				query.append(" 					,TEAM_NM ");
				query.append(" 					,TEAM_PHOTO ");
				query.append(" 					,CRT_DT ");
				query.append(" 					,TEAM_POINT ");
				query.append(" 					,LTST_MODY_DT ");
				query.append(" 					,TEAM_INFO ");
				query.append(" 					,LCTN_ID )");
				query.append(" VALUES		 ( ");
				query.append(" 'TEAM-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(TEAM_ID_SEQ.NEXTVAL,6,0) ");
				query.append(" , ?, ?, ?, SYSDATE, 0, SYSDATE, ?, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, teamVO.getTeamCount());
				pstmt.setString(2, teamVO.getTeamName());
				pstmt.setString(3, teamVO.getTeamPhoto());
				pstmt.setString(4, teamVO.getTeamInfo());
				pstmt.setString(5, teamVO.getLocationId());
				return pstmt;
			}
		});
	}

	@Override
	public List<TeamVO> getAllTeam(SearchTeamVO searchTeam) {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	T.TEAM_ID ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.LCTN_ID = L.LCTN_ID ");
				
				
				if ( searchTeam.getSearchType() == 1 ) {
					query.append(" AND	( T.TEAM_NM LIKE '%'|| ?|| '%' ");
					query.append(" OR	T.TEAM_INFO LIKE '%' || ? || '%' ) ");
				}
				if ( searchTeam.getSearchType() == 2 ) {
					query.append(" AND	( T.TEAM_NM LIKE '%'|| ?|| '%') ");
				}
				if ( searchTeam.getSearchType() == 3 ) {
					query.append(" AND	( T.TEAM_INFO LIKE '%'|| ?|| '%') ");
				}
				if ( searchTeam.getSearchType() == 4 ) {
					query.append(" AND	( U.USR_NM LIKE '%'|| ?|| '%') ");
				}
				
				query.append(" ORDER	BY	CRT_DT DESC ");
				String pagingQuery = appendPagingQueryFormat(query.toString());
				
				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);
				
				int index = 1;
				if ( searchTeam.getSearchType() == 1 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				if ( searchTeam.getSearchType() == 2 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				if ( searchTeam.getSearchType() == 3 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				if ( searchTeam.getSearchType() == 4 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				
				pstmt.setInt(index++, searchTeam.getEndRowNumber());
				pstmt.setInt(index++, searchTeam.getStartRowNumber());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<TeamVO> teams = new ArrayList<TeamVO>();
				
				TeamVO teamVO =null;
				LocationVO locationVO = null;
				while( rs.next() ) {
					teamVO = new TeamVO();
					
					teamVO.setTeamId(rs.getString("TEAM_ID"));	
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));	
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					
					locationVO = teamVO.getLocationVO();
					locationVO.setLocationId(rs.getString("LCTN_ID"));
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));
					teams.add(teamVO);
				}
				return teams;
			}
		});
	}

	@Override
	public TeamVO getTeamAt(String teamId) {
		return (TeamVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	T.TEAM_ID ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.LCTN_ID = L.LCTN_ID ");
				query.append(" AND	T.TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				TeamVO team = null;
				LocationVO location = null;
				if( rs.next() ) {

					team = new TeamVO();
					team.setTeamId(rs.getString("TEAM_ID"));	
					team.setTeamCount(rs.getInt("TEAM_CNT"));	
					team.setTeamName(rs.getString("TEAM_NM"));
					team.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					team.setCreateDate(rs.getString("CRT_DT"));
					team.setTeamPoint(rs.getInt("TEAM_POINT"));
					team.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					team.setTeamInfo(rs.getString("TEAM_INFO"));
					
					location = team.getLocationVO();
					location.setLocationId(rs.getString("LCTN_ID"));
					location.setLocationName(rs.getString("LCTN_NM"));
					location.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					location.setParentLocationName(rs.getString("PRNT_LCTN_NM"));
					
				}
				
				return team;
			}
		});
	}
	
	@Override
	public TeamVO getTeamInfoForUpdate(String teamName) {

		return (TeamVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	T.TEAM_ID ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.LCTN_ID = L.LCTN_ID ");
				query.append(" AND	T.TEAM_NM = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamName);
				
				return pstmt;
				
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				TeamVO team = null;
				LocationVO location = null;
				if( rs.next() ) {

					team = new TeamVO();
					team.setTeamId(rs.getString("TEAM_ID"));	
					team.setTeamCount(rs.getInt("TEAM_CNT"));	
					team.setTeamName(rs.getString("TEAM_NM"));
					team.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					team.setCreateDate(rs.getString("CRT_DT"));
					team.setTeamPoint(rs.getInt("TEAM_POINT"));
					team.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					team.setTeamInfo(rs.getString("TEAM_INFO"));
					
					location = team.getLocationVO();
					location.setLocationId(rs.getString("LCTN_ID"));
					location.setLocationName(rs.getString("LCTN_NM"));
					location.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					location.setParentLocationName(rs.getString("PRNT_LCTN_NM"));
					
				}
				
				return team;
			}
		});
	}

	@Override
	public int getCountOfTeams(SearchTeamVO searchTeam) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TEAM T ");
				
				if ( searchTeam.getSearchType() == 1 ) {
					query.append(" WHERE	( T.TEAM_NM LIKE '%'|| ?|| '%' ");
					query.append(" OR	T.TEAM_INFO LIKE '%' || ? || '%' ) ");
				}
				else if ( searchTeam.getSearchType() == 2 ) {
					query.append(" WHERE	( T.TEAM_NM LIKE '%'|| ?|| '%') ");
				}
				else if ( searchTeam.getSearchType() == 3 ) {
					query.append(" WHERE	( T.TEAM_INFO LIKE '%'|| ?|| '%') ");
				}
				
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 1;
				if ( searchTeam.getSearchType() == 1 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				else if ( searchTeam.getSearchType() == 2 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				else if ( searchTeam.getSearchType() == 3 ) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
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
	
}
