package hu.adakiss.ticketsystem.ejb.locationfacade;

import java.util.Set;

import javax.ejb.Stateless;

import hu.adakiss.ticketsystem.ejb.stub.LocationStub;

@Stateless
public class LocationFacadeImpl implements LocationFacade {

	@Override
	public LocationStub readLocation(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<LocationStub> readAllLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLocation(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocationStub addLocation(String locName, String address, Integer maxCapacity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationStub updateLocation(String locName, String address, Integer maxCapacity) {
		// TODO Auto-generated method stub
		return null;
	}

}
