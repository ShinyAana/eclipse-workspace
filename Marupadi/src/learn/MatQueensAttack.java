package learn;

public class MatQueensAttack {
    int moveCount = 0;

    moveCount = moveCount + diagonalCount(r_q, c_q, obstacles, n);
    moveCount = moveCount + verticalCount(r_q, c_q, obstacles, n);
    moveCount = moveCount + horizontalCount(r_q, c_q, obstacles, n);

    return moveCount;

}

static int diagonalCount(int r_q,int c_q,int[][] obstacles, int n)
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


static int horizontalCount(int r_q,int c_q,int[][] obstacles, int n)
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
