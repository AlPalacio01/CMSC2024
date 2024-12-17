
public class Coffee extends Beverage {


	private boolean extraShot;
	private boolean extraSyrup;
	private double EXTRA_SHOT;
	private double EXTRA_SYRUP;
	
	
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		
		return extraSyrup;
	}
	
	@Override
	public double calcPrice() {
		
		double price = getBasePrice() + addSizePrice();
		
		
		if (extraShot) {
			price += EXTRA_SHOT;
		}
		if (extraSyrup) {
			price += EXTRA_SYRUP;
		}
		return price;
	}
	
	
	@Override
	public boolean equals(Object anotherBev) {
	
		
		if(this == anotherBev) {
			return true;
		}
		if(this != anotherBev || getClass() != anotherBev.getClass()) {
			return false;
		}
		
		
		Coffee coffee = (Coffee) anotherBev;
        return  extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
	}
	
	@Override
	public String toString() {
		
		String coffeeString = "Coffee name: " + this.getBevName() + "\nCoffee Size: " + this.getSize()
						+ "\n Does it contain extra shots?" + this.extraShot 
						+ "\n Does it contain extra syrup?" + this.extraSyrup  + "\nPrice: " + this.calcPrice();
		
		return coffeeString;
		
	}
	
}
