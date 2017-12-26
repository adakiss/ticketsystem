package hu.adakiss.ticketsystem.ejb.stub;

import java.sql.Date;
import java.text.SimpleDateFormat;

import hu.adakiss.ticketsystem.ejb.exception.TicketSystemInputException;

public class EventStub { 
	
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	private String eventName;
	private String eventType;
	private LocationStub eventLocation;
	private Date eventTime;
	private Integer eventTicketsAll;
	private Integer eventTicketsSold;
	private OrganiserStub eventOrganiser;
	private Integer eventPrice;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Integer getEventTicketsAll() {
		return eventTicketsAll;
	}
	public void setEventTicketsAll(Integer eventTicketsAll) throws TicketSystemInputException {
		if(eventTicketsAll > eventLocation.getMaxCapacity()) {
			throw new TicketSystemInputException("Quantity of tickets to be sold cannot be greater than the max capacity of the location");
		}
		if(eventTicketsSold > eventTicketsAll) {
			throw new TicketSystemInputException("Number of sold tickets cannot be greater than the number of all tickets");
		}
		
		this.eventTicketsAll = eventTicketsAll;
	}
	public Integer getEventTicketsSold() {
		return eventTicketsSold;
	}
	public void setEventTicketsSold(Integer eventTicketsSold) throws TicketSystemInputException {
		if(eventTicketsSold > eventTicketsAll) {
			throw new TicketSystemInputException("Number of sold tickets cannot be greater than the number of all tickets");
		}
		this.eventTicketsSold = eventTicketsSold;
	}
	public LocationStub getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(LocationStub eventLocation) throws TicketSystemInputException {
		if(eventLocation.getMaxCapacity() < eventTicketsSold) {
			throw new TicketSystemInputException("New location for the event cannot has less capacity than the tickets that has already been sold.");
		}
		
		if(eventLocation.getMaxCapacity() < eventTicketsAll) {
			eventTicketsAll = eventLocation.getMaxCapacity();
		}
		this.eventLocation = eventLocation;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventBusinessId() {
		return eventName + "|" + eventLocation.getLocationName() + "|" + format.format(eventTime);
	}
	public OrganiserStub getEventOrganiser() {
		return eventOrganiser;
	}
	public void setEventOrganiser(OrganiserStub eventOrganiser) {
		this.eventOrganiser = eventOrganiser;
	}
	public Integer getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(Integer eventPrice) {
		this.eventPrice = eventPrice;
	}
	
	public EventStub(String eventName, String eventType, LocationStub eventLocation, Date eventTime, Integer eventTicketsAll,
			Integer eventTicketsSold, OrganiserStub eventOrganiser, Integer price) throws TicketSystemInputException {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventLocation = eventLocation;
		this.eventTime = eventTime;
		this.eventTicketsAll = eventTicketsAll;
		this.eventTicketsSold = eventTicketsSold;
		this.eventOrganiser = eventOrganiser;
		this.eventPrice = price;
		
		if(eventTicketsAll > eventLocation.getMaxCapacity()) {
			throw new TicketSystemInputException("Quantity of tickets to be sold cannot be greater than the max capacity of the location");
		}
		if(eventTicketsSold > eventTicketsAll) {
			throw new TicketSystemInputException("Number of sold tickets cannot be greater than the number of all tickets");
		}
	}
	
	public EventStub(String eventName, String eventType, LocationStub eventLocation, Date eventTime, Integer eventTicketsAll, OrganiserStub eventOrganiser, Integer price) throws TicketSystemInputException {
		this(eventName, eventType, eventLocation, eventTime, eventTicketsAll, 0, eventOrganiser, price);
	}
	
	public EventStub(String eventName, String eventType, LocationStub eventLocation, Date eventTime, OrganiserStub eventOrganiser, Integer price) throws TicketSystemInputException {
		this(eventName, eventType, eventLocation, eventTime, eventLocation.getMaxCapacity(), 0, eventOrganiser, price);
	}
	@Override
	public String toString() {
		return "[Event: [" + "{" + eventName + "}, " + "{" + eventType + "}, " + "{" + eventLocation.getLocationName() + "}, " + "{" + eventTime + "}, " + "{" + eventTicketsAll + "}, " + "{" + eventTicketsSold + "}, " + "{" + eventOrganiser.getOrganiserName() + "}, " + "{" + eventPrice + "}" + "]";
	}
}
