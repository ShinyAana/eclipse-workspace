package fileIO;

import java.io.FileInputStream;
import java.util.HashMap;

public class FileInputReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream obj=new  FileInputStream("D:\\WordFile.doc");
			int i=0;
			while((i=obj.read())!=-1)
			{
				System.out.print((char)i);
			}
			obj.close();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
