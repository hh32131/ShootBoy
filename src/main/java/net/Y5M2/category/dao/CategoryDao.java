package net.Y5M2.category.dao;

import java.util.List;

import net.Y5M2.category.vo.CategoryVO;

public interface CategoryDao {

	public List<CategoryVO> getCategoryList(int parentsCategoryId);

}