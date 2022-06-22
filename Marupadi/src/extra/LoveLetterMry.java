package extra;

import java.util.Scanner;

public class LoveLetterMry 
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    for(int ii = 0; ii < n; ii++){
	        String s = sc.next();
	        int count = 0;
	        // use two pointers;
	        int i = 0, j = s.length() - 1;
	        while(i < j){
	            count += Math.abs(s.charAt(i) - s.charAt(j));
	            i++; j--;
	        }
	        System.out.println(count);
	    }
	}
}
