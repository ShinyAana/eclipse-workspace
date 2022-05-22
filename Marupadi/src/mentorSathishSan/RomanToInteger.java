package mentorSathishSan;
import java.io.*;
import java.util.*;

public class RomanToInteger {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		HashMap<Character,Integer> hashMap=new HashMap<>();
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);
		System.out.println("Enter the Roman characters ");
		String romanCharacters=in.next();
		int result=hashMap.get(romanCharacters.charAt(romanCharacters.length()-1));
		for(int i=romanCharacters.length()-1;i>0;i--)
		{
			if(hashMap.get(romanCharacters.charAt(i))<=hashMap.get(romanCharacters.charAt(i-1)))
			{
				result+=hashMap.get(romanCharacters.charAt(i-1));
			}
			else
			{
				result-=hashMap.get(romanCharacters.charAt(i-1));
				
			}
		}
		System.out.println("Integer value equal to the  Roman characters "+ result);
		}
		
	}


