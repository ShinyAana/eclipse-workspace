package learn;

import java.util.HashMap;
import java.util.Map;

public class OddRepeatingChar {

	public static void main(String[] args)
	{
	String str="datastructure";
	HashMap<Character,Integer> hm=new HashMap<>();
	for(int i=0;i<str.length();i++)
	{
		if(hm.containsKey(str.charAt(i)))
		{
			hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
		}
		else
		{
			hm.put(str.charAt(i), 1);
		}
	}
	System.out.println(hm);
	for(Map.Entry<Character,Integer> entry:hm.entrySet() )
	{
		int temp=entry.getValue();
		if(temp%2!=0)
		{
			System.out.print(entry.getKey() + " ");
		}
		else
		{
			continue;
		}
	}
	
	}
	

}





/*
 * String s = "AJAYkumarReddy"; String sub = "kumar"; int count = 0; for (int i=
 * 0; i < s.length(); i++) { if (s.charAt(i) == sub.charAt(count)) { count++; }
 * else { count = 0; } if (count == sub.length()) {
 * System.out.println("Sub String"); return; }
 * 
 */
 
