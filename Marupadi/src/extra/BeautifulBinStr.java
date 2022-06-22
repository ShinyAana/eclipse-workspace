package extra;

import java.util.Scanner;

public class BeautifulBinStr
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    String binaryStr = in.next();
	    int step = 0;
	    for (int i = 0; i <= n - 3;) {
	        if (binaryStr.substring(i, i + 3).equals("010")) {
	            step++;
	            i = i + 3;
	        } else {
	            i++;
	        }
	    }
	    System.out.println(step);
	}
}
