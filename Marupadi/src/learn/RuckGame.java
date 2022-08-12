package learn;
import java.util.Scanner;

public class RuckGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of chess board");
		int n=sc.nextInt();
		char a[][] = new char[n][n];
		System.out.println("Enter the no of inputs");
		int no=sc.nextInt();		/*
		 * a[0][2] = 'R'; a[3][5] = 'R'; a[5][3] = 'R'; a[6][6] = 'R';
		 */
		
		for(int i=0;i<no;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			a[x][y]='R';
		}

		System.out.println();
		System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'R') {
					printpossiblities(a, i, j,n);
				}
			}
		}
		printBoard(a,n);

		printMax(a,n);

		printfinal(a,n);
		

	}

	private static void printMax(char[][] a,int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i][0] == '_') {
				count++;
			}
		}
		System.out.println("Maximum total no of rooks that can be placed in the board : " + count);
	}

	private static void printfinal(char[][] a,int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] != '0') {
					System.out.println("(" + i + "," + j + ")");
					printpossiblities(a,i,j,n);
				}
			}
		}

	}

	private static void printBoard(char[][] a,int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == '0') {
					System.out.print(a[i][j] + " ");
				} else {
					a[i][j] = '_';
					System.out.print(a[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	private static void printpossiblities(char[][] a, int start, int end,int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			a[start][i] = '0';
			a[i][end] = '0';
		}

	}

}
