package hu.adakiss.ticketsystem.ejb.locationfacade;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.LocationStub;

@Local
public interface LocationFacade {
	
	LocationStub readLocation(String address);
	
	Set<LocationStub> readAllLocation();
	
	void deleteLocation(String address);
	
	LocationStub addLocation(String locName, String address, Integer maxCapacity);
	
	LocationStub updateLocation(String locName, String address, Integer maxCapacity);
}
