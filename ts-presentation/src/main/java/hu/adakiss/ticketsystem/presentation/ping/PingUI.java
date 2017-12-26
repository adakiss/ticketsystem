package hu.adakiss.ticketsystem.presentation.ping;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import hu.adakiss.ticketsystem.ejb.stub.CustomerStub;
import hu.adakiss.ticketsystem.ejb.stub.EventStub;
import hu.adakiss.ticketsystem.ejb.stub.LocationStub;
import hu.adakiss.ticketsystem.ejb.stub.OrganiserStub;
import hu.adakiss.ticketsystem.ejb.stub.SoldTicketStub;

public class PingUI extends UI {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		try {
			VerticalLayout content = new VerticalLayout();
			content.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
			content.setSizeFull(); // Use entire window
	        setContent(content);   // Attach to the UI
	        
	        CustomerStub customer = new CustomerStub("Name", "Email", "0000");
	        OrganiserStub org = new OrganiserStub("Name", "Address", "0001", "Email");
	        LocationStub loc = new LocationStub("LocName", "LocAddress", 1500);
	        EventStub event = new EventStub("Event", "EventType", loc, new java.sql.Date(new java.util.Date().getTime()), org, 1000);
	        SoldTicketStub ticket = new SoldTicketStub(customer, event, "T0");
	        
	        content.addComponent(new Label(customer.toString(), ContentMode.HTML));
	        content.addComponent(new Label(org.toString(), ContentMode.HTML));
	        content.addComponent(new Label(loc.toString(), ContentMode.HTML));
	        content.addComponent(new Label(event.toString(), ContentMode.HTML));
	        content.addComponent(new Label(ticket.toString(), ContentMode.HTML));
		} catch (Exception e) {
			
		}
	}

}
