package rebeccaSan;

public class ExceptionBreakPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a=100;
      int b=10;
      int res=divide(a,b);
      System.out.println(res);
	}

	private static int divide(int a, int b) {
		// TODO Auto-generated method stub
		int r=a/b;
		return r;
	}

}
