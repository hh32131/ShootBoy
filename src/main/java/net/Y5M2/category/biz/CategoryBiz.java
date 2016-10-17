package net.Y5M2.category.biz;

import java.util.List;

import net.Y5M2.category.vo.CategoryVO;

public interface CategoryBiz {

	public List<CategoryVO> getCategoryList(int parentsCategoryId);
	
}
