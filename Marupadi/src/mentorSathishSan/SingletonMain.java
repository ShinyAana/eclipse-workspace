package mentorSathishSan;

public class SingletonMain {

	public static void main(String[] args) {
		
		//Singleton object=new Singleton();
		
		Singleton singleton1=Singleton.getInstance();
		
		Singleton singleton2=Singleton.getInstance();
		
		singleton1.displayMessage();
		
		singleton2.displayMessage();
		
		System.out.println(singleton1);
		
		System.out.println(singleton2);
		
	}

}
