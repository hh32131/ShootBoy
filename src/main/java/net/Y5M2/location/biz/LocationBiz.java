package net.Y5M2.location.biz;

import java.util.List;

import net.Y5M2.location.vo.LocationVO;

public interface LocationBiz {

	public List<LocationVO> getLocations(LocationVO locations);
	
//	public List<LocationVO> getLeafLocations();
}
