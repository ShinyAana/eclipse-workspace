
import java.io.*;
import java.util.*;

public class IsVowel1 
{
	public static void main(String[] args) 
	{
	char ch;
   // char[] vow={'a','e','i','o','u'};
    Scanner r=new Scanner(System.in);
    System.out.println("Enter any alphabet");
    ch=r.next().charAt(0);
    int i=0;
    switch(ch)
	{
	 case  'a' :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'e'  :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'i'   :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'o'  :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'u'  :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case  'A' :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'E'  :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'I':
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'O'  :
		 System.out.println("Vowel");
		 i++;
		 break;
	 case 'U'  :
		 System.out.println("Vowel");
		 i++;
		 break;
		 default:
			 System.out.println("Consonant");
		 
	}
	if(i==1)
	System.out.println("Entered character "+ch+" is  Vowel");
	/*else 
		if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
		System.out.println("Entered character "+ch+" is Consonent");
		else
		System.out.println("Not an alphabet");	*/
	
}
}
