package net.Y5M2.category.biz;

import java.util.List;

import net.Y5M2.category.dao.CategoryDao;
import net.Y5M2.category.dao.CategoryDaoImpl;
import net.Y5M2.category.vo.CategoryVO;

public class CategoryBizImpl implements CategoryBiz{

	private CategoryDao categoryDao;
	
	public CategoryBizImpl() {
		categoryDao = new CategoryDaoImpl();
	}

	@Override
	public List<CategoryVO> getCategoryList(String parentCategoryId) {
		return categoryDao.getCategoryList(parentCategoryId);
	}

	@Override
	public boolean isCategoryLeafNode(String categoryId) {
		return categoryDao.isCategoryLeafNode(categoryId);
	}

	@Override
<<<<<<< HEAD
	public List<CategoryVO> getAllCategoryList() {
=======
	public List<CategoryVO> getAllCategoryList( ) {
>>>>>>> e73764ea7a70014e2107664083f2144c4fdf9228
		return categoryDao.getAllCategoryList();
	}

}
