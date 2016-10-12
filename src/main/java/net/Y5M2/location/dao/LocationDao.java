package net.Y5M2.location.dao;

import java.util.List;

import net.Y5M2.location.vo.LocationVO;



public interface LocationDao {

	public List<LocationVO> getLocations(LocationVO locations);
//	public List<LocationVO> getLeafLocations();
}
