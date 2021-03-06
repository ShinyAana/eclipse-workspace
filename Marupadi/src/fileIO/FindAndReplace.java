package fileIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException
	{
	replaceTheText("D:\\File\\File1.txt","Java","C++","D:\\File\\File2.txt");
	}

	private static void replaceTheText(String fileFrom, String target, String replace, String fileTo) throws IOException 
	{
       Path fromPath=Paths.get(fileFrom);
       Path toPath=Paths.get(fileTo);
       Charset ch=Charset.forName("UTF-8");
       BufferedWriter bw=Files.newBufferedWriter(toPath,ch);
       Scanner scanner=new Scanner(fromPath,ch.name());
       String line;
       while(scanner.hasNextLine())
       {
    	   line=scanner.nextLine();
    	   line=line.replaceAll(target, replace);
    	   bw.write(line);
    	   bw.newLine();
       }
       scanner.close();
       bw.close();
	}

}
