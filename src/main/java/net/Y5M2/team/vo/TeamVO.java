package net.Y5M2.team.vo;

import net.Y5M2.location.vo.LocationVO;

public class TeamVO {

	private String teamName;
	private int teamCount;
	private String teamPhoto;
	private String createDate;
	private String teamPoint;
	private String latestModifyDate;
	private String teamId;
	private String teamInfo;
	private String locationId;

	LocationVO location;

	public TeamVO() {
		location = new LocationVO();
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamCount() {
		return teamCount;
	}

	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
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

	public String getTeamPoint() {
		return teamPoint;
	}

	public void setTeamPoint(String teamPoint) {
		this.teamPoint = teamPoint;
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

	public String getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
}