package mentorSathishSan;
import java.util.*;
public class ComparatorSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {"Aanya","Viyana","SubhaSelvarani","Rani"};
		Arrays.sort(names);
		for(String str:names)
			System.out.println(str);

		Comparator<String> comp=new ComparatorDemo();
		Arrays.sort(names, comp);
for(String str:names)
	System.out.println(str);
	}

}
