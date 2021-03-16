package HW;

import java.util.Scanner;

public class 백준_유성 {

	static int N, M;
	static char arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int min = 987564;
		// 위에서 부터 X를 발견하고 다음값이 .이면 #을 만날때까지 cnt 해서 가장작은 값 min에 저장
		for (int j = 0; j < M; j++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (i+1<N && arr[i][j] == 'X' && arr[i + 1][j] == '.') {
					for(int k=i+1; k<N-1; k++) {
						if(arr[k][j]=='#') break;
						if(arr[k][j]=='X') {
							cnt = 0;
							break;
						}
						if(arr[k][j] =='.') cnt++;
					}
				}
				if(cnt>0 && arr[i][j] == '#') {
					min = Math.min(cnt, min);
					cnt=0;
				}
			}
		}

//		for (int i = 0; i < M; i++) {
//			int ufo = 0, ground = N - 1;
//			for (int j = 0; j < N; j++) {
//				if (arr[j][i] == 'X') {
//					ufo = j;
//				}
//			}
//			for (int j = N - 1; j >= 0; j--) {
//				if (arr[j][i] == '#') {
//					ground = j;
//				}
//			}
//			min = Math.min(min, ground - ufo);
//		}
//		min -= 1;
////		for(int i=0; i<min; i++) {			
		move(min);
////		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

		// min만큼 내려와

	}

	public static void move(int min) {
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][j] == 'X' && arr[i + min][j] == '.') {
					char temp = arr[i][j];
					arr[i][j] = arr[i + min][j];
					arr[i + min][j] = temp;
				}
			}
		}
	}

}
