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
	public List<CategoryVO> getCategoryList(String parentCategoryId) {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();

				query.append(" SELECT	CTGR_ID ");
				query.append(" 			, CTGR_NM ");
				query.append(" 			, PRNT_CTGR_ID ");
				query.append(" FROM		CTGR ");
				query.append(" WHERE	PRNT_CTGR_ID = ? ");

				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, parentCategoryId);
				return pstmt;
			}
		
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				CategoryVO category = null;
				List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
				
				while ( rs.next() ) {
					category = new CategoryVO();
					category.setCategoryId(rs.getString("CTGR_ID"));
					category.setCategoryName(rs.getString("CTGR_NM"));
					category.setParentsCategoryId(rs.getString("PRNT_CTGR_ID"));
					
					categoryList.add(category);
				}
				
				return categoryList;
			}
		});
	}
	
	@Override
	public boolean isCategoryLeafNode(String categoryId) {
		return getCategoryList(categoryId).size() == 0;
	}
	
	public List<CategoryVO> getAllCategoryList() {
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();

				query.append(" SELECT	CTGR_ID ");
				query.append(" 			, CTGR_NM ");
				query.append(" 			, PRNT_CTGR_ID ");
				query.append(" FROM		CTGR ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				CategoryVO category = null;
				List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
				
				while ( rs.next() ) {
					category = new CategoryVO();
					category.setCategoryId(rs.getString("CTGR_ID"));
					category.setCategoryName(rs.getString("CTGR_NM"));
					category.setParentsCategoryId(rs.getString("PRNT_CTGR_ID"));
					
					categoryList.add(category);
				}
				
				return categoryList;
			}
		});
	}
}
