import java.util.Scanner;

public class SWEA_보호필름 {
	
	static int D,W,K;
	static int[][] map, copyMap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc= 1; tc<=T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[D][W];
			copyMap = new int[D][W];
			visited = new boolean[D];
			
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					copyMap[i][j] = map[i][j]= sc.nextInt();
				}
			}
			
			ans= 987654321;
			recur(0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	

	//2^N 번 반복해야함;;
	static boolean[] visited;
	static int ans=987654321;
	public static void recur(int idx,int cnt) {

		if(idx==D) {
			if(inspect()) {
				//통과했으면 개수 찾기
				ans = Math.min(ans,cnt);
			}
			return;
		}
		
		//아무것도 안함
		recur(idx+1,cnt);
		
		//A로 바꿈 0으로 바꿈
		change(idx,0);
		recur(idx+1, cnt+1);
		
		//B로 바꿈 1로 바꿈
		change(idx,1);
		recur(idx+1, cnt+1);
		
		rollback(idx);
	}
	
	
	
	//현재 행을 약품을 투여하기
	public static void change(int r,int num) {
		for(int i=0; i<W; i++) {
			copyMap[r][i] = num;
		}
	}
	public static void rollback(int r) {
		for(int i=0; i<W; i++) {
			copyMap[r][i] = map[r][i];
		}
	}
	
	
	//연속되는지 검사하는 함수
	private static boolean inspect() {
		//모든 열을 돌돌면서 검사
		out:for (int i = 0; i < W; i++) {
			int start = copyMap[0][i];
			int cnt = 1;
			for (int j = 1; j < D; j++) {
				//K가 될때까지
				//시작점을 주고 일치하면 continue;
				if(start == copyMap[j][i]) {
					cnt++;
				}
				//다르면 시작점을 초기화
				else {
					cnt = 1;
					start = copyMap[j][i];
				}
				if(cnt==K) continue out;
			}
			
			//통과 못하면
			return false;
		}
		return true;
	}
}

