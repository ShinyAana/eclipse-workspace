package datatypesAndVariables;

public class MutableAndImmutable {
	public static void main(String []args){ 
        String a = "First " + 1/2 + " second "+ (0.5==1/2) + "Very good".substring(4); 
        System.out.println(a); 
        String s1="Aanya";
        s1.concat("Kalidas");//we can't do it
        System.out.println(s1);//print Aanya
         
        StringBuilder aa = new StringBuilder("First "); 
        aa.append(1/2); 
        aa.append(" second "); 
        aa.append(0.5==1/2); 
        aa.append("Very good".substring(4)); 
        System.out.println(aa.toString()); 
     } 
}