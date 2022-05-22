package mentorSathishSan;

public class FoodServer {
	public static Food getFood(String foodType)
	{
		if(foodType.equals("Veg"))
		{
			return new VegFood();
		}
		else if(foodType.equals("NonVeg"))
		{
			return new NonVegFood();
		}
		else
		{
			System.out.println("We are not serving the food type "+foodType);
			return null;
		}
		
	}

}
