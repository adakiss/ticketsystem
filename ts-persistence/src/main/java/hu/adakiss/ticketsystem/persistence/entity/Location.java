package hu.adakiss.ticketsystem.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="location")
@NamedQueries({
	@NamedQuery(name=Location.GET_ALL, query="SELECT l FROM Location l"),
	@NamedQuery(name=Location.GET_BY_ADDRESS, query="SELECT l FROM Location l WHERE l.address=:address"),
	@NamedQuery(name=Location.COUNT_BY_ADDRESS, query="SELECT count(l) FROM Location l WHERE l.address=:address"),
	@NamedQuery(name=Location.DELETE_BY_ADDRESS, query="DELETE FROM Location l WHERE l.address=:address")
})
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_BY_ADDRESS = "Location.getByAddress";
	public static final String GET_ALL = "Location.getAll";
	public static final String COUNT_BY_ADDRESS = "Location.countByAddress";
	public static final String DELETE_BY_ADDRESS = "Location.deleteByEmail";
	
	@Id
	@SequenceGenerator(name="generatorLocation", sequenceName="location_location_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generatorLocation")
	@Column(name="location_id", nullable=false)
	private Long id;
	
	@Column(name="location_name", nullable=false)
	private String name;
	
	@Column(name="location_address", nullable=false, unique=true)
	private String address;
	
	@Column(name="location_capacity", nullable=false)
	private Integer capacity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}
}
