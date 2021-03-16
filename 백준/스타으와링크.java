package 설숙제;

import java.util.Scanner;

public class 스타으와링크 {

	static int N;
	static int[][] arr;
	static boolean check[];
	static int result = 789654321;

	public static void recur(int idx,int start) {
		if (idx == N / 2) {
			int sum = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j && check[i] && check[j]) {
						sum += arr[i][j];
					} else if (i != j && !check[i] && !check[j]) {
						sum2 += arr[i][j];
					}
				}
			}
			result = Math.min(Math.abs(sum2 - sum), result);
			return;
		}
		for (int i = start; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				recur(idx + 1,i);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		recur(0,0);
		System.out.println(result);

	}

}
