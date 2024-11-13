import com.sun.net.httpserver.Authenticator.Result;

public class ManagementCompany {

	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	public String name;
	public String taxID;
	public double mgmFeePer;
	public int count;
	public Plot plot;
	public Property[] properties;
	
	
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFeePer = 0.0;
		count = 0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.count = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.count = 0;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		count = otherCompany.count;
		plot = otherCompany.plot;
		properties = otherCompany.properties;
		
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		Property property1 = new Property(name, city, rent, owner);
		properties[count] = property1;
		count++;
		
		return count-1;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		Property property1 = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (!plot.encompasses(property1.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < count; i++) {
			if (property1.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		
		properties[count] = property1;
		count++;
		
		return --count;
	}
	
	public int addProperty(Property property) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		
		if (property == null) {
			return -2;
		}
		
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < count; i++) {
			if (property.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		
		Property property1 = new Property(property);
		properties[count] = property1;
		count++;
		return count-1;
	}
	
	public void removeLastProperty() {
		if (count > 0) {
            properties[-count] = null;
        }	
	}
	
	public boolean isPropertiesFull() {
		return count >= MAX_PROPERTY;
	}
	
	
	public int getPropertiesCount() {
		return count;
	}
	
	public double getTotalRent() {
		double totalRent = 0.0;
		
		for (int i=0; i < count; i++) {
			totalRent += properties[i].getRentAmount();
		}
		
		return totalRent;
	}
	
	public Property getHighestRentProperty(){
		if (count == 0) {
			return null;
		}
		Property highestRentProperty = properties[0];
		
		for (int i=0; i < count; i++) {
			if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
				highestRentProperty = properties[i];
			}
		}
		return highestRentProperty;
	}
	
	public double rentTotal() {
		double rentTotal = 0.0;
		for (int i=0; i < count; i++) {
			rentTotal = properties[i].getRentAmount();
		}
		return rentTotal;
	}
	
	public boolean isManagementFeeValid() {
		
		if(mgmFeePer > 100 || mgmFeePer < 0) {
			return false;
		}
		return true;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}

	public Property[] getProperties() {
		return properties;
	}
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("List of the properties for ").append(name);
		string.append(", taxID: ").append(taxID);
		string.append("\n______________________________________________________\n");
		
		for(int i = 0; i < count; i++) {
			
			Property property = properties[i];
			
			string.append(property.getPropertyName());
			string.append(",").append(property.getCity());
			string.append(",").append(property.getOwner());
			string.append(",").append(property.getRentAmount());
			string.append("\n______________________________________________________\n");
		}
		
		double MGMFee = (rentTotal() * mgmFeePer)/100;
		
		string.append("\n total management Fee: " ).append(MGMFee);
		
		return string.toString();
		
		
	}
	
	

}






















