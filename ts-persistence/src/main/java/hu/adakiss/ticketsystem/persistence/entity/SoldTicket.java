package hu.adakiss.ticketsystem.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
@NamedQueries({
	@NamedQuery(name=SoldTicket.GET_ALL, query="SELECT t FROM SoldTicket t"),
	@NamedQuery(name=SoldTicket.GET_BY_CODE, query="SELECT t FROM SoldTicket t JOIN FETCH t.buyer JOIN FETCH t.event WHERE t.orderCode=:orderCode"),
	@NamedQuery(name=SoldTicket.COUNT_BY_CODE, query="SELECT count(t) FROM SoldTicket t JOIN FETCH t.buyer JOIN FETCH t.event WHERE t.orderCode=:orderCode"),
	@NamedQuery(name=SoldTicket.DELETE_BY_CODE, query="DELETE FROM SoldTicket t WHERE t.orderCode=:orderCode")
})
public class SoldTicket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL = "SoldTicket.getAll";
	public static final String GET_BY_CODE = "SoldTicket.getByCode";
	public static final String COUNT_BY_CODE = "SoldTicket.countByCode";
	public static final String DELETE_BY_CODE = "SoldTicket.deleteByCode";

	@Id
	@SequenceGenerator(name="generatorTicket", sequenceName="ticket_ticket_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generatorTicket")
	@Column(name="ticket_id", nullable=false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ticket_buyer", nullable=false)
	private Long buyer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ticket_event", nullable=false)
	private Long event;
	
	@Column(name="ticket_ordercode", nullable=false)
	private String orderCode;
	
	@Column(name="ticket_resell", nullable=false)
	private Boolean toReSell;

	public Long getBuyer() {
		return buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Boolean getToReSell() {
		return toReSell;
	}

	public void setToReSell(Boolean toReSell) {
		this.toReSell = toReSell;
	}

	public Long getId() {
		return id;
	}
}
