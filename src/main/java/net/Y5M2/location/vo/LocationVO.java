package net.Y5M2.location.vo;

public class LocationVO {

	private String locationId;
	private String parentLocationId;
	private String locationName;
	private String parentLocationName;

	public String getParentLocationName() {
		return parentLocationName;
	}

	public void setParentLocationName(String parentLocationName) {
		this.parentLocationName = parentLocationName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getParentLocationId() {
		return parentLocationId;
	}

	public void setParentLocationId(String parentLocationId) {
		this.parentLocationId = parentLocationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
