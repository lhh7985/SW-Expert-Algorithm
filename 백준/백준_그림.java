import java.util.Scanner;

public class 백준_그림 {

	static int N,M;
	static int[][] arr;
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

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					res= 0;
					dfs(i,j);
					cnt++;
					result = Math.max(result, res);
				}
			}
		}
		System.out.println(cnt+"\n"+result);

	}
	
	static int result = 0;
	static int cnt, res;
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	public static void dfs(int r, int c) {
		
		arr[r][c] =0;
		res++;
		int nr = 0, nc = 0;
		for(int i=0; i<4; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr<N && nc<M && nr>=0 && nc>=0 && arr[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}

}
