import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	
	public ArrayList<Order> orders;
	private static final int MAX_FRUIT = 3;
    private static final int MAX_ORDER_FOR_ALCOHOL = 3;
    private static final int MIN_AGE_FOR_ALCOHOL = 21;
    private static final int MIN_TIME = 8;
    private static final int MAX_TIME = 23;
    private int numAlcohol;
    private int currentOrderIndex;

    
    public BevShop() {
    	
		orders = new ArrayList<>();
	}
    
    
    public boolean isValidTime(int time) {
    	
    	return time >= MIN_TIME && time <= MAX_TIME;
    }
    
    
    public int getMaxNumOfFruits() {
    	
    	return MAX_FRUIT;
    }
    
    
    public int getMinAgeForAlcohol() {

    	return MIN_AGE_FOR_ALCOHOL;
    }
    
    
    public boolean isMaxFruit(int numOfFruits) {
    	
    	return numOfFruits > getMaxNumOfFruits();
    }
    
    
    public int getMaxOrderForAlcohol() {
    	
    	return MAX_ORDER_FOR_ALCOHOL;
    }
    
    
    public boolean isEligibleForMore() {
    	
    	return getNumOfAlcoholDrink() < getMaxOrderForAlcohol();
    }
    
    
    @Override
    public int getNumOfAlcoholDrink() {
    	
    	int alcoholCount = 0;
    	
    	Order currentOrder = getCurrentOrder();
    	
    	if (currentOrder != null) {
    		
    		for (int i = 0; i < currentOrder.getTotalItems(); i++) {
    			
    			if (currentOrder.getBeverage(i).getType() == Type.ALCOHOL) {
                    alcoholCount++;
    			}             
    		}
    	}
    	return alcoholCount;
    }
    
    
    public boolean isValidAge(int age) {
    	
    	return age >= getMinAgeForAlcohol();
    }
    
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
    	
    	Customer customer = new Customer(customerName, customerAge);
    	Order order = new Order(time, day, customer);
        orders.add(order);
        currentOrderIndex = orders.indexOf(order);
		numAlcohol = 0;
    	
    }
    
    public void processCoffeeOrder(String bevName, Size size,boolean extraShot, boolean extraSyrup) {
    	getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }
    
    public void processAlcoholOrder(String bevName, Size size) {
    	getCurrentOrder().addNewBeverage(bevName, size);
    }
    
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
    	getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }
    
     
    public int findOrder(int orderNo) {
    	
    	for (int i= 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
    	
    }
    
    
    public double totalOrderPrice(int orderNo) {
    	
    	return orders.get(findOrder(orderNo)).calcOrderTotal();
    }
    
    
    public double totalMonthlySale() {
    	
    	double sum = 0;
		for (int i = 0; i < orders.size(); i++ ) {
			sum += orders.get(i).calcOrderTotal(); 
		}
		return sum;
    	
    }
    
    
    public int totalNumOfMonthlyOrders() {
    	
    	return orders.size();
    }
    
    
    public Order getCurrentOrder() {
    	
    	return orders.get(currentOrderIndex);
    }
    
    
    @Override
    public Order getOrderAtIndex(int index) {
    	
    	if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }
    
    
    @Override
    public void sortOrders() {
    	
    	for (int i = 0; i < orders.size(); i++) {
    		
            int min = i; 
            for (int j = i + 1; j < orders.size(); j++) { 
                if (orders.get(j).getOrderNo() < orders.get(min).getOrderNo()) {
                	min = j;  
                }
            }
     
            if (min != i) {
                Order tempOrder = orders.get(i);
                orders.set(i, orders.get(min));
                orders.set(min, tempOrder);
            }
        }
    }
    
    
    
    public String toString() {
    	
    	String string = "Orders: \n";
    	for (Order order : orders) {
    		string += (order.toString() + "\n");
        }
    	string += "Monthly Sale: " + totalMonthlySale() + "\n";
    	
    	return string;
    }
}
















