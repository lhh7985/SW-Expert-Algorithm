package HW;

import java.util.Scanner;

public class 백준_내리막길 {
	
	static int N, M;
	static int[][] map,D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		D = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
				D[i][j] = -1;
			}
		}
		D[N-1][M-1] = 1;
		
		int ans = dfs(0,0,map[0][0]);
		
		System.out.println(ans);
		
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static int dfs(int r, int c,int now) {
		
		if(r==N-1&&c==M-1) return 1;
		
		if(D[r][c] != -1) return D[r][c];
		
		D[r][c] = 0;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=N||nr<0 || nc>=M||nc<0) continue;
			if(map[nr][nc] < now)
				D[r][c] += dfs(nr,nc,map[nr][nc]);				
			
		}
		return D[r][c];
	}
}








