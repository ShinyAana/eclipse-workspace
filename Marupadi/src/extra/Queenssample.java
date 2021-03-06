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

class QResult{

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
    int[][] arr=new int[n][n];
        int r=r_q-1;
        int c=c_q-1;
        int count=0;
        for(List<Integer> i:obstacles)
        {
            arr[i.get(0)-1][i.get(1)-1]=1;
        }
        /*
         * for(int i=0;i<5;i++) { for(int j=0;j<5;j++) { System.out.print(arr[i][j] +
         * " "); } System.out.println(); }
         */    
        //Left Right travel
for(int i=c+1;i<n;i++)
{
    if(arr[r][i]==1)
        break;
    count++;
}
for(int i=c-1;i>=0;i--)
{
    if(arr[r][i]==1)
        break;
    count++;
}
//Top Bottom travel
for(int i=r-1;i>=0;i--)
{
    if(arr[i][c]==1)
        break;
    count++;
}
for(int i=r+1;i<n;i++)
{
    if(arr[i][c]==1)
        break;
    count++;
}
//up left
for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--)
{
    if(arr[i][j]==1)
        break;
    count++;
}
//bottom right
for(int i=r+1,j=c+1;i<n&&j<n;i++,j++)
{
    if(arr[i][j]==1)
        break;
    count++;
}
//System.out.println(count);

//up right
for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++)
{
    if(arr[i][j]==1)
        break;
    count++;
}
//bottom left
for(int i=r+1,j=c-1;i<n&&j>=0;i++,j--)
{
    if(arr[i][j]==1)
        break;
    count++;
}

return count;





//System.out.println(count);
        
    }




    }

public class Queenssample {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = QResult.queensAttack(n, k, r_q, c_q, obstacles);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();
System.out.println(result);
        bufferedReader.close();
        //bufferedWriter.close();
    }
}

