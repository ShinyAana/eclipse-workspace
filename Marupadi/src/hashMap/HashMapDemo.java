package hashMap;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<>();
		hm.put(10,"Aanyaa");
		hm.put(12, "Subha");
		hm.put(13, "Serma");
		System.out.println(hm);
		System.out.println(hm.get(13));
		if(hm.containsKey(12))
		
	}

}
