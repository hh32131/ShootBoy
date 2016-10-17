package net.Y5M2.category.biz;

import java.util.List;

import net.Y5M2.category.vo.CategoryVO;

public interface CategoryBiz {

	/**
	 * 모든 카테고리 가져오기
	 * @param parentsCategoryId
	 * @return
	 */
	public List<CategoryVO> getCategoryList(int parentsCategoryId);
	
}
