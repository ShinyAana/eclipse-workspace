public class Cat {
	 void drink(double d) {
		System.out.print("Cat");
	}
	public static void main(String[] args) {
		PersianCat pcat=new PersianCat();
		pcat.drink(12);
		pcat.drink(12.0);
	}
}
class PersianCat extends Cat{ 
     void drink(int i) {
		System.out.print("PersianCat");	
	}
}