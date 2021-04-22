import java.util.Scanner;


public class SWEA_벌꿀채취 {

	static int N,M,C;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N =sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//M번 만큼 반복하는데+1씩
			//위 값이 C를 넘어가면?
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//방문 취소
					visited = new boolean[N][N];
					
					int m1 = 0;
					if(!visited[i][j] && (j+M)<=N) {
						for(int s=0; s<M; s++) {
							visited[i][j+s] = true;
						}
						m1 = sel(i,j);
					}
					else continue;
					//첫번째 사람고르기
					//반복문으로 방문 안된  것 && 현재 c값+M<N
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if(check(k,l) && (l+M)<=N) {
								int m2 = sel(k,l);
								ans = Math.max(ans, m1+m2);
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	public static boolean check(int r, int c) {
		for(int i=0; i<M; i++) {
			if(c+i<N && visited[r][c+i]) return false;
		}
		return true;
	}
	
	static int[] man1;
	private static int sel(int r, int c) {
		man1 = new int[M];
		for(int i=0; i<M; i++) {
//			visited[r][c+i]= true;
			man1[i]=map[r][c+i];
		}
		
		//부분집합으로 구한 값 중 최대값 찾기
		m=0;
		v = new boolean[M];
		ee(man1,0);
		return m;
	}
	
	//부분집합
	static boolean[] v;
	static int m;
	public static void ee(int[] man,int idx) {
		if(idx == M) {
			int s = 0;
			for(int i=0; i<M; i++) {
				if(v[i]) {
					s += man[i];
				}
			}
			int mm=0;
			if(s<=C) {
				for(int j=0; j<M; j++) {
					if(v[j]) {
						mm+=man[j]*man[j];
					}
				}
			}
			m = Math.max(mm, m);
			return;
		}
		v[idx] = true;
		ee(man, idx+1);
		v[idx] = false;
		ee(man, idx+1);
	}

}
