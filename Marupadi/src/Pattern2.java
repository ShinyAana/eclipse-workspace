import java.io.*;
import java.util.*;
public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
	      System.out.println("Enter the number");
	      int n=in.nextInt();
	      int i,j,k;
	      for(i=1;i<=n;i++)
	        {
	           for(j=i;j<n;j++)
	            System.out.print(" ");
	           for(k=1;k<=i;k++)
	              System.out.print(" *");
	            
	          System.out.println();
	              
	       }
	}

}
