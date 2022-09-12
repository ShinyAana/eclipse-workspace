import java.util.Scanner;

public class MatrixMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of row for 1st Matrix: ");
		int r1 = sc.nextInt();
		System.out.println("Enter the number of columns in 1st Matrix: ");
		int c1 = sc.nextInt();
		System.out.println("Enter the number of row for 2nd Matrix: ");
		int r2 = sc.nextInt();
		System.out.println("Enter the number of columns in 2nd Matrix: ");
		int c2 = sc.nextInt();
		
		int firstMatrix[][] = new int[r1][c1];
		int secondMatrix[][] = new int[r2][c2];
		
		int[][] productArr = new int[r1][c2];
		
		System.out.println("Enter the elements of 1st Matrix: ");
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				firstMatrix[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter the elements of 2nd Matrix: ");
		for(int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				secondMatrix[i][j] = sc.nextInt();
			}
		}
		if(c1==r2)
		{
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c2;j++)
				{
					for(int k=0;k<c1;k++)
					{
						productArr[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
					}
				}
			}//c1==r2...r1c2c1 
			System.out.println("Multiplication of 2 array is: ");
			for(int[] row : productArr)
			{
				for(int column:row)
				{
					System.out.print(column+"\t");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("Please enter 1st matrix column and 2nd matrix row as same size: ");
		}
		
		}

}

	
