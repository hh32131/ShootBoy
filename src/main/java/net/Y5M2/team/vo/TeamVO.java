package net.Y5M2.team.vo;

import net.Y5M2.level.vo.LevelVO;

public class TeamVO {

	private String teamId;
	private int teamCount;
	private String teamName;
	private String teamInfo;
	public String getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}

	private String teamPhoto;
	private String createDate;
	private int teamPoint;
	private String latestModifyDate;
	private String levelId;

	LevelVO levelVO;

	public TeamVO() {
		levelVO = new LevelVO();
	}

	public LevelVO getLevelVO() {
		return levelVO;
	}

	public void setLevelVO(LevelVO levelVO) {
		this.levelVO = levelVO;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public int getTeamCount() {
		return teamCount;
	}

	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamPhoto() {
		return teamPhoto;
	}

	public void setTeamPhoto(String teamPhoto) {
		this.teamPhoto = teamPhoto;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getTeamPoint() {
		return teamPoint;
	}

	public void setTeamPoint(int teamPoint) {
		this.teamPoint = teamPoint;
	}

	public String getLatestModifyDate() {
		return latestModifyDate;
	}

	public void setLatestModifyDate(String latestModifyDate) {
		this.latestModifyDate = latestModifyDate;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

}
