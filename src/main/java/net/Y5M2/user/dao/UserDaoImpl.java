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
				query.append(" INSERT INTO ");
				
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				return pstmt;
			}
		});
	}
	
	@Override
	public int isExsist(String email) {
		
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT COUNT(1) CNT ");
				query.append(" FROM	 USR ");
				query.append(" WHERE USR_EMAIL = ?");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, email);
				
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
