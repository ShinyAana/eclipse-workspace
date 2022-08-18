package learn;

import java.util.Scanner;

public class MatrixDB {

	public static void main(String[] args) 
	{
	int[][] mat= {{1,22,33,44},
			{2,45,67,89},
			{3,21,54,78},
			{4,67,98,11}};
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the first condition");
	char ch=input.next().charAt(0);
	switch(ch)
	{
	case '*':
		findPosibilities(mat);
		break;
	case 'A':
		findPosibility(mat,1);
		break;
	case 'B':
		findPosibility(mat,2);
		break;
	case 'C':
		findPosibility(mat,3);
		break;
	default:
		System.out.println("Enter valid choice");
		
	}
	}

	private static void findPosibility(int[][] mat, int col1)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the second condition");
		String cond=input.next();
		char symbol=cond.charAt(1);
		String num=cond.substring(2);
		int num1=Integer.parseInt(num);

		if(symbol=='>')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col1]>num1)
					System.out.print(mat[i][col1] + " ");
			}
		}
		else if(symbol=='<')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col1]<num1)
					System.out.print(mat[i][col1] + " ");
			}
		}
		else if(symbol=='=')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col1]==num1)
					System.out.print(mat[i][col1] + " ");
			}
		}
		
	}

	private static void findPosibilities(int[][] mat)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the second condition");
		String cond=input.next();
		
		if(cond.charAt(0)=='A')
		{
			printPosibilities(mat,1,cond);
		}
		else if(cond.charAt(0)=='B')
		{
			printPosibilities(mat,2,cond);
			
		}
		else 
		{
			printPosibilities(mat,3,cond);
			
		}
		
	}

	private static void printPosibilities(int[][] mat, int col, String cond)
	{
		char symbol=cond.charAt(1);
String num=cond.substring(2);
int num1=Integer.parseInt(num);
		
		//String num=cond.charAt(2)+cond.charAt(3);
		if(symbol=='>')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col]>num1)
					printrow(mat,i);
				System.out.println();
			}
		}
		else if(symbol=='<')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col]<num1)
					printrow(mat,i);
				System.out.println();
			}
		}
		else if(symbol=='=')
		{
			for(int i=0;i<4;i++)
			{
				if(mat[i][col]==num1)
					printrow(mat,i);
				System.out.println();
			}
		}
	}

	private static void printrow(int[][] mat, int row)
	{
	for(int j=0;j<4;j++)
	{
		System.out.print(mat[row][j] + " ");
	}
	
	}

}
