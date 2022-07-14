package interviewQA;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesesMatch {

	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the string");
	String exp=input.next();
	boolean valid=isValid(exp);
	if(valid)
		System.out.println("balanced");
	else
		System.out.println("unbalanced");
	
	

}

	private static boolean isValid(String exp)
	{
		Stack<Character> stack=new Stack<>();
		char ch;
		for(int i=0;i<exp.length();i++)
		{
		if(exp.charAt(i)=='(' || exp.charAt(i)=='{' ||exp.charAt(i)=='[')
		{
		stack.push(exp.charAt(i));
		continue;
		}
		if(stack.isEmpty())
			return false;
		switch(exp.charAt(i))
		{
		case ')':
			ch=stack.peek();
			stack.pop();
			if(ch=='}' || ch==']')
				return false;
			break;
		case '}':
			ch=stack.peek();
			stack.pop();
			if(ch==')' || ch==']')
				return false;
			break;
		case ']':
			ch=stack.peek();
			stack.pop();
			if(ch=='}' || ch==')')
				return false;
			break;
			
		}
		}
		
		
		return (stack.isEmpty());
	}
	}
