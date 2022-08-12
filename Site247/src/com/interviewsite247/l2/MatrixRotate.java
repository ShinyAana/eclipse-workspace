package com.interviewsite247.l2;

public class MatrixRotate {
	static int Rows = 4;
	   static int Columns = 4;
	   public static void main(String[] args) {
	      int input_matrix[][] = {
	         {11,12,13,14},
	         {15, 16, 17, 18},
	         {19, 20, 21, 22},
	         {23, 24, 25, 26}
	      };
	      System.out.println("The input_matrix is defined as ");
	      for (int i = 0; i < Rows; i++) {
	         for (int j = 0; j < Columns; j++)
	         System.out.print( input_matrix[i][j] + " ");
	         System.out.print("\n");
	      }
	      int m = Rows, n = Columns;
	      int row = 0, column = 0;
	      int previous, current;
	      while (row < m && column < n) {
	         if (row + 1 == m || column + 1 == n)
	            break;
	         previous = input_matrix[row + 1][column];
	         for (int i = column; i < n; i++) {
	            current = input_matrix[row][i];
	            input_matrix[row][i] = previous;
	            previous = current;
	         }
	         row++;
	         for (int i = row; i < m; i++) {
	            current = input_matrix[i][n-1];
	            input_matrix[i][n-1] = previous;
	            previous = current;
	         }
	         n--;
	         if (row < m) {
	            for (int i = n-1; i >= column; i--) {
	               current = input_matrix[m-1][i];
	               input_matrix[m-1][i] = previous;
	               previous = current;
	            }
	         }
	         m--;
	         if (column < n) {
	            for (int i = m-1; i >= row; i--) {
	               current = input_matrix[i][column];
	               input_matrix[i][column] = previous;
	               previous = current;
	            }
	         }
	         column++;
	      }
	      System.out.println("\nThe input_matrix after one rotation: ");
	      for (int i = 0; i < Rows; i++) {
	         for (int j = 0; j < Columns; j++)
	         System.out.print( input_matrix[i][j] + " ");
	         System.out.print("\n");
	      }
	   }
}
