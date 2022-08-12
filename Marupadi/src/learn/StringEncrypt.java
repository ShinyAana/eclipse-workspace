package learn;

public class StringEncrypt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String S="aaaaaaaaaaa";
	        String ans="";
	        Character curr=S.charAt(S.length()-1);
	        int count=1;
	        for(int i=S.length()-2;i>=0;i--){
	            if(curr==S.charAt(i)){
	                count+=1;
	            }else{
	                ans=ans+Integer.toHexString(count)+curr;
	                count=1;
	                curr=S.charAt(i);
	            }
	        }
	        ans=ans+Integer.toHexString(count)+curr;
	        //return ans;
	        System.out.println(ans);
	    

	}

}
