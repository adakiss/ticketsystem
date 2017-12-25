package hu.adakiss.ticketsystem.ejb.stub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerStubTests {

	private CustomerStub stub;
	
	String customerName;
	String customerEmail;
	String customerPhone;
	
	@Before
	public void setUpTestedObject() {
		customerName = "TestCustomer";
		customerEmail = "TestCustomerEmail";
		customerPhone = "TestCustomerPhone";
		
		stub = new CustomerStub(customerName, customerEmail, customerPhone);
	}
	
	@Test
	public void TestConstructor() {
		Assert.assertEquals(customerName, stub.getCustomerName());
		Assert.assertEquals(customerEmail, stub.getCustomerEmail());
		Assert.assertEquals(customerPhone, stub.getCustomerPhone());
	}
}
