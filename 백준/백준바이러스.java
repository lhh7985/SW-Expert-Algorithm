package HW;

import java.util.Scanner;

public class 백준바이러스 {
	static boolean arr[][];
	static boolean check[];
	static int N;
	static int cnt;
	private static void recur(int idx) {
		for(int i=0; i<N; i++) {
			if(arr[idx][i] && !check[i]) {
				check[i] = true;
				cnt++;
				recur(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		arr = new boolean[N][N];
		check = new boolean[N];
		
		for(int i=0; i<K; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[r][c] = true;
			arr[c][r] = true;
		}
		recur(0);
		System.out.println(cnt-1);
		
		
	}
}
