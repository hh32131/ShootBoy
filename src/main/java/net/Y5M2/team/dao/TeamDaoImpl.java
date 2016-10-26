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
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

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

	@SuppressWarnings("unchecked")
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
				query.append("			, TO_CHAR(T.CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT ");
				query.append("   		, TO_CHAR(T.LTST_MODY_DT, 'YYYY-DD-MM HH24:MI:SS') LTST_MDFY_DT  ");
				query.append(" 			, T.TEAM_POINT ");
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
					teamVO.setLatestModifyDate(rs.getString("LTST_MDFY_DT"));
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
				query.append("			, TO_CHAR(T.CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT ");
				query.append("   		, TO_CHAR(T.LTST_MODY_DT, 'YYYY-DD-MM HH24:MI:SS') LTST_MDFY_DT  ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		T.TEAM_ID = ? ");
				
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
					team.setLatestModifyDate(rs.getString("LTST_MDFY_DT"));
					team.setTeamInfo(rs.getString("TEAM_INFO"));
					team.setLocationId(rs.getString("LCTN_ID"));
					
					location = team.getLocationVO();
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
				query.append(" 			, T.TEAM_POINT ");
				query.append("			, TO_CHAR(T.CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT ");
				query.append("   		, TO_CHAR(T.LTST_MODY_DT, 'YYYY-DD-MM HH24:MI:SS') LTST_MDFY_DT  ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
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
					team.setLatestModifyDate(rs.getString("LTST_MDFY_DT"));
					team.setTeamInfo(rs.getString("TEAM_INFO"));
					team.setLocationId(rs.getString("LCTN_ID"));
					
					location = team.getLocationVO();
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
	
	@Override
	public int updateTeamInfo(TeamVO teamVO) {

		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	TEAM ");
				query.append(" SET		LTST_MODY_DT = SYSDATE ");
				
				if(teamVO.getTeamName() != null){
					query.append(" 		, TEAM_NM = ? ");
				}
				if(teamVO.getTeamCount() != 0){
					query.append(" 		, TEAM_CNT = ? ");
				}
				if(teamVO.getLocationId() != null){
					query.append(" 		, LCTN_ID = ? ");
				}
				if(teamVO.getTeamInfo() != null){
					query.append(" 		, TEAM_INFO = ? ");
				}
				if(teamVO.getTeamPhoto() != null){
					query.append(" 		, TEAM_PHOTO = ? ");
				}
				query.append(" WHERE	TEAM_ID = ? ");
				
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				int index = 1;
				
				if(teamVO.getTeamName() != null){
					pstmt.setString(index++, teamVO.getTeamName());
				}
				if(teamVO.getTeamCount() != 0){
					pstmt.setInt(index++, teamVO.getTeamCount());
				}
				if(teamVO.getLocationId() != null){
					pstmt.setString(index++, teamVO.getLocationId());
				}
				if(teamVO.getTeamInfo() != null){
					pstmt.setString(index++, teamVO.getTeamInfo());
				}
				if(teamVO.getTeamPhoto() != null){
					pstmt.setString(index++, teamVO.getTeamPhoto());
				}
				pstmt.setString(index++, teamVO.getTeamId());
				
				return pstmt;
			}
		});
	}

	@Override
	public int deleteTeam(String teamId) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" DELETE ");
				query.append(" FROM		TEAM ");
				query.append(" WHERE	TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				return pstmt;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamVO> getAllTeams() {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	T.TEAM_ID ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.TEAM_POINT ");
				query.append("			, TO_CHAR(T.CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT ");
				query.append("   		, TO_CHAR(T.LTST_MODY_DT, 'YYYY-DD-MM HH24:MI:SS') LTST_MDFY_DT  ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, L.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TEAM T ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	T.LCTN_ID = L.LCTN_ID ");
				query.append(" ORDER	BY	CRT_DT DESC ");
				
				PreparedStatement pstmt =conn.prepareStatement(query.toString());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				TeamVO teamVO = null;
				List<TeamVO> teams = new ArrayList<TeamVO>();
				LocationVO locationVO = null;
				
				while( rs.next()){
					teamVO = new TeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MDFY_DT"));
					
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
	public int isExsistTeam(String teamName) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TEAM ");
				query.append(" WHERE	TEAM_NM = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamName);
				
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
	public int getCountOfTeam(String teamId) {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TEAM T ");

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
	public List<TeamBoardVO> getAllTeamBoards(SearchTeamVO searchTeam) {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT			TB.TBOARD_ID ");
				query.append(" 					,U.USR_ID ");
				query.append(" 					,TB.TBOARD_SUB ");
				query.append(" 					,TB.RCMD_CNT ");
				query.append(" 					,TB.TBOARD_CONT ");
				query.append(" 					,TB.CRT_DT ");
				query.append(" 					,U.USR_NM ");
				query.append(" 					,TB.LTST_MODY_DT ");
				query.append(" 					,T.TEAM_ID ");
				query.append(" 					,T.TEAM_NM ");
				query.append(" 					,TB.FILE_NM ");
				query.append(" 					,TB.REPLY_HIT_CNT ");
				query.append(" FROM		TEAM T, TBOARD TB, USR U ");
				query.append(" WHERE	U.USR_ID = TB.USR_ID ");
				query.append(" AND		TB.TEAM_ID = T.TEAM_ID ");

				
				
				if ( searchTeam.getSearchType() == 1 ) {
					query.append(" AND	( TB.TBOARD_SUB LIKE '%'|| ?|| '%' ");
					query.append(" OR	U.USR_NM LIKE '%' || ? || '%' ) ");
				}
				if ( searchTeam.getSearchType() == 2 ) {
					query.append(" AND	( TB.TBOARD_SUB LIKE '%'|| ?|| '%') ");
				}
				if ( searchTeam.getSearchType() == 3 ) {
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
		
				
				pstmt.setInt(index++, searchTeam.getEndRowNumber());
				pstmt.setInt(index++, searchTeam.getStartRowNumber());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<TeamBoardVO> teams = new ArrayList<TeamBoardVO>();
				
				TeamBoardVO teamBoardVO =null;
				UserVO userVO = null;
				TeamVO teamVO = null;
				while( rs.next() ) {
					teamBoardVO = new TeamBoardVO();
					
					teamBoardVO.setTeamBoardId(rs.getString("TBOARD_ID"));	
					teamBoardVO.setTeamBoardSubject(rs.getString("TBOARD_SUB"));	
					teamBoardVO.setTeamBoardRecommendCount(rs.getInt("RCMD_CNT"));
					teamBoardVO.setTeamBoardContent(rs.getString("TBOARD_CONT"));
					teamBoardVO.setCreateDate(rs.getString("CRT_DT"));
					teamBoardVO.setTeamId(rs.getString("TEAM_ID"));
					teamBoardVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamBoardVO.setFileName(rs.getString("FILE_NM"));
					teamBoardVO.setReplyHitCount(rs.getInt("REPLY_HIT_CNT"));
					
					teamVO = teamBoardVO.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));

					
					userVO = teamBoardVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
				
					teams.add(teamBoardVO);
				}
				return teams;
			}
		});
	}

	@Override
	public TeamBoardVO getTeamBoardAt(String teamBoardId) {
		return (TeamBoardVO) selectOne(new QueryAndResult() {
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT			TB.TBOARD_ID ");
				query.append(" 					,U.USR_ID ");
				query.append(" 					,TB.TBOARD_SUB ");
				query.append(" 					,TB.RCMD_CNT ");
				query.append(" 					,TB.TBOARD_CONT ");
				query.append(" 					,TB.CRT_DT ");
				query.append(" 					,U.USR_NM ");
				query.append(" 					,TB.LTST_MODY_DT ");
				query.append(" 					,T.TEAM_ID ");
				query.append(" 					,T.TEAM_NM ");
				query.append(" 					,TB.FILE_NM ");
				query.append(" 					,TB.REPLY_HIT_CNT ");
				query.append(" FROM		TEAM T, TBOARD TB, USR U ");
				query.append(" WHERE	U.USR_ID = TB.USR_ID ");
				query.append(" AND		TB.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		TB.TBOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamBoardId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				TeamBoardVO teamBoardVO =null;
				UserVO userVO = null;
				TeamVO teamVO = null;
				if( rs.next() ) {
					teamBoardVO = new TeamBoardVO();
					
					teamBoardVO.setTeamBoardId(rs.getString("TBOARD_ID"));	
					teamBoardVO.setTeamBoardSubject(rs.getString("TBOARD_SUB"));	
					teamBoardVO.setTeamBoardRecommendCount(rs.getInt("RCMD_CNT"));
					teamBoardVO.setTeamBoardContent(rs.getString("TBOARD_CONT"));
					teamBoardVO.setCreateDate(rs.getString("CRT_DT"));
					teamBoardVO.setTeamId(rs.getString("TEAM_ID"));
					teamBoardVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamBoardVO.setFileName(rs.getString("FILE_NM"));
					teamBoardVO.setReplyHitCount(rs.getInt("REPLY_HIT_CNT"));
					
					teamVO = teamBoardVO.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));

					
					userVO = teamBoardVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
				
				}
				return teamBoardVO;
			}
		});
	}

	@Override
	public int addTeamBoard(TeamBoardVO teamBoardVO) {
			return insert(new Query() {
				
				@Override
				public PreparedStatement query(Connection conn) throws SQLException {
					StringBuffer query = new StringBuffer();
					
					query.append(" INSERT INTO	TBOARD ( ");
					query.append(" 					TBOARD_ID ");
					query.append(" 					,USR_ID ");
					query.append(" 					,TBOARD_SUB ");
					query.append(" 					,RCMD_CNT ");
					query.append(" 					,TBOARD_CONT ");
					query.append(" 					,CRT_DT ");
					query.append(" 					,LTST_MODY_DT ");
					query.append(" 					,TEAM_ID ");
					query.append(" 					,FILE_NM ");
					query.append(" 					,REPLY_HIT_CNT )");
					query.append(" VALUES		 ( ");
					query.append(" 'TEAMBOARD-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(TBOARD_ID_SEQ.NEXTVAL,6,0) ");
					query.append(" , ?, ?, 0, ?, SYSDATE, SYSDATE, ?, ?, 0 ) ");
					
					PreparedStatement pstmt = conn.prepareStatement(query.toString());
					pstmt.setString(1, teamBoardVO.getUserId());
					pstmt.setString(2, teamBoardVO.getTeamBoardSubject());
					pstmt.setString(3, teamBoardVO.getTeamBoardContent());
					pstmt.setString(4, teamBoardVO.getTeamId());
					pstmt.setString(5, teamBoardVO.getFileName());
					
					return pstmt;
				}
			});
		}

	@Override
	public int hitCountUpdate(String teamBoardId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	TBOARD ");
				query.append(" SET		RCMD_CNT = RCMD_CNT + 1 ");
				query.append(" WHERE	TBOARD_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamBoardId);
				
				return pstmt;
			}
		});
	}

	@Override
	public int deleteTeamBoard(String teamBoardId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM		TBOARD ");
				query.append(" WHERE	TBOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamBoardId);
				
				return pstmt;
			}
		});
	}

	@Override
	public int modifyTeamBoard(TeamBoardVO teamBoardVO) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	TBOARD ");
				query.append(" SET		LTST_MODY_DT = SYSDATE ");

				if (teamBoardVO.getTeamBoardSubject() != null) {
					query.append(" , TBOARD_SUB = ? ");
				}

				if (teamBoardVO.getTeamBoardContent() != null) {
					query.append(" , TBOARD_CONT = ? ");
				}

				if (teamBoardVO.getFileName() != null) {
					query.append(" , FILE_NM = ? ");
				}
				query.append(" WHERE	TBOARD_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				int index = 1;

				if (teamBoardVO.getTeamBoardSubject() != null) {
					pstmt.setString(index++, teamBoardVO.getTeamBoardSubject());
				}

				if (teamBoardVO.getTeamBoardContent() != null) {
					pstmt.setString(index++, teamBoardVO.getTeamBoardSubject());
				}

				if (teamBoardVO.getFileName() != null) {
					pstmt.setString(index++, teamBoardVO.getFileName());
				}

				pstmt.setString(index++, teamBoardVO.getTeamBoardId());

				return pstmt;
			}
		});
	}

	@Override
	public TeamBoardVO getTeamBoardForModify(String teamBoardId) {
		return (TeamBoardVO) selectOne(new QueryAndResult() {
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT			TB.TBOARD_ID ");
				query.append(" 					,U.USR_ID ");
				query.append(" 					,TB.TBOARD_SUB ");
				query.append(" 					,TB.RCMD_CNT ");
				query.append(" 					,TB.TBOARD_CONT ");
				query.append(" 					,TB.CRT_DT ");
				query.append(" 					,U.USR_NM ");
				query.append(" 					,TB.LTST_MODY_DT ");
				query.append(" 					,T.TEAM_ID ");
				query.append(" 					,T.TEAM_NM ");
				query.append(" 					,TB.FILE_NM ");
				query.append(" 					,TB.REPLY_HIT_CNT ");
				query.append(" FROM		TEAM T, TBOARD TB, USR U ");
				query.append(" WHERE	U.USR_ID = TB.USR_ID ");
				query.append(" AND		TB.TEAM_ID = T.TEAM_ID ");
				query.append(" AND		TB.TBOARD_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamBoardId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				TeamBoardVO teamBoardVO =null;
				UserVO userVO = null;
				TeamVO teamVO = null;
				if( rs.next() ) {
					teamBoardVO = new TeamBoardVO();
					
					teamBoardVO.setTeamBoardId(rs.getString("TBOARD_ID"));	
					teamBoardVO.setTeamBoardSubject(rs.getString("TBOARD_SUB"));	
					teamBoardVO.setTeamBoardRecommendCount(rs.getInt("RCMD_CNT"));
					teamBoardVO.setTeamBoardContent(rs.getString("TBOARD_CONT"));
					teamBoardVO.setCreateDate(rs.getString("CRT_DT"));
					teamBoardVO.setTeamId(rs.getString("TEAM_ID"));
					teamBoardVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamBoardVO.setFileName(rs.getString("FILE_NM"));
					teamBoardVO.setReplyHitCount(rs.getInt("REPLY_HIT_CNT"));
					
					teamVO = teamBoardVO.getTeamVO();
					teamVO.setTeamId(rs.getString("TEAM_ID"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));

					
					userVO = teamBoardVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
				
				}
				return teamBoardVO;
			}
		});
	}
}
	
