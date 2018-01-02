package hu.adakiss.ticketsystem.persistence.customerservice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.adakiss.ticketsystem.persistence.entity.Customer;
import hu.adakiss.ticketsystem.persistence.exception.TicketSystemPersistenceException;

public class CustomerServiceIntegrationTests {
	
	private static final String PERSISTENCE_UNIT = "ts-persistence-test-unit";
	private CustomerServiceImpl object;
	
	String customerName;
	String customerEmail;
	String customerPhone;
	
	@Before
	public void setUp() {
		
		Thread.currentThread().setContextClassLoader(new ClassLoader() {
			@Override
			public Enumeration<URL> getResources(String arg0) throws IOException {
				if(arg0.equals("META-INF/persistence.xml")) {
					return Collections.enumeration(Arrays.asList(new File("src/test/resources/persistence.xml").toURI().toURL()));
				}
				return super.getResources(arg0);
			} 
		});
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = factory.createEntityManager();
		
		this.object = new CustomerServiceImpl();
		this.object.setEm(em);
		
		customerName = "testName";
		customerEmail = "test@test.test";
		customerPhone = "+36123456789";
	}
	
	@Test
	public void testCustomerAdd() throws TicketSystemPersistenceException {
		
		Customer c;

		object.getEm().getTransaction().begin();
		c = object.addCustomer(customerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		
		assertCustomer(c, customerName, customerEmail, customerPhone);
		
		object.getEm().getTransaction().begin();
		object.deleteCustomer(customerEmail);
		object.getEm().getTransaction().commit();
		Assert.assertFalse(object.existsCustomer(customerEmail));
	}
	
	@Test
	public void testCustomerDelete() throws TicketSystemPersistenceException {
		
		object.getEm().getTransaction().begin();
		object.addCustomer(customerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		Assert.assertTrue(object.existsCustomer(customerEmail));
		
		object.getEm().getTransaction().begin();
		object.deleteCustomer(customerEmail);
		object.getEm().getTransaction().commit();
		Assert.assertFalse(object.existsCustomer(customerEmail));
	}
	
	@Test
	public void testCustomerRead() throws TicketSystemPersistenceException {
		
		Customer c;
		
		object.getEm().getTransaction().begin();
		c = object.addCustomer(customerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		
		c = object.readCustomer(customerEmail);
		
		assertCustomer(c, customerName, customerEmail, customerPhone);
		
		object.getEm().getTransaction().begin();
		object.deleteCustomer(customerEmail);
		object.getEm().getTransaction().commit();
		Assert.assertFalse(object.existsCustomer(customerEmail));
	}
	
	@Test
	public void testCustomerReadAll() throws TicketSystemPersistenceException {
		
		Set<Customer> allCust = object.readAllCustomer();
		Integer sizeAllCustBefore = allCust.size();
		
		object.getEm().getTransaction().begin();
		object.addCustomer(customerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		allCust = null;
		allCust = object.readAllCustomer();
		Assert.assertEquals(sizeAllCustBefore+1, allCust.size());
		
		object.getEm().getTransaction().begin();
		object.deleteCustomer(customerEmail);
		object.getEm().getTransaction().commit();
		Assert.assertFalse(object.existsCustomer(customerEmail));
	}
	
	@Test
	public void testCustomerUpdate() throws TicketSystemPersistenceException {
		
		Customer c;
		
		object.getEm().getTransaction().begin();
		object.addCustomer(customerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		
		String newCustomerName = "newTestName";
		
		object.getEm().getTransaction().begin();
		c = object.updateCustomer(newCustomerName, customerEmail, customerPhone);
		object.getEm().getTransaction().commit();
		
		assertCustomer(c, newCustomerName, customerEmail, customerPhone);
		
		object.getEm().getTransaction().begin();
		object.deleteCustomer(customerEmail);
		object.getEm().getTransaction().commit();
		Assert.assertFalse(object.existsCustomer(customerEmail));
	}
	
	private void assertCustomer(Customer c, String name, String email, String phone) {
		Assert.assertEquals(name, c.getName());
		Assert.assertEquals(email, c.getEmail());
		Assert.assertEquals(phone, c.getPhone());
	}
}
