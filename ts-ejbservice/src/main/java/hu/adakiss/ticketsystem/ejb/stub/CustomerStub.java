package hu.adakiss.ticketsystem.ejb.stub;

public class CustomerStub {

	private String customerName;
	private String customerEmail;
	private String customerPhone;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public CustomerStub(String customerName, String customerEmail, String customerPhone) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}
	
	@Override
	public String toString() {
		return "[Customer: {" + customerName + "}, {" + customerEmail + "}, {" + customerPhone + "}]";
	}
}
