package net.Y5M2.teamjoin.dao;

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
import net.Y5M2.teamjoin.vo.TeamJoinVO;
import net.Y5M2.user.vo.UserVO;

public class TeamJoinDaoImpl extends DaoSupport implements TeamJoinDao {

	@Override
	public int SaveTeamJoinId(String teamId, UserVO userVO) {

		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO TJOIN ( ");
				query.append(" TJOIN_ID, TEAM_ID, USR_ID ) ");
				query.append(" VALUES (TJOIN_ID_SEQ.NEXTVAL, ?, ? ) ");

				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, userVO.getUserId());
				
				return pstmt;
			}
		});
	}
	
	@Override
	public int isExistTeamJoinApply(UserVO userVO) {

		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		TJOIN ");
				query.append(" WHERE	USR_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getUserId());
				
				
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
	public List<TeamJoinVO> getTeamJoinId(String teamId) {

		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	U.USR_ID ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, U.USR_AGE ");
				query.append(" 			, U.USR_PHN ");
				query.append(" 			, U.USR_POSIT ");
				query.append(" 			, U.USR_EMAIL ");
				query.append(" 			, U.LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		TJOIN J ");
				query.append(" 			, USR U ");
				query.append(" 			, LCTN L ");
				query.append(" WHERE	J.USR_ID = U.USR_ID ");
				query.append(" AND		U.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		J.TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				pstmt.setString(1, teamId);
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<TeamJoinVO> joins = new ArrayList<TeamJoinVO>();
				TeamJoinVO joinVO = null;
				UserVO userVO = null;
				LocationVO locationVO = null;
				while(rs.next()){
					joinVO = new TeamJoinVO();
					
					userVO = joinVO.getUserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setUserName(rs.getString("USR_NM"));
					userVO.setAge(rs.getString("USR_AGE"));
					userVO.setPhoneNumber(rs.getString("USR_PHN"));
					userVO.setPosition(rs.getString("USR_POSIT"));
					userVO.setEmail(rs.getString("USR_EMAIL"));
					userVO.setLocationId(rs.getString("LCTN_ID"));
					
					
					locationVO = userVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));
					
					joins.add(joinVO);
				}
				
				return joins;
			}
		});
	}
	
}
