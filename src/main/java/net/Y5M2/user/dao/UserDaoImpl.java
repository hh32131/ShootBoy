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
				query.append(" INSERT INTO USR ( ");
				query.append(" USR_ID, USR_EMAIL, USR_PWD, USR_NM, ");
				query.append(" USR_PHN, USR_AGE, USR_POSIT, PWD_HINT, ");
				query.append(" PWD_ANSER, TEAM_ID, LCTN_ID, LTST_MODY_DT, CRT_DT, LV_ID ) ");
				query.append(" VALUES			(  ");
				query.append(" 'UR-'||TO_CHAR(SYSDATE, 'YYYYMMDD')|| '-'|| LPAD(USR_ID_SEQ.NEXTVAL, 6, 0) ,  ");
				query.append(" ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, SYSDATE, SYSDATE, '일반' )  ");
				
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());
				pstmt.setString(2, userVO.getPassword());
				pstmt.setString(3, userVO.getUserName());
				pstmt.setString(4, userVO.getPhoneNumber());
				pstmt.setString(5, userVO.getAge());
				pstmt.setString(6, userVO.getPosition());
				pstmt.setString(7, userVO.getPasswordHint());
				pstmt.setString(8, userVO.getPasswordAnswer());
				pstmt.setString(9, userVO.getTeamId());
				pstmt.setString(10, userVO.getLocationId());
				
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
