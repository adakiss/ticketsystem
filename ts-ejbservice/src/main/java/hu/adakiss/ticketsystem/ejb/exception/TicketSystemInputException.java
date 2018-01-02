package hu.adakiss.ticketsystem.ejb.exception;

import hu.adakiss.ticketsystem.persistence.exception.TicketSystemException;

public class TicketSystemInputException extends TicketSystemException {

	private static final long serialVersionUID = 1L;

	public TicketSystemInputException(String message) {
		super(message);
	}
}
