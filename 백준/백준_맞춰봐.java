import java.util.Scanner;

public class 백준_맞춰봐 {
	
	static char[][] map;
	static int[] ans;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		ans = new int[N];
		String str = sc.next();
		for(int i=0,idx=0; i<N; i++) {
			for (int j = i; j < N; j++,idx++) {
				map[i][j] = str.charAt(idx);
			}
		}
		
//		for(char[] a: map)
//			System.out.println(Arrays.toString(a));
		dfs(0);
		
		
	}
	
	private static void dfs(int idx) {
		
		if(idx == N) {
//			System.out.println(Arrays.toString(ans));
			for(int i=0; i<N; i++)
				System.out.print(ans[i]+" ");
			System.exit(0);
		}
		
		for(int i=-10; i<=10; i++) {
			ans[idx] = i;
			if(check(idx))
				dfs(idx+1);
		}
	}
	
	private static boolean check(int cnt) {
		for(int i=0; i<=cnt; i++) {
			int sum = 0;
			for(int j=i; j<=cnt; j++) {
				sum += ans[j];
				if(map[i][j] != (sum==0?'0':(sum<0?'-':'+')))
					return false;
			}
		}
		return true;
	}
}
