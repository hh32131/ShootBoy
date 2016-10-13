package net.Y5M2.article.vo;

import net.Y5M2.user.vo.UserVO;

public class BoardVO {

	private String boardId;
	private String boardSubject;
	private int hitCount;
	private String boardContent;
	private String userId;
	private String categoryId;
	private String fileName;
	private String modifyDate;
	private String createDate;
<<<<<<< HEAD
	
	private UserVO userVO;
	
=======

	private UserVO userVO;

	public BoardVO() {
		userVO = new UserVO();
	}

>>>>>>> f262f547a2221f8416aed0e6d4dbd690f5b00c15
	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
<<<<<<< HEAD

	public BoardVO(){
		userVO = new UserVO();
	}
=======
>>>>>>> f262f547a2221f8416aed0e6d4dbd690f5b00c15

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardSubject() {
		return boardSubject;
	}

	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
