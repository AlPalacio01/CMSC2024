
public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		plot = new Plot();
		
	}
	
	public Property(Property otherProperty) {
		propertyName = otherProperty.getPropertyName();
		city = otherProperty.getCity();
		rentAmount = otherProperty.getRentAmount();
		owner = otherProperty.getOwner();
		plot = otherProperty.getPlot();
	}
	
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
		
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		 
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
		
	}


	
	// Property Name
	public void setPropertyName(String propertyName){
		this.propertyName = propertyName;
	}
	public String getPropertyName(){
		return propertyName;
	}
	
	
	// City
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}
	
	
	// Rent Amount
	public void setRentAmount(int rentAmount){
		this.rentAmount = rentAmount;
	}
	public double getRentAmount(){
		return rentAmount;
	}
	
	
	// Owner 
	public void setOwner(String owner){
		this.owner = owner;
	}
	public String getOwner(){
		return owner;
	}
	
	
	// Plot
	public void setPlot(int x, int y, int width, int depth){
		plot = new Plot(x, y, width, depth);
	}
	public Plot getPlot(){
		return plot;
	}
	
	
	public String toString() {
		String string;
		
		string =  propertyName + "," + city + "," + owner + "," + rentAmount;
		
		return string;
	}
	
	
}