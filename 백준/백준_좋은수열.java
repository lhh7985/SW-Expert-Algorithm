import java.util.Scanner;

public class 백준_좋은수열 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//첫 자리 수 무조건 1
		dfs(1,"1");
//		check("1213121",7);
		

	}
	private static void dfs(int l, String str) {
		
		if(l == N) {
			System.out.println(str);
			System.exit(0);
		}
		for(int i=1; i<=3; i++) {
			//만약 해당 숫자가 중복이 없으면 붙여서 재귀
			if(check(str+i,l+1)) {
				dfs(l+1, str+i);
			}
		}
	}
	
	private static boolean check(String str,int len) {
		for(int i=1; i<=len/2; i++) {
			//0부터 i까지 subString과 i~ 2i+1 까지 
//			System.out.println(str.substring(len-2*i, len-i)+" "+str.substring(len-i,len));
			if(str.substring(len-2*i, len-i).equals(str.substring(len-i,len))) {
				return false;
			}
		}
		return true;
		
	}

}
