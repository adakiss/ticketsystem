package hu.adakiss.ticketsystem.ejb.stub;

import static org.mockito.Mockito.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hu.adakiss.ticketsystem.ejb.exception.TicketSystemInputException;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemException;

public class EventStubTests {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private EventStub stub1;
	
	String eventName;
	String eventType;
	LocationStub eventLocation;
	Date eventTime;
	Integer eventTicketsAll;
	Integer eventTicketsSold;
	OrganiserStub eventOrganiser;
	Integer eventPrice;
	
	@Before
	public void setUpTestedObjects() {
		eventName = "TestEvent";
		eventType = "TestEventType";
		eventLocation = mock(LocationStub.class);
		eventTime = new Date(new java.util.Date().getTime());
		eventTicketsAll = 400;
		eventTicketsSold = 167;
		eventOrganiser = mock(OrganiserStub.class);
		eventPrice = 1300;
		
		when(eventLocation.getLocationName()).thenReturn("TestEventLocation");
		when(eventLocation.getLocationAddress()).thenReturn("TestEventLocationAddress");
		when(eventLocation.getMaxCapacity()).thenReturn(1500);
		
		when(eventOrganiser.getOrganiserName()).thenReturn("TestEventOrganiserName");
		when(eventOrganiser.getOrganiserAddress()).thenReturn("TestEventOrganiserAddress");
		when(eventOrganiser.getOrganiserEmail()).thenReturn("TestEventOrganiserEmail");
		when(eventOrganiser.getOrganiserTel()).thenReturn("TestEventOrganiserTel");
	}
	
	@Test
	public void TestConstructor1() throws TicketSystemInputException {
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventTicketsAll, eventTicketsSold, eventOrganiser, eventPrice);
		
		Assert.assertEquals(eventName, stub1.getEventName());
		Assert.assertEquals(eventType, stub1.getEventType());
		assertLocation(stub1.getEventLocation(), "TestEventLocation", "TestEventLocationAddress", 1500);
		Assert.assertEquals(eventTime, stub1.getEventTime());
		Assert.assertEquals(eventTicketsAll, stub1.getEventTicketsAll());
		Assert.assertEquals(eventTicketsSold, stub1.getEventTicketsSold());
		assertOrganiser(eventOrganiser, "TestEventOrganiserName", "TestEventOrganiserAddress", "TestEventOrganiserEmail", "TestEventOrganiserTel");
		Assert.assertEquals(eventPrice, stub1.getEventPrice());
	}
	
	@Test
	public void TestConstructor2() throws TicketSystemInputException {
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventTicketsAll, eventOrganiser, eventPrice);
		
		Assert.assertEquals(eventName, stub1.getEventName());
		Assert.assertEquals(eventType, stub1.getEventType());
		assertLocation(stub1.getEventLocation(), "TestEventLocation", "TestEventLocationAddress", 1500);
		Assert.assertEquals(eventTime, stub1.getEventTime());
		Assert.assertEquals(eventTicketsAll, stub1.getEventTicketsAll());
		Assert.assertEquals((Integer)0, stub1.getEventTicketsSold());
		assertOrganiser(stub1.getEventOrganiser(), "TestEventOrganiserName", "TestEventOrganiserAddress", "TestEventOrganiserEmail", "TestEventOrganiserTel");
		Assert.assertEquals(eventPrice, stub1.getEventPrice());
	}
	
	@Test
	public void TestConstuctor3() throws TicketSystemInputException {
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		Assert.assertEquals(eventName, stub1.getEventName());
		Assert.assertEquals(eventType, stub1.getEventType());
		assertLocation(stub1.getEventLocation(), "TestEventLocation", "TestEventLocationAddress", 1500);
		Assert.assertEquals(eventTime, stub1.getEventTime());
		Assert.assertEquals(stub1.getEventLocation().getMaxCapacity(), stub1.getEventTicketsAll());
		Assert.assertEquals((Integer)0, stub1.getEventTicketsSold());
		assertOrganiser(stub1.getEventOrganiser(), "TestEventOrganiserName", "TestEventOrganiserAddress", "TestEventOrganiserEmail", "TestEventOrganiserTel");
		Assert.assertEquals(eventPrice, stub1.getEventPrice());
	}
	
	@Test
	public void TestForErrors1() throws TicketSystemInputException {
		thrown.expect(TicketSystemException.class);
		
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		stub1.setEventTicketsAll(1501);
	}
	
	@Test
	public void TestForErrors2() throws TicketSystemInputException {
		thrown.expect(TicketSystemException.class);
		
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		stub1.setEventTicketsSold(1501);
	}
	
	@Test
	public void TestForErrors3() throws TicketSystemInputException {
		thrown.expect(TicketSystemException.class);
		
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		stub1.setEventTicketsSold(666);
		stub1.setEventTicketsAll(665);
	}
	
	@Test
	public void TestForErrors4() throws TicketSystemInputException {
		thrown.expect(TicketSystemException.class);
		
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		LocationStub loc2 = mock(LocationStub.class);
		when(loc2.getMaxCapacity()).thenReturn(300);
		
		stub1.setEventTicketsSold(301);
		stub1.setEventLocation(loc2);
	}
	
	@Test
	public void TestBusinessId() throws ParseException, TicketSystemInputException {
		stub1 = new EventStub(eventName, eventType, eventLocation, eventTime, eventOrganiser, eventPrice);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "1996-01-06";
		stub1.setEventTime(new Date(sdf.parse(dateInString).getTime()));
		
		String expectedBusinessId = eventName + "|" + eventLocation.getLocationName() + "|19960106";
		
		Assert.assertEquals(expectedBusinessId, stub1.getEventBusinessId());
	}
	
	private void assertLocation(LocationStub loc, String locName, String locAddress, Integer maxCapacity) {
		Assert.assertEquals(loc.getLocationName(), locName);
		Assert.assertEquals(loc.getLocationAddress(), locAddress);
		Assert.assertEquals(loc.getMaxCapacity(), maxCapacity);
	}
	
	private void assertOrganiser(OrganiserStub org, String orgName, String orgAddress, String orgEmail, String orgTel) {
		Assert.assertEquals(org.getOrganiserAddress(), orgAddress);
		Assert.assertEquals(org.getOrganiserName(), orgName);
		Assert.assertEquals(org.getOrganiserEmail(), orgEmail);
		Assert.assertEquals(org.getOrganiserTel(), orgTel);
	}
}
