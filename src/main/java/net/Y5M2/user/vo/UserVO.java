package net.Y5M2.user.vo;

import net.Y5M2.level.vo.LevelVO;
import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.team.vo.TeamVO;

public class UserVO {

	private String userId;
	private String email;
	private String password;
	private String userName;
	private String phoneNumber;
	private String age;
	private String position;
	private String createDate;
	private String passwordHint;
	private String passwordAnswer;
	private String teamId;
	private String levelId;
	private String locationId;
	private String latestModifyDate;

	private TeamVO teamVO;
	private LevelVO levelVO;
	private LocationVO locationVO;

	public UserVO() {
		teamVO = new TeamVO();
		levelVO = new LevelVO();
		locationVO = new LocationVO();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLatestModifyDate() {
		return latestModifyDate;
	}

	public void setLatestModifyDate(String latestModifyDate) {
		this.latestModifyDate = latestModifyDate;
	}

	public TeamVO getTeamVO() {
		return teamVO;
	}

	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}

	public LevelVO getLevelVO() {
		return levelVO;
	}

	public void setLevelVO(LevelVO levelVO) {
		this.levelVO = levelVO;
	}

	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}



}
