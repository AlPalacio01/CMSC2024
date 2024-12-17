import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable <Order>{

	
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;


	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.beverages = new ArrayList<>();
		this.orderNo = generateOrder();
	}
	
	public int generateOrder() {
		Random number = new Random();
		return number.nextInt(80000) + 10000;
		
	}
	

	public int getOrderNo() {
		return this.orderNo;
	}
	
	public int getOrderTime() {
		return this.orderTime;
	}
	
	public Day getOrderDay() {
		return this.orderDay;
	}
	
	public Customer getCustomer() {
		return this.cust;
	}
	
	
	@Override
	public Beverage getBeverage(int itemNo) {
		
		if (itemNo >= 0 && itemNo < beverages.size()) {
			
			Beverage bev = beverages.get(itemNo);
	        return bev;
		}
		return null;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	
	
	
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	
	@Override
	public void addNewBeverage(String bevName, Size size) {
		
		
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	
	@Override
	public double calcOrderTotal() {
		
		double total = 0.0;
		
		for(Beverage bev : beverages) {
			total += bev.calcPrice();
		}
		
		return total;
	}
	
	@Override
	public int findNumOfBeveType(Type type) {
		
		int count = 0;
		
		for (int i = 0; i < beverages.size(); i++) {
			
			 Beverage bev = beverages.get(i);
			 
			 if (bev.getType() == type) {
		            count++;
		     }
		}
		
		
		return count;
	}
	
	public String toString() {
		
		String string = "Order Number: " + orderNo + "\nTime: " + orderTime + "\nDay: "
						+ orderDay + "\nCustomer: " + cust + "\nBeverages: "; 

        for (Beverage bev : beverages) {
            string += "		- " + bev + "\n";
        }
        return string;
		
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		
		return Integer.compare(this.orderTime, anotherOrder.orderTime);

	}

	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY ||orderDay == Day.SUNDAY) {
			return true;
		}
		return false;
	}
	
	
	
}
