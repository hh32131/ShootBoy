package net.Y5M2.team.vo;

import net.Y5M2.user.vo.UserVO;

public class TeamBoardVO {

	private String teamBoardId;
	private String userId;
	private String teamBoardSubject;
	private int teamBoardRecommendCount;
	private String teamBoardContent;
	private String createDate;
	private String latestModifyDate;
	private String teamId;
	private String fileName;
	private int replayHitCount;
	private UserVO userVO;
	private TeamVO teamVO;
	
	public TeamBoardVO() {
		userVO = new UserVO();
		teamVO = new TeamVO();
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public TeamVO getTeamVO() {
		return teamVO;
	}
	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}
	public int getReplayHitCount() {
		return replayHitCount;
	}
	public void setReplayHitCount(int replayHitCount) {
		this.replayHitCount = replayHitCount;
	}
	
	public String getTeamBoardId() {
		return teamBoardId;
	}
	public void setTeamBoardId(String teamBoardId) {
		this.teamBoardId = teamBoardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTeamBoardSubject() {
		return teamBoardSubject;
	}
	public void setTeamBoardSubject(String teamBoardSubject) {
		this.teamBoardSubject = teamBoardSubject;
	}
	public int getTeamBoardRecommendCount() {
		return teamBoardRecommendCount;
	}
	public void setTeamBoardRecommendCount(int teamBoardRecommendCount) {
		this.teamBoardRecommendCount = teamBoardRecommendCount;
	}
	public String getTeamBoardContent() {
		return teamBoardContent;
	}
	public void setTeamBoardContent(String teamBoardContent) {
		this.teamBoardContent = teamBoardContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLatestModifyDate() {
		return latestModifyDate;
	}
	public void setLatestModifyDate(String latestModifyDate) {
		this.latestModifyDate = latestModifyDate;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReplyHitCount() {
		return replyHitCount;
	}
	public void setReplyHitCount(int replyHitCount) {
		this.replyHitCount = replyHitCount;
	}
	private int replyHitCount;
}
