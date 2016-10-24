package net.Y5M2.category.dao;

import java.util.List;

import net.Y5M2.category.vo.CategoryVO;

public interface CategoryDao {

	public List<CategoryVO> getCategoryList(String parentCategoryId);

	public boolean isCategoryLeafNode(String categoryId);

	public List<CategoryVO> getAllCategoryList();

}