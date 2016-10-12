package net.Y5M2.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
import net.Y5M2.support.QueryAndResult;
import net.Y5M2.user.vo.UserVO;

public class UserDaoImpl extends DaoSupport implements UserDao {

	@Override
	public int signUpUser(UserVO userVO) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
			
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				return pstmt;
			}
		});
	}
	
	
	@Override
	public UserVO getUserBy(UserVO userVO) {

		return (UserVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	USR_ID ");
				query.append(" 			, USR_EMAIL ");
				query.append(" 			, USR_PWD ");
				query.append(" 			, USR_NM ");
				query.append(" 			, USR_PHN ");
				query.append(" 			, USR_AGE ");
				query.append(" 			, USR_POSIT ");
				query.append(" 			, TEAM_ID ");
				query.append(" 			, LV_ID ");
				query.append(" 			, LCTN_ID ");
				query.append(" 			, TO_CHAR(LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" 			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, PWD_HINT ");
				query.append(" 			, PWD_ANSER ");
				query.append(" FROM		USR ");
				query.append(" WHERE	USR_EMAIL = ? ");
				query.append(" AND		USR_PWD = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());
				pstmt.setString(2, userVO.getPassword());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				UserVO userVO = null;
				if(rs.next()){
					userVO = new UserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setEmail(rs.getString("USR_EMAIL"));
					userVO.setPassword(rs.getString("USR_PWD"));
					userVO.setUserName(rs.getString("USR_NM"));
					userVO.setPhoneNumber(rs.getString("USR_PHN"));
					userVO.setAge(rs.getString("USR_AGE"));
					userVO.setPosition(rs.getString("USR_POSIT"));
					userVO.setTeamId(rs.getString("TEAM_ID"));
					userVO.setLevelId(rs.getString("LV_ID"));
					userVO.setLocationId(rs.getString("LCTN_ID"));
					userVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					userVO.setCreateDate(rs.getString("CRT_DT"));
					userVO.setPasswordHint(rs.getString("PWD_HINT"));
					userVO.setPasswordAnswer(rs.getString("PWD_ANSER"));
				}
					
					
				return userVO;
			}
		});
	}
}
