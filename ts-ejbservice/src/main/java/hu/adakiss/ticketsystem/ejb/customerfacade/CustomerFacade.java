package hu.adakiss.ticketsystem.ejb.customerfacade;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;

@Local
public interface CustomerFacade {

	CustomerStub readCustomer(String email);
	
	Set<CustomerStub> readAllCustomer();
	
	void deleteCustomer(String email);
	
	CustomerStub addCustomer(String name, String email, String tel);
	
	CustomerStub updateCustomer(String name, String email, String tel);
}