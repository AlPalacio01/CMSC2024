
public class Alcohol extends Beverage{
	
	
	private boolean isWeekend;
	private double weekendPrice = 0.6;


	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend();
	}


	public boolean isWeekend() {
		return isWeekend;
	}
	
	@Override
	public double calcPrice() {
		
		double price = getBasePrice() + addSizePrice();
		
		if (isWeekend) {
			price += weekendPrice;
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
		
		
		Alcohol alcohol = (Alcohol) anotherBev;
        return  isWeekend == alcohol.isWeekend;
	}
	
	@Override
	public String toString() {
		
		String alcoholString = "Alcohol name: " + this.getBevName() + "\nAlcohol Size: " + this.getSize()
						+ "\n Is it offered on weekends?" + this.isWeekend + "\nPrice: " + this.calcPrice();
		
		return alcoholString;
		
	}

}
