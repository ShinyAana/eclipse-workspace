package arrayList;
import java.io.*;
import java.util.*;
public class ArrayListMethods {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> arrInt=new ArrayList<>();
		ArrayList<String> arrStr=new ArrayList<>();
		ArrayList<Object> arrObj=new ArrayList<>();
		//int[] intarr=new int[]{2,4,5,6,7};
		//for(int n=0;n<5;n++)
			//arrInt.set(n,intarr(n));
		arrInt.add(12);
		arrInt.add(22);
		arrInt.add(32);
		arrInt.add(42);
		arrInt.add(52);
arrStr.add("Aanyaa");
arrStr.add("Subha");
arrStr.add("Serma");
arrStr.add("Alagu");
arrStr.add("Kalidas");
         arrObj.add(23);
         arrObj.add("hello");
         arrObj.add("Priya");
         arrObj.add(3453);
         arrObj.add("36478209");
     arrInt.set(1, 77);
     arrStr.set(1, "Jesus");
     arrObj.set(1, 787);
     arrInt.add(2, 100); 
     
     for(Integer i:arrInt)
    	 System.out.print(i + " ");
 
         System.out.println();
 
     arrInt.remove(2);
     for(Integer i:arrInt)
        	 System.out.print(i + " ");
     System.out.println();
     arrInt.remove(arrInt.indexOf(42));
     for(Integer i:arrInt)
    	 System.out.print(i + " ");
 
         System.out.println();
         for(String j:arrStr)
        	 System.out.print(j + " ");
         System.out.println();
         for(Object k:arrObj)
        	 System.out.print(k + " ");
         
        	}

}
