package hu.adakiss.ticketsystem.ejb.customerfacade.converter;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.Dependent;

import java.util.Iterator;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.persistence.entity.Customer;

@Dependent
public class CustomerConverterImpl implements CustomerConverter {

	public CustomerStub convert(Customer c) {
		return new CustomerStub(c.getName(), c.getEmail(), c.getPhone());
	}
	
	public Set<CustomerStub> convert(Set<Customer> cSet) {
		
		Set<CustomerStub> sSet = new HashSet<CustomerStub>();
		
		Iterator<Customer> it = cSet.iterator();
		while(it.hasNext()) {
			sSet.add(convert(it.next()));
		}
		
		return sSet;
	}
	
}
