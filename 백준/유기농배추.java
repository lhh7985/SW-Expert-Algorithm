package HW;

import java.util.Scanner;

public class 유기농배추 {
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,M;
	static boolean arr[][];
	static int cnt;

	private static void recur(int r, int c) {
		//4방 탐색
		arr[r][c] = false;
		for(int i=0; i<4; i++) {
			int nR = r+dr[i];
			int nC = c+dc[i];
			if(nR<N && nR>=0 && nC>=0 && nC<M && arr[nR][nC]) {
				recur(nR,nC);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //배추 세로길이
			M = sc.nextInt(); //배추 가로길이
			
			arr = new boolean[N][M];
			int K = sc.nextInt(); //배추 위치 개수
			for(int i=0; i<K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				arr[X][Y] = true;
			}
			
			
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]) {
						recur(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

}
