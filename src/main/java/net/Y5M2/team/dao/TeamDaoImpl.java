package net.Y5M2.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.Query;
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
				query.append(" 					,TEAM_INFO )");
				query.append(" VALUES		 ( ");
				query.append(" 'TEAM-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(TEAM_ID_SEQ.NEXTVAL,6,0) ");
				query.append(" , ?, ?, ?, SYSDATE, 0, SYSDATE, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, teamVO.getTeamCount());
				pstmt.setString(2, teamVO.getTeamName());
				pstmt.setString(3, teamVO.getTeamPhoto());
				pstmt.setString(4, teamVO.getTeamInfo());
				return pstmt;
			}
		});
	}

}
