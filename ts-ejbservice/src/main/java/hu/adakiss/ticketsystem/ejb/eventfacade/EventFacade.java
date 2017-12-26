package hu.adakiss.ticketsystem.ejb.eventfacade;

import java.sql.Date;
import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.EventStub;
import hu.adakiss.ticketsystem.ejb.stub.LocationStub;
import hu.adakiss.ticketsystem.ejb.stub.OrganiserStub;

@Local
public interface EventFacade {

	EventStub readEvent(String name, LocationStub loc, Date date);
	
	Set<EventStub> readAllEvent();
	
	void deleteEvent(String name, LocationStub loc, Date date);
	
	EventStub addNewEvent(String eventName, String eventType, LocationStub eventLocation, Date eventTime, Integer eventTicketsAll,
			Integer eventTicketsSold, OrganiserStub eventOrganiser, Integer price);
	
	EventStub updateEvent(String eventName, String eventType, LocationStub eventLocation, Date eventTime, Integer eventTicketsAll,
			Integer eventTicketsSold, OrganiserStub eventOrganiser, Integer price);
}
