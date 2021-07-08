import java.util.Scanner;

public class 백준_빙산 {
	static int N,M;
	static int[][] map,minus;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		minus = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] =sc.nextInt();
			}
		}
		//덩어리 확인
		//만약 덩어리가 2 이상이면 그만 하고 반복횟수 출력
		//아니면 getMinus -> mpaMinus;
	
		int idx = 0;
		while(true) {
			if(checkDung()>1) {
				System.out.println(idx);
				System.exit(0);
			}else if(checkDung()==-1){
				System.out.println(0);
				System.exit(0);
			}
			getMinus();
			mapMinus();
			idx++;
		}
//		System.out.println(0);
		
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean check[][];
	//덩어리 체크 하는 메소드
	public static int checkDung() {
		check = new boolean[N][M];
		int cnt = 0;
		boolean in = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] !=0 && !check[i][j]) {
					in = true;
					dung(i, j, check);
					cnt++;
				}
			}
		}
		if(in)
			return cnt;
		else return -1;
	}
	
	public static void dung(int r, int c, boolean[][] ch) {
		
		ch[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0||nr>=N || nc<0||nc>=M || map[nr][nc]==0) continue;
			if(ch[nr][nc]) continue;
			
			dung(nr,nc,ch);
			
		}
	}
	
	//minus계산하여 저장
	public static void getMinus() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {				
				for(int i=0; i<4; i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					if(nr>=N||nr<0 || nc>=M||nc<0) continue;
					if(map[nr][nc]==0) {
						minus[r][c]++;
					}
				}
			}
		}
	}
	
	//map-minus 메소드
	public static void mapMinus() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = map[i][j]-minus[i][j]>0?map[i][j]-minus[i][j]:0;
				minus[i][j] = 0;
			}
		}
	}
}

/*
5 7
0 0 0 0 0 0 0
0 2 4 5 0 0 0
0 3 0 0 5 2 0
0 7 6 0 4 0 0
0 0 0 0 0 0 0
*/
