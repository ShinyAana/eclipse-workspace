package fileIO;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
public class DocReadWrite 
{
public static void main(String[] args) throws Throwable {
//to read
File infile = new File("D:\\WordFile.docx");
StringBuffer buffer = new StringBuffer();
String string = new String();
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
while ((string = reader.readLine()) != null) {
buffer.append(string);
//buffer.append(\n);
}
reader.close();
//to write
File outfile = new File(�output.doc�);
FileOutputStream fos = new FileOutputStream(outfile);
DataOutputStream dos = new DataOutputStream(fos);
dos.writeBytes(buffer.toString());
dos.close();
dos.flush();
fos.close();
}
}
