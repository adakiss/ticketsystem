package hu.adakiss.ticketsystem.ejb.exception;

public class TicketSystemException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TicketSystemException(String message) {
		super(message);
	}
}
