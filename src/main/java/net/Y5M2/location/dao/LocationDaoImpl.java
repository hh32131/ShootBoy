package net.Y5M2.location.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.QueryAndResult;

public class LocationDaoImpl extends DaoSupport implements LocationDao {

	@Override
	public List<LocationVO> getLocations() {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();

				query.append(" SELECT	LCTN_NM ");
				query.append("  		,LCTN_ID ");
				query.append("  		, PRNT_LCTN_ID ");
				query.append(" FROM		LCTN ");
				query.append(" WHERE 	PRNT_LCTN_ID = 0 ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				List<LocationVO> locations = new ArrayList<LocationVO>();
				LocationVO locationVO;
				
				while( rs.next() ) {
					locationVO = new LocationVO();
					
					locationVO.setLocationId(rs.getString("LCTN_ID"));
					locationVO.setParentLocationId(rs.getString("PRNT_LCTN_ID"));
					locationVO.setLocationName(rs.getString("LCTN_NM"));
					
					locations.add(locationVO);
					
				}
				
				return locations;
			}
		});
	}

	
}
