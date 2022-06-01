package fileIO;

import java.util.HashMap;
import java.util.*;
import java.io.*;


	public class A{

	    HashMap<String,String> hm;
	    public A(){
	        hm=new HashMap<String,String>();

	        hm.put("1","A");
	        hm.put("2","B");
	        hm.put("3","C");

	        method2(hm);

	    }

	public void method2(HashMap<String,String> map) {
	    //write to file : "fileone"
	    try {
	        File fileTwo=new File("D:\\FileTest.txt");
	        FileOutputStream fos=new FileOutputStream(fileTwo);
	        PrintWriter pw=new PrintWriter(fos);

	        for(Map.Entry<String,String> m :map.entrySet()){
	            pw.println(m.getKey()+"="+m.getValue());
	        }

	        pw.flush();
	        pw.close();
	        fos.close();
	    } catch(Exception e) {}

	    //read from file 
	    try {
	        File toRead=new File("filetwo.txt");
	        FileInputStream fis=new FileInputStream(toRead);

	        Scanner sc=new Scanner(fis);

	        HashMap<String,String> mapInFile=new HashMap<String,String>();

	        //read data from file line by line:
	        String currentLine;
	        while(sc.hasNextLine()) {
	            currentLine=sc.nextLine();
	            //now tokenize the currentLine:
	            StringTokenizer st=new StringTokenizer(currentLine,"=",false);
	            //put tokens ot currentLine in map
	            mapInFile.put(st.nextToken(),st.nextToken());
	        }
	        fis.close();

	        //print All data in MAP
	        for(Map.Entry<String,String> m :mapInFile.entrySet()) {
	            System.out.println(m.getKey()+" : "+m.getValue());
	        }
	    }catch(Exception e) {}
	  }

	public static void main(String args[]) {
	        new A();
	}

	}
	


