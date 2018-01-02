package hu.adakiss.ticketsystem.ejb.customerfacade;

import java.util.Set;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import hu.adakiss.ticketsystem.ejb.customerfacade.converter.CustomerConverter;
import hu.adakiss.ticketsystem.ejb.exception.TicketSystemInputException;
import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.persistence.customerservice.CustomerService;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemException;

@Stateless
@Dependent
public class CustomerFacadeImpl implements CustomerFacade {
	
	private final static Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);
	
	@Inject
	private CustomerService service;
	
	@Inject
	private CustomerConverter converter;
	
	@Override
	public CustomerStub readCustomer(String email) throws TicketSystemException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("EJB: Reading customer with email: " + email);
		}
		
		if(service.existsCustomer(email)) {
			return converter.convert(service.readCustomer(email));
		} else {
			LOGGER.error("EJB: No customer exists with email: " + email);
			throw new TicketSystemInputException("Given email is not valid for any of the customers");
		}
	}

	@Override
	public Set<CustomerStub> readAllCustomer() throws TicketSystemException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("EJB: Reading all customers");
		}
		
		return converter.convert(service.readAllCustomer());
	}

	@Override
	public void deleteCustomer(String email) throws TicketSystemException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("EJB: Deleting customer with email: " + email);
		}
		
		if(service.existsCustomer(email)) {
			service.deleteCustomer(email);
		} else {
			LOGGER.error("EJB: No customer exists with email: " + email);
			throw new TicketSystemInputException("Given email is not valid for any of the customers");
		}
		
	}

	@Override
	public CustomerStub addCustomer(String name, String email, String tel) throws TicketSystemException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("EJB: Creating customer with email: " + email);
		}
		
		if(!service.existsCustomer(email)) {
			return converter.convert(service.addCustomer(name, email, tel));
		} else {
			LOGGER.error("EJB: Customer already exists with email: " + email);
			throw new TicketSystemInputException("Given email is already taken");
		}
	}

	@Override
	public CustomerStub updateCustomer(String name, String email, String tel) throws TicketSystemException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("EJB: Updating customer with email: " + email);
		}
		
		if(service.existsCustomer(email)) {
			return converter.convert(service.updateCustomer(name, email, tel));
		} else {
			LOGGER.error("EJB: No customer exists with email: " + email);
			throw new TicketSystemInputException("Given email is not valid for any of the customers");
		}
	}

}
