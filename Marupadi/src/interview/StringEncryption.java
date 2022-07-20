package interview;

public class StringEncryption {

	public static void main(String[] args)
	{
String str1="mom";
String str2="dad";
int i=0,j=0;
char[] alpha = new char[26];
for(int k = 0; k < 26 ; k++){
    alpha[k] = (char)('a' + k);
}

//System.out.print(alpha);
String result="";

  while(i<str1.length() && j<str2.length())
  {
	  int str1Ascii=(int)str1.charAt(i); 
	  int str2Ascii=(int)str2.charAt(j); 
	  int val1=str1Ascii-'a' + 1; 
	  int val2=str2Ascii-'a'+ 1;
	  result+="" + alpha[(val1+val2-1)%26];
	  //System.out.print(val1 + " " + val2);
  i++;
  j++;
  }
  System.out.println(result);
 
	}

}
