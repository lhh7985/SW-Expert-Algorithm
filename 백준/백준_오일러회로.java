import java.util.Arrays;
import java.util.Scanner;

public class 백준_오일러회로 {
	
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N+1];
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > 0) cnt += map[i][j];
			}
			map[i][N] = cnt;
		}
		
		for(int i=0; i<N; i++) {
			if(map[i][N]%2 != 0) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		dfs(0);
		System.out.println(sb);	
		
	}
	
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int start) {
		for(int i=0; i<N; i++) {
			while(map[start][i] > 0) {
				map[start][i]--;
				map[i][start]--;
				dfs(i);
			}
		}
		sb.append(start+1).append(" ");
	}
}
