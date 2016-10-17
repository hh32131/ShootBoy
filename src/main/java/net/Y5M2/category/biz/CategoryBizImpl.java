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
	public List<CategoryVO> getCategoryList(int parentsCategoryId) {
		return categoryDao.getCategoryList(parentsCategoryId);
	}

}
