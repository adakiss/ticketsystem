package hu.adakiss.ticketsystem.ejb.customerfacade;

import java.util.Set;

import javax.ejb.Stateless;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;

@Stateless
public class CustomerFacadeImpl implements CustomerFacade {

	@Override
	public CustomerStub readCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CustomerStub> readAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerStub addCustomer(String name, String email, String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerStub updateCustomer(String name, String email, String tel) {
		// TODO Auto-generated method stub
		return null;
	}

}
