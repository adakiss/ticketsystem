package hu.adakiss.ticketsystem.ejb.stub;

public class SoldTicketStub {
	
	private String orderCode;
	private CustomerStub ticketBuyer;
	private EventStub event;
	private Boolean toReSell;
	
	public CustomerStub getTicketBuyer() {
		return ticketBuyer;
	}
	public void setTicketBuyer(CustomerStub ticketBuyer) {
		this.ticketBuyer = ticketBuyer;
	}
	public EventStub getEvent() {
		return event;
	}
	public void setEvent(EventStub event) {
		this.event = event;
	}
	public Boolean getToReSell() {
		return toReSell;
	}
	public void setToReSell(Boolean toReSell) {
		this.toReSell = toReSell;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	public SoldTicketStub(CustomerStub ticketBuyer, EventStub event, String orderCode) {
		super();
		this.ticketBuyer = ticketBuyer;
		this.event = event;
		this.orderCode = orderCode;
		this.toReSell = false;
	}
	
	@Override
	public String toString() {
		return "[SoldTicket: {" + orderCode + "}, {" + ticketBuyer.getCustomerName() + "}, {" + event.getEventName() + "}, {" + toReSell + "}]";
	}
}
