package net.Y5M2.location.biz;

import java.util.List;

import net.Y5M2.location.dao.LocationDao;
import net.Y5M2.location.dao.LocationDaoImpl;
import net.Y5M2.location.vo.LocationVO;

public class LocationBizImpl implements LocationBiz{

	LocationDao locationDao;
	
	public LocationBizImpl() {
		locationDao = new LocationDaoImpl();
	}
	
	@Override
	public List<LocationVO> getLocations() {
		return locationDao.getLocations();
	}

}
