package net.Y5M2.user.dao;

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
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.SearchUserVO;
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
				query.append(" ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, SYSDATE, SYSDATE, '2' )  ");

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

	@Override
	public UserVO getUserBy(UserVO userVO) {

		return (UserVO) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	U.USR_ID ");
				query.append(" 			, U.USR_EMAIL ");
				query.append(" 			, U.USR_PWD ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, U.USR_PHN ");
				query.append(" 			, U.USR_AGE ");
				query.append(" 			, U.USR_POSIT ");
				query.append(" 			, U.TEAM_ID ");
				query.append(" 			, U.LV_ID ");
				query.append(" 			, U.LCTN_ID ");
				query.append(" 			, TO_CHAR(U.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" 			, TO_CHAR(U.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, U.PWD_HINT ");
				query.append(" 			, U.PWD_ANSER ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		USR U ");
				query.append(" 			, LCTN L ");
				query.append(" 			, TEAM T ");
				query.append(" WHERE	U.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		U.TEAM_ID = T.TEAM_ID(+) ");
				query.append(" AND		U.USR_EMAIL = ? ");
				query.append(" AND		U.USR_PWD = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());
				pstmt.setString(2, userVO.getPassword());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				UserVO userVO = null;
				LocationVO locationVO = null;
				TeamVO teamVO = null;

				if (rs.next()) {
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

					locationVO = userVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					teamVO = userVO.getTeamVO();
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));

				}

				return userVO;
			}
		});
	}

	@Override
	public UserVO findPassword(UserVO userVO) {
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

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				UserVO userVO = null;
				if (rs.next()) {
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

	@Override
	public int UpdateUserInfo(UserVO userInfo) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	USR ");
				query.append(" SET		LTST_MODY_DT = SYSDATE ");

				if (userInfo.getUserName() != null) {
					query.append(" 		, 	USR_NM = ? ");
				}
				if (userInfo.getPassword() != null) {
					query.append(" 		, 	USR_PWD = ? ");
				}
				if (userInfo.getPhoneNumber() != null) {
					query.append(" 		, 	USR_PHN = ? ");
				}
				if (userInfo.getAge() != null) {
					query.append(" 		, 	USR_AGE = ? ");
				}
				if (userInfo.getPosition() != null) {
					query.append(" 		, 	USR_POSIT = ? ");
				}
				if (userInfo.getLocationId() != null) {
					query.append(" 		, 	LCTN_ID = ? ");
				}
				query.append(" WHERE	USR_EMAIL = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				int index = 1;
				if (userInfo.getUserName() != null) {
					pstmt.setString(index++, userInfo.getUserName());
				}
				if (userInfo.getPassword() != null) {
					pstmt.setString(index++, userInfo.getPassword());
				}
				if (userInfo.getPhoneNumber() != null) {
					pstmt.setString(index++, userInfo.getPhoneNumber());
				}
				if (userInfo.getAge() != null) {
					pstmt.setString(index++, userInfo.getAge());
				}
				if (userInfo.getPosition() != null) {
					pstmt.setString(index++, userInfo.getPosition());
				}
				if (userInfo.getLocationId() != null) {
					pstmt.setString(index++, userInfo.getLocationId());
				}
				pstmt.setString(index++, userInfo.getEmail());

				return pstmt;
			}
		});
	}

	@Override
	public UserVO getUserInfoForModify(UserVO userInfo) {
		return (UserVO) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	U.USR_ID ");
				query.append(" 			, U.USR_EMAIL ");
				query.append(" 			, U.USR_PWD ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, U.USR_PHN ");
				query.append(" 			, U.USR_AGE ");
				query.append(" 			, U.USR_POSIT ");
				query.append(" 			, U.TEAM_ID ");
				query.append(" 			, U.LV_ID ");
				query.append(" 			, U.LCTN_ID ");
				query.append(" 			, TO_CHAR(U.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" 			, TO_CHAR(U.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, U.PWD_HINT ");
				query.append(" 			, U.PWD_ANSER ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		USR U ");
				query.append(" 			, LCTN L ");
				query.append(" 			, TEAM T ");
				query.append(" WHERE	U.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		U.TEAM_ID = T.TEAM_ID(+) ");
				query.append(" AND		U.USR_EMAIL = ? ");
				query.append(" ORDER	BY USR_ID DESC ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userInfo.getEmail());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				UserVO userVO = null;
				LocationVO locationVO = null;
				TeamVO teamVO = null;

				while (rs.next()) {
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

					locationVO = userVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					teamVO = userVO.getTeamVO();
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));

				}

				return userVO;
			}
		});
	}

	@Override
	public int UserTemaIdUpdate(String teamId, String userId) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	USR ");
				query.append(" SET		TEAM_ID = ? ");
				query.append(" 			, LV_ID = '3' ");
				query.append(" WHERE	USR_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, teamId);
				pstmt.setString(2, userId);
				return pstmt;

			}
		});
	}

	@Override
	public List<UserVO> getAllUsers(SearchUserVO searchUser) {
		return selectList(new QueryAndResult() {

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

				if (searchUser.getSearchType() == 1) {
					query.append(" WHERE	USR_EMAIL LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 2) {
					query.append(" WHERE	USR_NM LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 3) {
					query.append(" WHERE	USR_PHN LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 4) {
					query.append(" WHERE	USR_AGE LIKE '%'|| ?|| '%' ");
				}

				query.append(" ORDER	BY USR_ID DESC ");

				String pagingQuery = appendPagingQueryFormat(query.toString());
				PreparedStatement pstmt = conn.prepareStatement(pagingQuery);

				int index = 1;
				if (searchUser.getSearchType() == 1) {
					pstmt.setString(index++, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 2) {
					pstmt.setString(index++, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 3) {
					pstmt.setString(index++, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 4) {
					pstmt.setString(index++, searchUser.getSearchKeyword());
				}

				pstmt.setInt(index++, searchUser.getEndRowNumber());
				pstmt.setInt(index++, searchUser.getStartRowNumber());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<UserVO> users = new ArrayList<UserVO>();
				UserVO userVO = null;
				LocationVO locationVO = null;
				TeamVO teamVO = null;
				while (rs.next()) {
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

					users.add(userVO);
				}

				return users;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> getUserListOf() {
		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT  U.USR_ID ");
				query.append("             , U.USR_EMAIL ");
				query.append("             , U.USR_PWD ");
				query.append("             , U.USR_NM ");
				query.append("             , U.USR_PHN ");
				query.append("             , U.USR_AGE ");
				query.append("             , U.USR_POSIT ");
				query.append("             , U.TEAM_ID ");
				query.append("             , U.LV_ID ");
				query.append("             , U.LCTN_ID ");
				query.append("             , TO_CHAR(U.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append("             , TO_CHAR(U.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append("             , U.PWD_HINT ");
				query.append("             , U.PWD_ANSER ");
				query.append("             , T.TEAM_CNT ");
				query.append("             , T.TEAM_NM ");
				query.append("             , T.TEAM_PHOTO ");
				query.append("             , T.CRT_DT ");
				query.append("             , T.TEAM_POINT ");
				query.append("             , T.LTST_MODY_DT ");
				query.append("             , T.TEAM_INFO ");
				query.append("             , T.LCTN_ID ");
				query.append("             , L.PRNT_LCTN_ID ");
				query.append("             , L.LCTN_NM ");
				query.append("             , L.PRNT_LCTN_NM ");
				query.append(" FROM        USR U ");
				query.append("             , LCTN L ");
				query.append("             , TEAM T ");
				query.append(" WHERE   U.LCTN_ID = L.LCTN_ID ");
				query.append(" AND     U.TEAM_ID = T.TEAM_ID(+) ");
				query.append(" ORDER   BY USR_ID DESC ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				return pstmt;

			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<UserVO> users = new ArrayList<UserVO>();
				UserVO userVO = null;
				LocationVO locationVO = null;
				TeamVO teamVO = null;
				while (rs.next()) {
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

					locationVO = userVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					teamVO = userVO.getTeamVO();
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));

					users.add(userVO);
				}

				return users;
			}
		});
	}

	@Override
	public int deleteUser(UserVO userVO) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" DELETE ");
				query.append(" FROM		USR ");
				query.append(" WHERE	USR_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getUserId());
				return pstmt;
			}
		});
	}

	public int getCountOfUsers(SearchUserVO searchUser) {
		return (int) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		USR  ");

				if (searchUser.getSearchType() == 1) {
					query.append(" WHERE	USR_EMAIL LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 2) {
					query.append(" WHERE	USR_NM LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 3) {
					query.append(" WHERE	USR_PHN LIKE '%'|| ?|| '%' ");
				} else if (searchUser.getSearchType() == 4) {
					query.append(" WHERE	USR_AGE LIKE '%'|| ?|| '%' ");
				}

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				if (searchUser.getSearchType() == 1) {
					pstmt.setString(1, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 2) {
					pstmt.setString(1, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 3) {
					pstmt.setString(1, searchUser.getSearchKeyword());
				} else if (searchUser.getSearchType() == 4) {
					pstmt.setString(1, searchUser.getSearchKeyword());
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
	public int UserTemaIdDelete(String teamId) {
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	USR ");
				query.append(" SET		TEAM_ID = ? ");
				query.append(" 			, LV_ID = '2' ");
				query.append(" WHERE	TEAM_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, null);
				pstmt.setString(2, teamId);
				
				return pstmt;

				}
		});
	}
	

	@Override
	public int adminPageDeleteUser(String userId) {
		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();

				query.append(" DELETE ");
				query.append(" FROM		USR ");
				query.append(" WHERE	USR_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userId);
				return pstmt;

			}
		});
	}

	@Override
	public UserVO getUserOne(String userId) {
		return (UserVO) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	U.USR_ID ");
				query.append(" 			, U.USR_EMAIL ");
				query.append(" 			, U.USR_PWD ");
				query.append(" 			, U.USR_NM ");
				query.append(" 			, U.USR_PHN ");
				query.append(" 			, U.USR_AGE ");
				query.append(" 			, U.USR_POSIT ");
				query.append(" 			, U.TEAM_ID ");
				query.append(" 			, U.LV_ID ");
				query.append(" 			, U.LCTN_ID ");
				query.append(" 			, TO_CHAR(U.LTST_MODY_DT, 'YYYY-MM-DD HH24:MI:SS') LTST_MODY_DT ");
				query.append(" 			, TO_CHAR(U.CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
				query.append(" 			, U.PWD_HINT ");
				query.append(" 			, U.PWD_ANSER ");
				query.append(" 			, T.TEAM_CNT ");
				query.append(" 			, T.TEAM_NM ");
				query.append(" 			, T.TEAM_PHOTO ");
				query.append(" 			, T.CRT_DT ");
				query.append(" 			, T.TEAM_POINT ");
				query.append(" 			, T.LTST_MODY_DT ");
				query.append(" 			, T.TEAM_INFO ");
				query.append(" 			, T.LCTN_ID ");
				query.append(" 			, L.PRNT_LCTN_ID ");
				query.append(" 			, L.LCTN_NM ");
				query.append(" 			, L.PRNT_LCTN_NM ");
				query.append(" FROM		USR U ");
				query.append(" 			, LCTN L ");
				query.append(" 			, TEAM T ");
				query.append(" WHERE	U.LCTN_ID = L.LCTN_ID ");
				query.append(" AND		U.TEAM_ID = T.TEAM_ID(+) ");
				query.append(" AND		U.USR_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userId);

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				UserVO userVO = null;
				LocationVO locationVO = null;
				TeamVO teamVO = null;

				if (rs.next()) {
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

					locationVO = userVO.getLocationVO();
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setParentLocationName(rs.getString("PRNT_LCTN_NM"));

					teamVO = userVO.getTeamVO();
					teamVO.setTeamCount(rs.getInt("TEAM_CNT"));
					teamVO.setTeamName(rs.getString("TEAM_NM"));
					teamVO.setTeamPhoto(rs.getString("TEAM_PHOTO"));
					teamVO.setCreateDate(rs.getString("CRT_DT"));
					teamVO.setTeamPoint(rs.getInt("TEAM_POINT"));
					teamVO.setLatestModifyDate(rs.getString("LTST_MODY_DT"));
					teamVO.setTeamInfo(rs.getString("TEAM_INFO"));
					teamVO.setLocationId(rs.getString("LCTN_ID"));
				}
				return userVO;
			}
		});
	}

	@Override
	public int getCountOfUsers() {
		return (int) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {

				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT ");
				query.append(" FROM		USR ");

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
