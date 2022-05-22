import java.io.*;
import java.util.*;
public class Pattern {


    public static void main(String[] args)
    {
      Scanner in=new Scanner(System.in);
      System.out.println("Enter the number");
      int n=in.nextInt();
      int i,j,k;
      for(i=n;i>=1;i--)
        {
           for(j=i;j<n;j++)
            System.out.print(" ");
           for(k=1;k<=i;k++)
              System.out.print(" *");
            
          System.out.println();
              
       }
          
        }
    
  }
