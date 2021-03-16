import java.util.Scanner;

public class 백준_현수막 {

	
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	
	static int dr[] = {-1,1,0,0,-1,-1,1,1};
	static int dc[] = {0,0,-1,1,-1,1,1,-1};
	
	public static void dfs(int r, int c) {
		
		int nr =0, nc= 0;
		arr[r][c] = 0;
		for(int i=0; i<8; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc] == 1) {
				arr[nr][nc] = 0;
				dfs(nr,nc);
			}
		}
	}

}
