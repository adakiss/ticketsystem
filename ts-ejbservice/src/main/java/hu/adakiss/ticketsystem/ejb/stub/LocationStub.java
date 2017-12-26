package hu.adakiss.ticketsystem.ejb.stub;

public class LocationStub {
	
	private String locationName;
	private String locationAddress;
	private Integer maxCapacity;
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public LocationStub(String locationName, String locationAddress, Integer maxCapacity) {
		super();
		this.locationName = locationName;
		this.locationAddress = locationAddress;
		this.maxCapacity = maxCapacity;
	}
	
	@Override
	public String toString() {
		return "[Location: {" + locationName + "}, {" + locationAddress + "}, {" + maxCapacity + "}]";
	}
}
