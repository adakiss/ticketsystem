package hu.adakiss.ticketsystem.ejb.eventfacade;

import java.sql.Date;
import java.util.Set;

import javax.ejb.Stateless;

import hu.adakiss.ticketsystem.ejb.stub.EventStub;
import hu.adakiss.ticketsystem.ejb.stub.LocationStub;
import hu.adakiss.ticketsystem.ejb.stub.OrganiserStub;

@Stateless
public class EventFacadeImpl implements EventFacade {

	@Override
	public EventStub readEvent(String name, LocationStub loc, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EventStub> readAllEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEvent(String name, LocationStub loc, Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventStub addNewEvent(String eventName, String eventType, LocationStub eventLocation, Date eventTime,
			Integer eventTicketsAll, Integer eventTicketsSold, OrganiserStub eventOrganiser, Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventStub updateEvent(String eventName, String eventType, LocationStub eventLocation, Date eventTime,
			Integer eventTicketsAll, Integer eventTicketsSold, OrganiserStub eventOrganiser, Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

}
