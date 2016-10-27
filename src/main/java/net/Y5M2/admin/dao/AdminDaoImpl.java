package net.Y5M2.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public class AdminDaoImpl extends DaoSupport implements AdminDao{

	@Override
	public List<TeamBoardVO> getAllTeamBoards(SearchTeamVO searchTeam, TeamBoardVO teamBoardVO) {
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

				if (searchTeam.getSearchType() == 1) {
					query.append(" AND	( TB.TBOARD_SUB LIKE '%'|| ?|| '%' ");
					query.append(" OR	U.USR_NM LIKE '%' || ? || '%' ) ");
				}
				if (searchTeam.getSearchType() == 2) {
					query.append(" AND	( TB.TBOARD_SUB LIKE '%'|| ?|| '%') ");
				}
				if (searchTeam.getSearchType() == 3) {
					query.append(" AND	( U.USR_NM LIKE '%'|| ?|| '%') ");
				}

				query.append(" ORDER	BY	CRT_DT DESC ");

				String pagingQuery = appendPagingQueryFormat(query.toString());

				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);

				int index = 1;

				if (searchTeam.getSearchType() == 1) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				if (searchTeam.getSearchType() == 2) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}
				if (searchTeam.getSearchType() == 3) {
					pstmt.setString(index++, searchTeam.getSearchKeyword());
				}

				pstmt.setInt(index++, searchTeam.getEndRowNumber());
				pstmt.setInt(index++, searchTeam.getStartRowNumber());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<TeamBoardVO> teams = new ArrayList<TeamBoardVO>();

				TeamBoardVO teamBoardVO = null;
				UserVO userVO = null;
				TeamVO teamVO = null;
				while (rs.next()) {
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
	public int getCountOfTeamBoards() {
		return (int) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TBOARD ");

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
	public int getCountOfTeamMatchs() {
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		MATCH ");

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
}
