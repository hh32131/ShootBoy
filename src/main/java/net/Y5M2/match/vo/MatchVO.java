package net.Y5M2.match.vo;

import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.team.vo.AwayTeamVO;
import net.Y5M2.team.vo.TeamVO;

public class MatchVO {
	private String matchId;
	private String teamId;
	private String awayTeamId;
	private String schedule;
	private String createDate;
	private String matchPoint;
	private String locationId;
	private String playField;
	private String parentLocaionId;
	
	private LocationVO locationVO;
	private TeamVO teamVO;
	private AwayTeamVO awayTeamVO;
	
	public AwayTeamVO getAwayTeamVO() {
		return awayTeamVO;
	}

	public void setAwayTeamVO(AwayTeamVO awayTeamVO) {
		this.awayTeamVO = awayTeamVO;
	}

	public MatchVO() {
		locationVO = new LocationVO();
		teamVO = new TeamVO();
		awayTeamVO = new AwayTeamVO();
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getMatchPoint() {
		return matchPoint;
	}

	public void setMatchPoint(String matchPoint) {
		this.matchPoint = matchPoint;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public String getPlayField() {
		return playField;
	}

	public void setPlayField(String playField) {
		this.playField = playField;
	}

	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	public TeamVO getTeamVO() {
		return teamVO;
	}

	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}

	public String getParentLocaionId() {
		return parentLocaionId;
	}

	public void setParentLocaionId(String parentLocaionId) {
		this.parentLocaionId = parentLocaionId;
	}
	
	
	
	
}
