package hu.adakiss.ticketsystem.ejb.customerfacade;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemException;

@Local
public interface CustomerFacade {

	CustomerStub readCustomer(String email) throws TicketSystemException;
	
	Set<CustomerStub> readAllCustomer() throws TicketSystemException;
	
	void deleteCustomer(String email) throws TicketSystemException;
	
	CustomerStub addCustomer(String name, String email, String tel) throws TicketSystemException;
	
	CustomerStub updateCustomer(String name, String email, String tel) throws TicketSystemException;
}