

package fileIO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageTransfer
{
	public static void main(String[] args) throws IOException
	{
		ImageTransfer object = new ImageTransfer();
		object.startImageProcessing();
		
	}

	private void startImageProcessing() 
	{
		byte[] imageToByte =readFile();
	    writeFile(imageToByte);

	}

	public byte[] readFile() {
		FileInputStream fisObject = null;
		byte[] imageToByte = null;
		try {

			File imageFile = new File("C:\\Users\\kdins\\eclipse-workspace\\Marupadi\\src\\fileIO\\Butterfly.jpg");
			fisObject = new FileInputStream(imageFile);

			long imageFileSize = imageFile.length();
			imageToByte = new byte[(int) imageFileSize];

			fisObject.read(imageToByte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fisObject != null) {
				try {
					fisObject.close();
				}

				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return imageToByte;

	}

	public void writeFile(byte[] imageToByte) {
		FileOutputStream fosObject = null;
		BufferedOutputStream bosObject = null;
		try {
			fosObject = new FileOutputStream(
					new File("C:\\Users\\kdins\\eclipse-workspace\\Marupadi\\src\\fileIO\\Butterfly70.jpg"));
			bosObject = new BufferedOutputStream(fosObject);
			bosObject.write(imageToByte);

			System.out.println("Image copied to new file");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fosObject != null) {
				try {
					fosObject.close();
					bosObject.close();

				}

				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

//If you want to try with DataOutputStream make use of it.
// DataOutputStream dosObject = new DataOutputStream(bosObject);
// DataOutputStream dosObject = new DataOutputStream(new
// BufferedOutputStream(new FileOutputStream(new
// File("C:\\Users\\kdins\\eclipse-workspace\\Marupadi\\src\\fileIO\\outputsun.jpg"))));

// dosObject.write(imageToByte);
