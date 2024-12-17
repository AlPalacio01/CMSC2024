
public class Smoothie extends Beverage{
	
	
	private int numOfFruits;
	private boolean addProtein;
	private double ADD_PROTEIN = 1.50;
	private double ADD_FRUIT = 0.5;
	private int MAX_FRUITS = 2;
	

	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
		
		
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	@Override
	public double calcPrice() {
		
		double price = getBasePrice() + addSizePrice();
		
		if (MAX_FRUITS > numOfFruits) {
			
			int extraFruit = numOfFruits - MAX_FRUITS;
			
			while(extraFruit > 0) {
				
				price += ADD_FRUIT;
				
			}extraFruit--;
		}
		
		if (addProtein) {
			price += ADD_PROTEIN;
		}
		
		return price;
	}
	
	
	@Override
	public String toString() {
		
		String smoothieString = "Smoothie name: " + this.getBevName() + "\nSmoothie Size: " + this.getSize()
						+ "\nWas protein added?" + this.addProtein + "\nNumber of fruits: " 
						+ this.numOfFruits + "\nPrice: " + this.calcPrice();
		
		return smoothieString;
		
	}

	@Override
	public boolean equals(Object anotherBev) {
	
		

		if(this == anotherBev) {
			return true;
		}
		if(this != anotherBev || getClass() != anotherBev.getClass()) {
			return false;
		}
		
		Smoothie smoothie = (Smoothie) anotherBev;
	    return numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
	}
}