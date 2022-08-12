package learn;
import java.util.Scanner;
public class Game {
	
	static char board[][]=new char[3][3];
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++) {
				board[i][j]=' ';
				
			}
		}
		printBoard();
		
		
		int count=1;
		do {
			if(count%2==1) {
				System.out.println("Enter the turn for A");
				int x=input.nextInt();
				int y=input.nextInt();
				if(x<3 && y<3 && board[x][y]==' ') {
					board[x][y]='X';
					count++;
					printBoard();
					
				}
				else {
					System.out.println("Enter the valid inpiut for A");
				}
			}
			else {
				System.out.println("Enter the turn for B");
				int x=input.nextInt();
				int y=input.nextInt();
				if(x<3 && y<3 && board[x][y]==' ') {
					board[x][y]='O';
					count++;
					printBoard();
				}
				else {
					System.out.println("Enter the valid input for B");
				}
			}
			String winner=getWinner();
			if(winner.length() == 1){
				System.out.println("GAME OVER!! Winner is "+winner);
				break;
			}
			
			
		}while(count<=9);
		if(count>9) {
			System.out.println("Match Drawn");
		}
		input.close();
		
	  }
	private static String getWinner() {
		for(int i=0;i<3;i++) {
			int a=0,b=0;
			for(int j=0;j<3;j++) {
				if(board[i][j]=='X') 
					a++;
				if(board[i][j]=='O')
					b++;
			}
			if(a==3)
				return "A";
			if(b==3)
				return "B";
		}
		for(int j=0;j<3;j++) {
			int a=0,b=0;
			for(int i=0;i<3;i++) {
				if(board[i][j]=='X') 
					a++;
				if(board[i][j]=='O')
					b++;
			}
			if(a==3)
				return "A";
			if(b==3)
				return "B";
		}
		if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
			return "A";
		if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
		return "B";
		
		if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X')
			return "A";
		if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
		return "B";
		return "Drawn";
	}
	static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0][0] + " | "  + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[1][0] + " | "  + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]  + " |");
        System.out.println("|---|---|---|");
    }

}

