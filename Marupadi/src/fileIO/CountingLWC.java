package fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountingLWC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int l=0,w=0,c=0;
		BufferedReader br=new BufferedReader(new FileReader("D:\\File\\Sample.txt"));
        String curLine=br.readLine();
        while(curLine!=null)
        {
        	l++;
        	String word[]=curLine.split(" ");
        	w=w+word.length;
        	for(String wd:word)
        		c=c+wd.length();
        	curLine=br.readLine();
        }
        System.out.println("Number of LINES "+(l-1));
        System.out.println("Number of WORDS "+w);
        System.out.println("Number of CHARACTERS "+c);
    	
	}
	

}
