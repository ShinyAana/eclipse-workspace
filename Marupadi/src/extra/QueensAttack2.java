package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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


class Result1
{
public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles)
	 {

	int moveCount = 0;

   moveCount = moveCount + diagonalCount(r_q, c_q, obstacles, n);
   moveCount = moveCount + verticalCount(r_q, c_q, obstacles, n);
   moveCount = moveCount + horizontalCount(r_q, c_q, obstacles, n);

  return moveCount;
	 }


static int diagonalCount(int r_q,int c_q,List<List<Integer>> obstacles, int n)
{
    int moveCount = 0;
    int runningRow = r_q;
    int runningCol = c_q;

    while(runningRow>1 && runningCol > 1)
    {
        runningRow = runningRow - 1;
        runningCol = runningCol - 1;

        if(r_q == 1 || c_q == 1)
            break;

        if(isObstacle(runningRow, runningCol, obstacles))
        {
            break;
        }
        moveCount = moveCount + 1;
    }   

    runningRow = r_q;
    runningCol = c_q;
    while(runningRow>1 && runningCol < n)
    {

        runningRow = runningRow- 1;
        runningCol = runningCol + 1;


        if(isObstacle(runningRow, runningCol, obstacles))
        {
            break;
        }
        moveCount = moveCount + 1;
    }   

    runningRow = r_q;
    runningCol = c_q;
    while(runningRow < n  && runningCol > 1)
    {
        runningRow = runningRow + 1;
        runningCol = runningCol - 1;

        if(r_q == n || c_q == 1)
            break;

        if(isObstacle(runningRow, runningCol, obstacles))
        {
            break;
        }
        moveCount = moveCount + 1;
    }   

    runningRow = r_q;
    runningCol = c_q;
    while(runningRow < n && runningCol < n)
    {

        runningRow = runningRow + 1;
        runningCol = runningCol + 1;


        if(isObstacle(runningRow, runningCol, obstacles))
        {
            break;
        }
        moveCount = moveCount + 1;
    }   



    return moveCount;
}


static int verticalCount(int r_q,int c_q,int[][] obstacles, int n)
{
    int moveCount = 0;
    int runningRow = r_q;
    while(runningRow >1)
    {
        runningRow = runningRow - 1;

        if(isObstacle(runningRow, c_q, obstacles))
        {
            break;
        }
        moveCount = moveCount + 1;

    }
    runningRow = r_q;
    while(runningRow < n)
    {
        runningRow = runningRow + 1;

        if(isObstacle(runningRow, c_q, obstacles))
        {
            break;
        }

        moveCount = moveCount + 1;
    }

    return moveCount;
}


static int horizontalCount(int r_q,int c_q,List<List<Integer>> obstacles, int n)
{
    int moveCount = 0;
    int runningcolumn = c_q;
    while(runningcolumn > 1)
    {
        runningcolumn= runningcolumn - 1;
        if(isObstacle(r_q, runningcolumn, obstacles))
        {
            break;
        }

        moveCount = moveCount + 1;
    }

    runningcolumn = c_q;

    while(runningcolumn < n)
    {
        runningcolumn = runningcolumn+ 1;

        if(isObstacle(r_q, runningcolumn, obstacles))
        {
            break;
        }

        moveCount = moveCount + 1;
    }

    return moveCount;
}

static boolean isObstacle(int r, int c, int[][] obstacles)
{
    for(int i = 0; i< obstacles.length;i++)
    {
        if(r == obstacles[i][0] && c == obstacles[i][1])
            return true;
    }

    return false;
}


}

public class QueensAttack2 {
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

        int result = Result1.queensAttack(n, k, r_q, c_q, obstacles);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

        bufferedReader.close();
       // bufferedWriter.close();
    }

	
}
	

