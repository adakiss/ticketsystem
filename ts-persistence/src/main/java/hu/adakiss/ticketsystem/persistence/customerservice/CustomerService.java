package hu.adakiss.ticketsystem.persistence.customerservice;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.persistence.entity.Customer;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemPersistenceException;

@Local
public interface CustomerService {
	
	Customer readCustomer(String email) throws TicketSystemPersistenceException;
	
	Set<Customer> readAllCustomer() throws TicketSystemPersistenceException;
	
	void deleteCustomer(String email) throws TicketSystemPersistenceException;
	
	Customer addCustomer(String name, String email, String phone) throws TicketSystemPersistenceException;
	
	Customer updateCustomer(String name, String email, String phone) throws TicketSystemPersistenceException;
	
	Boolean existsCustomer(String email) throws TicketSystemPersistenceException;
}
