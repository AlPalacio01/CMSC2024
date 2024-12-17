
public class Customer extends Object{

	
	private String name;
	private int age;
	

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public Customer(Customer c) {
		
		this.name = c.name;
		this.age = c.age;
	}
	
	
	
	public int getName() {
		return this.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		
		return "Customer name: " + this.getName() + " || Customer Age: " + this.getAge();
	}
	
	

}
