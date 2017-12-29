package hu.adakiss.ticketsystem.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="event")
@NamedQueries({
	@NamedQuery(name=Event.GET_ALL, query="SELECT e FROM Event e"),
	@NamedQuery(name=Event.GET_BY_PK, query="SELECT e FROM Event e JOIN FETCH e.location JOIN FETCH e.organiser WHERE e.name=:name AND e.location=:location AND e.time=:time"),
	@NamedQuery(name=Event.COUNT_BY_PK, query="SELECT count(e) FROM Event e JOIN FETCH e.location JOIN FETCH e.organiser WHERE e.name=:name AND e.location=:location AND e.time=:time"),
	@NamedQuery(name=Event.DELETE_BY_PK, query="DELETE FROM Event e JOIN FETCH e.location JOIN FETCH e.organiser WHERE e.name=:name AND e.location=:location AND e.time=:time")
})
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL = "Event.getAll";
	public static final String GET_BY_PK = "Event.getByPK";
	public static final String COUNT_BY_PK = "Event.countByPK";
	public static final String DELETE_BY_PK = "Event.deleteByPK";

	@Id
	@SequenceGenerator(name="generatorEvent", sequenceName="event_event_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generatorEvent")
	@Column(name="event_id", nullable=false)
	private Long id;
	
	@Column(name="event_name", nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_location", nullable=false)
	private Location location;
	
	@Column(name="event_time", nullable=false)
	private Date time;
	
	@Column(name="event_allticket", nullable=false)
	private Integer allTicket;
	
	@Column(name="event_soldticket", nullable=false)
	private Integer soldTicket;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_organiser", nullable=false)
	private Organiser organiser;
	
	@Column(name="event_price")
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getAllTicket() {
		return allTicket;
	}

	public void setAllTicket(Integer allTicket) {
		this.allTicket = allTicket;
	}

	public Integer getSoldTicket() {
		return soldTicket;
	}

	public void setSoldTicket(Integer soldTicket) {
		this.soldTicket = soldTicket;
	}

	public Organiser getOrganiser() {
		return organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}
}
