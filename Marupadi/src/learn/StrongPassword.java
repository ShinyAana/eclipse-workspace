package learn;

public class StrongPassword {
	public static int minimumNumber(int n, String password) {
	    char ch;
	    //int count=6;
	    int lc=0,uc=0,sc=0,digit=0;
	    for(int i=0;i<password.length();i++)
	    {
	        ch=password.charAt(i);
	        if(ch>='a' && ch<='z'){
	            lc=1;
	        }
	        else if(ch>='A' && ch<='Z'){
	            uc=1;
	        }
	        else if(ch>='0' && ch<='9'){
	            digit=1;
	        }
	        else{
	            sc=1;
	        }
	    }
	    int req=4-(lc+uc+sc+digit);
	    if(n+req<6){
	        return 6-n;
	    }
	    else{
	        return req;
	    }

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
