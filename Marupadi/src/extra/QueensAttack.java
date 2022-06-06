package extra;

import java.util.ArrayList;
import java.util.Arrays;

public class QueensAttack {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> obstacles=new ArrayList<>();
		
		obstacles.add(new ArrayList<Integer>(Arrays.asList(5,5)));

		obstacles.add(new ArrayList<Integer>(Arrays.asList(4,2)));

		obstacles.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		int n=5,count=0;
		int r_q=4;
		int c_q=3;
		int[][] arr=new int[n][n];
		int r=r_q-1;
		int c=c_q-1;
		for(ArrayList<Integer> i:obstacles)
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







System.out.println(count);
		
	}

}
