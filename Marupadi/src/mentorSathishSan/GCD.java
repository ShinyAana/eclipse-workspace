package mentorSathishSan;

import java.util.Scanner;

public class GCD {

	   public static void main(String args[]){
	      int a, b,  hcf = 0;
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Enter first number  ");
	      a = sc.nextInt();
	      System.out.println("Enter second number  ");
	      b = sc.nextInt();
	      while (a!= b)
	      {
	          if (a > b)
	              a-= b;
	          else
	              b-= a;
	          System.out.println("HCF "+ a);   
	      }
	      

	}
}