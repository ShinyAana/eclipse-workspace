package extra;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        int result = Result.migratoryBirds(arr);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}
class Result
{
	
public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
HashMap<Integer,Integer> hm=new HashMap<>();
for(int i=0;i<arr.size();i++)
{
    int key=arr.get(i);
    if(hm.containsKey(key))
    {
        int temp=hm.get(key);
        hm.put(key,temp+1);
    }
    else
    hm.put(key,1);
}
int result=0;
int maxValue=(Collections.max(hm.values()));
for(Map.Entry<Integer,Integer> obj:hm.entrySet())
{
    if(obj.getValue()==maxValue)
    result=obj.getKey();
}
return result;
    }

}


