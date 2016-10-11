package net.Y5M2.category.vo;

public class CategoryVO {

	private String categoryId;
	private String categoryName;
	private String parentsCategoryId;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentsCategoryId() {
		return parentsCategoryId;
	}

	public void setParentsCategoryId(String parentsCategoryId) {
		this.parentsCategoryId = parentsCategoryId;
	}

}
