package hu.adakiss.ticketsystem.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="organiser")
@NamedQueries({
	
})
public class Organiser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_BY_NAME = "Organiser.getByName";
	public static final String GET_ALL = "Organiser.getAll";
	public static final String COUNT_BY_NAME = "Organiser.countByName";
	public static final String DELETE_BY_NAME = "Organiser.deleteByName";
	
	@Id
	@SequenceGenerator(name="generatorOrganiser", sequenceName="organiser_organiser_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generatorOrganiser")
	@Column(name="organiser_id", nullable=false)
	private Long id;
	
	@Column(name="organiser_name", nullable=false, unique=true)
	private String name;
	
	@Column(name="organiser_email", nullable=false)
	private String email;
	
	@Column(name="organiser_address")
	private String address;
	
	@Column(name="organiser_phone")
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}
}
