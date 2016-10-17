package net.Y5M2.replay.vo;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.user.vo.UserVO;

public class ReplayVO {
	private String replayId;
	private String replayContent;
	private String boardId;
	private String userId;
	private String createDate;
	private String leastModifyDate;
	private int hitCount;

	private UserVO userVO;
	private BoardVO boardVO;

	public ReplayVO() {
		userVO = new UserVO();
		boardVO = new BoardVO();
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public String getReplayId() {
		return replayId;
	}

	public void setReplayId(String replayId) {
		this.replayId = replayId;
	}

	public String getReplayContent() {
		return replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLeastModifyDate() {
		return leastModifyDate;
	}

	public void setLeastModifyDate(String leastModifyDate) {
		this.leastModifyDate = leastModifyDate;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

}
