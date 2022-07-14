package mockInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MathGame {

	public static void main(String[] args) {
		MathGame object = new MathGame();
		object.startGame();
	}

	private void startGame() {
		boolean isExit = true;
		while (isExit) {
			Scanner input = new Scanner(System.in);
			System.out.println("****************************************************");
			System.out.println("Welcome to Math game");
			System.out.println("****************************************************");
			System.out.println(
					"Instructions : You have given with set of numbers and operators.\nYou have to build expression to give the target value.\nYou are allowed to repeat operators,but don't repeat operants.\n \nAre you ready to start? Press(Y)\nDo you want sample input press(S) ");
			System.out.println("Press X to exit");
			System.out.println();
			char ch = input.next().charAt(0);
			if (ch == 'Y') {
				System.out.println("Game starts");
				System.out.println();
				System.out.println("Operants:");
				// ArrayList<Integer> operands=new ArrayList<>(Arrays.asList(4,1,5,3));
				System.out.println("Operants[4,1,5,3] \nOperators[(,+,-,*,/,)] \nTargetValue[1]");
				System.out.println();
				System.out.println("Built the math expression");
				String arithmeticExpression = input.next();
				String postFix1 = infixToPostfix(arithmeticExpression);
				int result = postFixToEvaluation(postFix1);
				if (result == 1) {
					System.out.println("Hurrahhhh....You have passed the level");
				} else {
					System.out.println("Try Again..");
				}

			} else if (ch == 'S') {
				System.out.println();
				System.out.println(
						"Input:Operants[8,9,3,1]  Operators[(,+,-,*,/,)] \nResult value:1 \nMath Expression:4+3-5-1");
				System.out.println();
				System.out.println("Are you ready to start? Press(Y)");
			} else {
				isExit = false;
			}
		}
	}

	static boolean letterOrDigit(char c) {
		if (Character.isLetterOrDigit(c))
			return true;
		else
			return false;
	}

	static int getPriority(char ch) {
		if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		if (ch == '^')
			return 3;
		else
			return -1;

	}

	static boolean leftAssociativity(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return true;
		else
			return false;

	}

	private int postFixToEvaluation(String postFix1) {
		Stack<Integer> stack = new Stack<Integer>();
		int x = 0, y = 0;
		char ch[] = postFix1.toCharArray();
		for (char c : ch) {
			if (c >= '0' && c <= '9') {
				stack.push((int) c - '0');
			} else {
				y = stack.pop();
				x = stack.pop();
				switch (c) {
				case '+':
					stack.push(x + y);
					break;
				case '-':
					int r = (x > y) ? (x - y) : (y - x);
					stack.push(r);
					break;
				case '*':
					stack.push(x * y);
					break;
				case '/':
					stack.push(x / y);
					break;
				case '^':
					stack.push(x ^ y);
					break;
				default:
					System.out.println("Invalid operator found ");

				}
			}

		}
		return stack.pop();
	}

	private String infixToPostfix(String arithmeticExpression) {
		Stack<Character> operatorStack = new Stack<>();
		String postFix = new String("");
		for (int i = 0; i < arithmeticExpression.length(); ++i) {
			char c = arithmeticExpression.charAt(i);
			if (letterOrDigit(c))
				postFix += c;
			else if (c == '(')
				operatorStack.push(c);
			else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
					postFix += operatorStack.pop();
				operatorStack.pop();
			} else {
				while (!operatorStack.isEmpty() && getPriority(c) <= getPriority(operatorStack.peek())
						&& leftAssociativity(c)) {
					postFix += operatorStack.pop();
				}
				operatorStack.push(c);
			}
		}
		while (!operatorStack.isEmpty()) {
			if (operatorStack.peek() == ')')
				return "Invalid Arithmetic Expression ";
			postFix += operatorStack.pop();

		}
		return postFix;
	}

}
