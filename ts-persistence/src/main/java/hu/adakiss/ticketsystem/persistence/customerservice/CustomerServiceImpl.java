package hu.adakiss.ticketsystem.persistence.customerservice;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.adakiss.ticketsystem.persistence.entity.Customer;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemPersistenceException;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	
	@PersistenceContext(unitName="ts-persistence-unit")
	private EntityManager em;
	
	@Override
	public Customer readCustomer(String email) throws TicketSystemPersistenceException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTENCE: Reading customer with email: " + email);
		}
		
		Customer result = null;
		
		try {
			result = em.createNamedQuery(Customer.GET_BY_EMAIL, Customer.class).setParameter("email", email).getSingleResult();
		} catch (final Exception e) {
			LOGGER.error("PERSISTENCE: Error while reading customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Set<Customer> readAllCustomer() throws TicketSystemPersistenceException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTENCE: Reading all customers");
		}
		
		Set<Customer> result = null;
		
		try {
			result = new HashSet<Customer>(em.createNamedQuery(Customer.GET_ALL, Customer.class).getResultList());
		} catch (final Exception e) {
			LOGGER.error("PERSISTENCE: Error while reading all customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public void deleteCustomer(String email) throws TicketSystemPersistenceException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTENCE: Deleting customer with email: " + email);
		}
		
		try {
			em.createNamedQuery(Customer.DELETE_BY_EMAIL).setParameter("email", email).executeUpdate();
		} catch (final Exception e) {
			LOGGER.error("PERSISTENCE: Error while deleting customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
	}

	@Override
	public Customer addCustomer(String name, String email, String phone) throws TicketSystemPersistenceException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTENCE: Adding new customer");
		}
		
		Customer result = new Customer();
		
		try {
			result.setEmail(email);
			result.setName(name);
			result.setPhone(phone);
			
			em.persist(result);
			em.flush();
		} catch (final Exception e) {
			LOGGER.error("PERSISTENCE: Error while adding new customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Customer updateCustomer(String name, String email, String phone) throws TicketSystemPersistenceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTENCE: Updating customer with email: " + email);
		}
		
		Customer result = readCustomer(email);
		
		try {
			result.setName(name);
			result.setPhone(phone);
			
			em.persist(result);
			em.flush();
		} catch (final Exception e) {
			LOGGER.error("PERSISTENCE: Error while updating customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
		
		return result;
	}
	

	@Override
	public Boolean existsCustomer(String email) throws TicketSystemPersistenceException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PERSISTNCE: Checking the existence of customer with email: " + email);
		}
		
		try {
			return (em.createNamedQuery(Customer.COUNT_BY_EMAIL, Long.class).setParameter("email", email).getSingleResult() == 1);
		} catch (Exception e) {
			LOGGER.error("PERSISTENCE: Error while checking customer: [" + e.getClass().getSimpleName() + ", " + e.getMessage() + "]");
			throw new TicketSystemPersistenceException(e.getMessage());
		}
	}

	EntityManager getEm() {
		return em;
	}

	void setEm(EntityManager em) {
		this.em = em;
	}
}
