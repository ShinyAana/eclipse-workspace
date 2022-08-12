package learn;

public class EncryptPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pass="aZPz123";
		String encrypt="";
		char[] smallAlpha=new char[26];
		char[] capAlpha=new char[26];
		for(int i=0;i<26;i++)
		{
			smallAlpha[i]=	(char) ('a'+i);
			capAlpha[i]=(char) ('A'+i);
		}
		for(int i=0;i<pass.length();i++)
		{
			if(pass.charAt(i)>='a' && pass.charAt(i)<='z')
			{
				int index=(int)pass.charAt(i)-'a';
				//System.out.println(index);
				encrypt+=smallAlpha[(index+1)%26];
			}
			else if(pass.charAt(i)>='A' && pass.charAt(i)<='Z')
			{
				int index1=(int)pass.charAt(i)-'A';
				encrypt+=capAlpha[(index1+1)%26];
			
			}
			else if(pass.charAt(i)>='0' && pass.charAt(i)<='9')
			{
				int num=(int)(pass.charAt(i)-48)+1;
				encrypt+=String.valueOf(num);
			}
			else
			{
				System.out.println("Enter valid password");
			}
			}
		System.out.println(encrypt);

	}

}
