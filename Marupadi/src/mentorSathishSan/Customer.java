package mentorSathishSan;

public class Customer {

	public static void main(String[] args) {
		
		Food customer1Food=FoodServer.getFood("Veg");
		
		System.out.println("Customer 1 ");
		System.out.println("Items "+ customer1Food.getItems().toString());
		System.out.println("Bill "+ customer1Food.getBill());
		
       Food customer2Food=FoodServer.getFood("NonVeg");
		
		System.out.println("Customer 2 ");
		System.out.println("Items "+ customer2Food.getItems().toString());
		System.out.println("Bill "+ customer2Food.getBill());
		
		
      //Food customer3Food=FoodServer.getFood("Italian");
		
		//System.out.println("Customer 3 ");
		//System.out.println("Items "+ customer3Food.getItems().toString());
		//System.out.println("Bill "+ customer3Food.getBill());
	
	
	}

}
