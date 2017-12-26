package hu.adakiss.ticketsystem.ejb.ticketfacade;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.ejb.stub.EventStub;
import hu.adakiss.ticketsystem.ejb.stub.SoldTicketStub;

@Local
public interface TicketFacade {
	
	SoldTicketStub readTicket(String orderCode);
	
	Set<SoldTicketStub> readAllTicket();
	
	void deleteTicket(String orderCode);
	
	SoldTicketStub createSoldTicket(CustomerStub buyer, EventStub event);
	
	SoldTicketStub reSellTicket(String orderCode);
}
