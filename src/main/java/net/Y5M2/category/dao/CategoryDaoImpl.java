package net.Y5M2.category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.support.DaoSupport;
import net.Y5M2.support.QueryAndResult;

public class CategoryDaoImpl extends DaoSupport implements CategoryDao {

	@Override
	public List<CategoryVO> getCategories() {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
			StringBuffer query = new StringBuffer();
				
				query.append(" SELECT	A.ATCL_ID ");
				query.append("  		, A.ATCL_SUBJECT ");
				query.append("  		, A.ATCL_CONTENT ");
				query.append(" 			, TO_CHAR(A.CRT_DT, 'YYY
					     
			            pstmt = conn.prepareStatement(query.toString());
			            rs = pstmt.executeQuery();
			            
			            List<CategoryVO> categories = new ArrayList<CategoryVO>();
			            CategoryVO categoryVO = null;
			            
			            while(rs.next()) {
			                
			                categoryVO = new CategoryVO();
			                categoryVO.setCategoryId(rs.getInt("CTGR_ID"));
			                categoryVO.setCategoryName(rs.getString("CTGR_NM"));
			            
			                
			                categories.add(categoryVO);
			                
			                
			            }
			            
			            return categories;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

}
