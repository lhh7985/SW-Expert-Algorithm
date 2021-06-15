import java.util.Scanner;

public class 백준_A와B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		
		StringBuilder sb = null;
		while(true) {
			if(S.equals(T)) {
				System.out.println(1);
				break;
			}
			if(S.length()>T.length()) {
				System.out.println(0);
				break;
			}
			
			String last = T.substring(T.length()-1, T.length());
			T = T.substring(0,T.length()-1);
			if(last.equals("B")) {
				sb = new StringBuilder(T);
				T = sb.reverse().toString();
			}
		}

	}

}
