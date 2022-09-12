package interviewQA;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		Map<String,String> mapObj = new HashMap<String, String>();
		poly(mapObj);
	}

	public static void poly(Map<String,String> vv)
	{
		System.out.println("Map");
	}

	public static void poly(HashMap<String,String> vv)
	{
		System.out.println("HashMap");
	}

	public static void poly(LinkedHashMap<String,String> vv)
	{
		System.out.println("LinkedHashMap");
	}
	

}

