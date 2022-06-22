package datatypesAndVariables;

public class StringConcad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		s1.concat("World");// we can't do it
		System.out.println(s1);// print Hello
		StringBuilder sb = new StringBuilder("Hello");
		sb.append("World");
		System.out.println(sb);
		char ch='/';
		int ch1=ch;
		System.out.println(ch1);
	}

}
