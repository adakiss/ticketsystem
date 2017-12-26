package hu.adakiss.ticketsystem.ejb.organiserfacade;

import java.util.Set;

import javax.ejb.Local;

import hu.adakiss.ticketsystem.ejb.stub.OrganiserStub;

@Local
public interface OrganiserFacade {
	
	OrganiserStub readOrganiser(String name);
	
	Set<OrganiserStub> readAllOrganiser();
	
	void deleteOrganiser(String name);
	
	OrganiserStub addOrganiser(String name, String address, String tel, String email);
	
	OrganiserStub updateOrganiser(String name, String address, String tel, String email);
}
