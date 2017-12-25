package hu.adakiss.ticketsystem.ejb.stub;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoldTicketStubTests {

	private SoldTicketStub stub;
	
	CustomerStub customer;
	EventStub event;
	String orderCode;
	
	@Before
	public void setUpTestedObject() {
		
		customer = mock(CustomerStub.class);
		event = mock(EventStub.class);
		orderCode = "TestTicketOrderCode";
		
		stub = new SoldTicketStub(customer, event, orderCode);
	}
	
	@Test
	public void TestConstructor() {
		Assert.assertEquals(customer, stub.getTicketBuyer());
		Assert.assertEquals(event, stub.getEvent());
		Assert.assertEquals(orderCode, stub.getOrderCode());
		Assert.assertFalse(stub.getToReSell());
	}
}
