package interviewQA;

public class SubString {
	public static void main(String[] args) {
		String s1 = "dishwasher", s2 = "dish";
		System.out.println(solve(s1, s2));
	}

	private static boolean solve(String s1, String s2) {
		int cur = 0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i) == s2.charAt(cur)) {
				cur++;
				if(cur == s2.length()) {
					return true;
				}
			}else {
				cur = 0;
			}
		}
		return false;
	}

}
