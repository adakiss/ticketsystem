package hu.adakiss.ticketsystem.ejb.organiserfacade;

import java.util.Set;

import javax.ejb.Stateless;

import hu.adakiss.ticketsystem.ejb.stub.OrganiserStub;

@Stateless
public class OrganiserFacadeImpl implements OrganiserFacade {

	@Override
	public OrganiserStub readOrganiser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OrganiserStub> readAllOrganiser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrganiser(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrganiserStub addOrganiser(String name, String address, String tel, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganiserStub updateOrganiser(String name, String address, String tel, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
