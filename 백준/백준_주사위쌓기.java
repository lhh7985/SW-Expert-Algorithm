package HW;

import java.util.Scanner;

public class 백준_주사위쌓기 {

	static int N;
	static int[][] arr;
	static int[] res;
	static int result;
	
	//매개변수 : 열, 아랫면
	//아랫면과 맞는 윗면을 구하기(함수작성)
	//윗면과 아랫면 제외한 가장 큰수 뽑기
	//다음 열에서 아랫면이될(현재의 윗면)을 재귀
	//idx가 6개 가 되면 그만 가장큰수 결과 값에 넣기
	
	public static void recur(int idx, int g) {
		
		if(idx==N) {
			int dd = 0;
			for(int i=0; i<N; i++) {
				dd += res[i];
			}
			result = Math.max(dd, result);
			return;
		}
		
		int upper = 0;
		upper = upSide(idx, g);
		for(int i=0; i<6; i++) {
			//아랫면이거나 윗면이면 continue;
			if(i==upper || arr[idx][i] == g) continue;
			//윗면과 아랫면 제외 가장큰수를 넣기
			res[idx] = Math.max(res[idx], arr[idx][i]);
		}
		recur(idx+1, arr[idx][upper]);
	}
	
	public static int upSide(int idx, int g) {
		int curIdx = 0;
		out:for(int i=0; i<6; i++) {
			if(arr[idx][i] == g) {
				switch(i) {
				case 0:
					curIdx = 5;
					break out;
				case 1:
					curIdx = 3;
					break out;
				case 2:
					curIdx = 4;
					break out;
				case 3:
					curIdx = 1;
					break out;
				case 4:
					curIdx = 2;
					break out;
				case 5:
					curIdx = 0;
					break out;
				}
			}
		}
		return curIdx;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new int[N];
		arr = new int[N][6];
		for(int i=0; i<N; i++) {
			for(int j=0; j<6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<N; j++) {
				res[j] = 0;
			}
			recur(0,arr[0][i]);
		}
		System.out.println(result);
	}

}
