package hu.adakiss.ticketsystem.ejb.stub;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class OrganiserStubTests {
	
	OrganiserStub stub;
	
	String orgName;
	String orgAddress;
	String orgEmail;
	String orgTel;
	
	@Before
	public void setUpTestedObject() {
		orgName = "TestOrganiser";
		orgAddress = "TestOrganiserAddress";
		orgEmail = "TestOrganiserEmail";
		orgTel = "TestOrganiserTel";
		
		stub = new OrganiserStub(orgName, orgAddress, orgTel, orgEmail);
	}
	
	@Test
	public void TestConstructor() {
		Assert.assertEquals(orgName, stub.getOrganiserName());
		Assert.assertEquals(orgAddress, stub.getOrganiserAddress());
		Assert.assertEquals(orgEmail, stub.getOrganiserEmail());
		Assert.assertEquals(orgTel, stub.getOrganiserTel());
	}
	
}
