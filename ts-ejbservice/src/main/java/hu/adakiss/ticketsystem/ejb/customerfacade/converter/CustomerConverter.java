package hu.adakiss.ticketsystem.ejb.customerfacade.converter;

import java.util.Set;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.persistence.entity.Customer;

public interface CustomerConverter {
	
	CustomerStub convert(Customer c);
	
	Set<CustomerStub> convert(Set<Customer> cSet);
}
