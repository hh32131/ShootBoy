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
				query.append(" 			, TO_CAHR(LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" 			, TO_CAHR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
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
				
				
				if(rs.next())
				return null;
			}
		});
	}
}
