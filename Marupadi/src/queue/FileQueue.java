package queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class FileQueue {
	public static void main(String[] args) throws IOException{  
        File dir = new File("D:\\ReadMultiFile");
        File[] files = dir.listFiles();
        int l=0,w=0,c=0;
        Queue<Integer> totalCharQueue = new PriorityQueue<>();
        // Fetching all the files
        for (File file : files) {
            if(file.isFile()) {
                BufferedReader inputStream = null;
                String line;
                try {
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine()) != null)
                    {
                    	String curLine=inputStream.readLine();
                        while(curLine!=null)
                        {
                        	l++;
                        	String word[]=curLine.split(" ");
                        	w=w+word.length;
                        	for(String wd:word)
                        		c=c+wd.length();
                        	
                        	curLine=inputStream.readLine();
                        }
                        totalCharQueue.add(c);
                        
                    }
                    //System.out.println("The file chars are in prio queue");
                    while (!totalCharQueue.isEmpty()) {
            			System.out.println(totalCharQueue.poll());
            		}
                }catch(IOException e) {
                	System.out.println(e);
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
        
	}

}


        