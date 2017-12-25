package hu.adakiss.ticketsystem.ejb.stub;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class LocationStubTests {
	
	LocationStub stub;
	
	String locationName;
	String locationAddress;
	Integer maxCapacity;
	
	@Before
	public void setUpTestedObject() {
		
		locationName = "TestLocationName";
		locationAddress = "TestLocationAddress";
		maxCapacity = 1111;
		
		stub = new LocationStub(locationName, locationAddress, maxCapacity);
	}
	
	@Test
	public void TestConstructor() {
		Assert.assertEquals(locationName, stub.getLocationName());
		Assert.assertEquals(locationAddress, stub.getLocationAddress());
		Assert.assertEquals(maxCapacity, stub.getMaxCapacity());
	}
}
