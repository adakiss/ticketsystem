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
@Table(name="customer")
@NamedQueries({
	@NamedQuery(name=Customer.GET_ALL, query="SELECT c FROM Customer c"),
	@NamedQuery(name=Customer.GET_BY_EMAIL, query="SELECT c FROM Customer c WHERE c.email=:email"),
	@NamedQuery(name=Customer.COUNT_BY_EMAIL, query="SELECT count(c) FROM Customer c WHERE c.email=:email"),
	@NamedQuery(name=Customer.DELETE_BY_EMAIL, query="DELETE FROM Customer c WHERE c.email=:email")
})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_BY_EMAIL = "Customer.getByEmail";
	public static final String GET_ALL = "Customer.getAll";
	public static final String COUNT_BY_EMAIL = "Customer.countByEmail";
	public static final String DELETE_BY_EMAIL = "Customer.deleteByEmail";
	
	@Id
	@SequenceGenerator(name="generatorCustomer", sequenceName="customer_customer_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generatorCustomer")
	@Column(name="customer_id", nullable=false)
	private Long id;
	
	@Column(name="customer_name", nullable=false)
	private String name;
	
	@Column(name="customer_email", nullable=false, unique=true)
	private String email;
	
	@Column(name="customer_phone")
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
