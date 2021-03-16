package HW;

import java.util.Scanner;

public class 파이프옮기기_성공 {
	static int N;
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0,1,1);
		System.out.println(cnt);
		
		
	}
	
	
	static int cnt;
	public static void dfs(int r, int c, int status) {
		if(r == N-1 && c==N-1) {
			cnt++;
		}
		
		//가로
		if(status != 2 && c+1<N && arr[r][c+1] !=1 ) {
			dfs(r,c+1,1);
		}
		//세로
		if(status != 1 && r+1<N && arr[r+1][c] !=1 ) {
			dfs(r+1,c,2);
		}
		
		//대각선
		if(r+1<N && c+1<N && arr[r+1][c+1] + arr[r+1][c] + arr[r][c+1] == 0 ) {
			dfs(r+1,c+1,3);
		}
		
	}
	
}
