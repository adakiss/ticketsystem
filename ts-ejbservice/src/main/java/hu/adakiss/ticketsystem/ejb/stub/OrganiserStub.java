package hu.adakiss.ticketsystem.ejb.stub;

public class OrganiserStub {
	
	private String organiserName;
	private String organiserAddress;
	private String organiserTel;
	private String organiserEmail;
	
	public String getOrganiserName() {
		return organiserName;
	}
	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}
	public String getOrganiserAddress() {
		return organiserAddress;
	}
	public void setOrganiserAddress(String organiserAddress) {
		this.organiserAddress = organiserAddress;
	}
	public String getOrganiserTel() {
		return organiserTel;
	}
	public void setOrganiserTel(String organiserTel) {
		this.organiserTel = organiserTel;
	}
	public String getOrganiserEmail() {
		return organiserEmail;
	}
	public void setOrganiserEmail(String organiserEmail) {
		this.organiserEmail = organiserEmail;
	}
	
	public OrganiserStub(String organiserName, String organiserAddress, String organiserTel, String organiserEmail) {
		super();
		this.organiserName = organiserName;
		this.organiserAddress = organiserAddress;
		this.organiserTel = organiserTel;
		this.organiserEmail = organiserEmail;
	}
	
	@Override
	public String toString() {
		return "[Organiser: {" + organiserName + "}, {" + organiserAddress + "}, {" + organiserTel + "}, {" + organiserEmail + "}]";
	}
}
