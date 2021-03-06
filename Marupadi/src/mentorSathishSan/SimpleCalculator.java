package mentorSathishSan;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Character;
public class SimpleCalculator 
{
	 static boolean letterOrDigit(char c)
	    {
	        if (Character.isLetterOrDigit(c))
	            return true;
	        else
	            return false;
	    }
	 static int getPriority(char ch)
	 {
		 if(ch=='+'||ch=='-')
		 return 1;
		 else if(ch=='*'||ch=='/')
			 return 2;
		 if(ch=='^')
			 return 3;
		 else
			 return -1;
		 
	 }
	 static boolean leftAssociativity(char ch)
	 {
		 if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
			 return true;
		 else			 
		return false;
		 
	 }
	 static String infixToPostfix(String arithmeticExpression)
	 {
		 Stack<Character> operatorStack=new Stack<>();
		 String postFix=new String("");
		 for(int i=0;i<arithmeticExpression.length();++i)
		 {
			 char c=arithmeticExpression.charAt(i);
			 if(letterOrDigit(c))
			 postFix+=c;
			 else if(c=='(')
				 operatorStack.push(c);
			 else if(c==')')
			 {
				 while(!operatorStack.isEmpty() && operatorStack.peek()!='(')
					 postFix+=operatorStack.pop();
				 operatorStack.pop();
			 }
			 else
			 {
				 while(!operatorStack.isEmpty() && getPriority(c)<=getPriority(operatorStack.peek()) && leftAssociativity(c))
				 {
					 postFix+=operatorStack.pop();
				 }
				 operatorStack.push(c);
			 }
		 }
	 while(!operatorStack.isEmpty())
	 {
		 if(operatorStack.peek()==')')
			 return "Invalid Arithmetic Expression ";
		 postFix+=operatorStack.pop();
			 
	 }
	 return postFix;
	 }
	 public static void main(String[] args)
	 {
		 //String arithmeticExpression="5+2*3";
		 Scanner input=new Scanner(System.in);
		 System.out.println("Enter the arithmetic expression to evaluate ");
		 String arithmeticExpression=input.next();
		 System.out.println("The postfix expression if the given infix is ");
		 String postFix1=infixToPostfix(arithmeticExpression);
		 System.out.println(postFix1);
		 
		 int result=postFixToEvaluation(postFix1);
		 System.out.println("The result " + result);
		 
	 }
	private static int postFixToEvaluation(String postFix1) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>();
		int x=0,y=0;
		char ch[]=postFix1.toCharArray();
		for(char c:ch)
		{
			if(c>='0' && c<='9')
			{
				stack.push((int)c-'0');
			}
			else 
			{
				y=stack.pop();
				x=stack.pop();
				switch(c)
				{
				case '+':
					stack.push(x+y);
					break;
				case '-':
					int r=(x>y)?(x-y):(y-x);
					stack.push(r);
					break;
				case '*':
					stack.push(x*y);
					break;
				case '/':
					stack.push(x/y);
					break;
				case '^':
					stack.push(x^y);
					break;
				default:
					System.out.println("Invalid operator found ");
					
				}
			}
			
		}
		return stack.pop();
	}
}
