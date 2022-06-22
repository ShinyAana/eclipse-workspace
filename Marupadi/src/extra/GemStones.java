package extra;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GemStones {
	public static void main(String[] args) 
	{
		Scanner scan  = new Scanner(System.in);
	    int numString = scan.nextInt();
	    int count = 0;
	    int [] arrayChars = new int[26];
	    Set<Character> charSet = new HashSet<Character>();

	    for(int i = 0; i< numString; i++) {
	        String str = scan.next();


	        for (char c : str.toCharArray()) {
	          charSet.add(c);
	        }

	        for (char s : charSet) {
	            int x = (int)s-97;
	            arrayChars[x]++;
System.out.println(arrayChars[x]);
System.out.println(numString);
	            if(arrayChars[x] >= numString){
	                count++;
	            }
	        }

	        charSet.clear();      
	    }

	    System.out.println(count); 
		
		
		/*
		 * Scanner scan = new Scanner(System.in); int t = scan.nextInt(); Set<Character>
		 * set = convertToSet(scan.next()); for(int i=1; i<t ;i++){
		 * set.retainAll(convertToSet(scan.next())); } System.out.print(set.size()); }
		 * public static Set<Character> convertToSet(String s) { Set<Character> set =
		 * new HashSet<Character>(26); for (char c : s.toCharArray())
		 * set.add(Character.valueOf(c)); return set;
		 */
	}
}
