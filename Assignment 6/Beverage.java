import java.util.Objects;

public abstract class Beverage {
	
	private String bevName;
	private Type type;
	private Size size;
	private double BASE_PRICE = 2.0;
	private double SIZE_PRICE = 0.5;
	
	
	public Beverage(String bevName,Type type, Size size) {
		
		this.bevName = bevName;
		this.type = type;
		this.size = size;
		
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public String getBevName() {
		return this.bevName;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public Size getSize() {	
		return this.size;
	}
	
	
	
	public double addSizePrice() {
		
		double addSizeTotal = 0.0;
		
		switch(size) {
		
			case LARGE:
				addSizeTotal += SIZE_PRICE;
				break;
			case MEDIUM:
				addSizeTotal += SIZE_PRICE;
				addSizeTotal += SIZE_PRICE;
				break;
			case SMALL:
			
			default:
				break;
		}
		return addSizeTotal;
	}
	
	
	@Override
	public String toString() {
		
		return "Beverage name: " + getBevName() + "Beverage type: " + getType() + "Beverage Size: " + getSize();
	}
	
	@Override
	public boolean equals(Object anotherBev) {
	
		
		if(this == anotherBev) {
			return true;
		}
		if(this != anotherBev || getClass() != anotherBev.getClass()) {
			return false;
		}
		
		Beverage beverage = (Beverage) anotherBev;
        return Objects.equals(bevName, beverage.bevName) && beverage.size == size && beverage.type == type;
	}

	public abstract double calcPrice();

}


