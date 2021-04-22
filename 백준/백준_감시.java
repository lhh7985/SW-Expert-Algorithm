import java.util.Scanner;

public class 백준_감시 {

	static int N, M;
	static int[][] map;
	static int cc;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] >0 && map[i][j] <6)
					cc++;
			}
		}

		dfs(0);

		System.out.println(ans);

	}

	static boolean visited[][];
	static int ans=987654321;

	public static void dfs(int idx) {
		// 카메라 찾기
		if(idx==cc) {
			int cnt = 0;
			for (int l = 0; l < N; l++) {
				for (int o = 0; o < M; o++) {
					if (map[l][o] == 0) {
						cnt++;
					}

				}
			}
			ans = Math.min(cnt, ans);
			return;
		}

		// 카메라 숫자에 맞는 값을 #으로 바꾸기?
		int nr = 0, nc = 0;
		boolean ch = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && map[i][j] < 6 && !visited[i][j]) {
					nr = i;
					nc = j;
					ch = true;
				}
			}
		}
		if(!ch) {
			int cnt = 0;
			for (int l = 0; l < N; l++) {
				for (int o = 0; o < M; o++) {
					if (map[l][o] == 0) {
						cnt++;
					}

				}
			}
			ans = Math.min(cnt, ans);
			System.out.println(ans);
			System.exit(0);
		}
		
		for (int k = 0; k < cameraCnt[map[nr][nc]]; k++) {
			visited[nr][nc] = true;
			check(nr, nc, k, -1,map[nr][nc]);
			dfs(idx +1);
			

			visited[nr][nc] = false;
			check(nr, nc, k, 1,map[nr][nc]);
		}
		
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int[] cameraCnt= {0,4,2,4,4,1};

	public static void check(int r, int c, int d, int s,int camera) {
		int nr = 0, nc = 0;
		int idx = 1;

		if(camera==1) {
			func(r,c,d,s);		
		}
		if(camera==2) {
			int d1 = 0,d2=0;
			if(d==0)d1 = 1;
			else if(d==1) {
				d1 = 2;
				d2 = 3;
			}
			func(r,c,d2,s);
			//d==0 이면 1로, 1이면 0으로 //2면 3으로 3이면 2로
			func(r,c,d1,s);
		}
		
		if(camera==3) {
			func(r,c,d,s);
			//d==0 2, d==1 3, d==2 0, d==3 1
			int di = 0;
			if(d==0)di = 2;
			else if(d==1) di = 3;
			else if(d==2) di = 1;
			else if(d==3) di = 0;
			func(r,c,di,s);
		}
		
		if(camera==4) {
			func(r,c,d,s);
			func(r,c,(d+1)%4,s);
			func(r,c,(d+2)%4,s);
		}
		
		if(camera==5) {
			func(r,c,d,s);
			func(r,c,(d+1)%4,s);
			func(r,c,(d+2)%4,s);
			func(r,c,(d+3)%4,s);
		}
		

	}
	
	public static void func(int r, int c,int d,int s) {
		int nr = 0,nc=0;
		int idx = 1;
		
		while (true) {
			nr = r + dr[d] * idx;
			nc = c + dc[d] * idx;
			if (nr >= N || nr < 0 || nc >= M || nc < 0) break;
			if (map[nr][nc] == 6) break;
			if(map[nr][nc]<=0)
				map[nr][nc] += s;
			idx++;
		}		
	}
}
