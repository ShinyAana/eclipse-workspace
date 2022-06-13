package fileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) {
		try {
			FileOutputStream fosObject = new FileOutputStream("D:\\FileOutput.txt");

			String fileInput = "hi every one";
			byte fileInputByte[] = fileInput.getBytes();

			fosObject.write(fileInputByte);
			fosObject.close();

			System.out.println("DONE");

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
