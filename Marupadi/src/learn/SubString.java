package learn;
import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter String Array size");
		int StringSize=input.nextInt();
		String[] array=new String[StringSize];
		System.out.println("Enter the Strings ");
		for(int i=0;i<StringSize;i++) {
			array[i]=input.next();
		}
		getCommonSubstring(array);

	}

	public static void getCommonSubstring(String[] array) {

		if (array.length < 1) {
			System.out.println("The String is empty");
		}	
		int n = array.length;
		String result = "";
		String samp = array[0];
		int len = samp.length();
		for (int i = 0; i < len - 1; i++) {

			for (int j = i + 1; j <= len; j++) {

				String sub = samp.substring(i, j);
				int k = 1;
				for (; k < n; k++) {
					if (!array[k].contains(sub))
						break;
				}
				if (k == n && sub.length() > result.length()) {
					result = sub;
				}

			}

		}
		if(result.length() >= 3) {
			System.out.println(result);
		}
		else {
			System.out.println("()");
		}

	}

}
