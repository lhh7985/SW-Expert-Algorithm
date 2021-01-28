package com.ssafy.D3;

import java.util.Scanner;

public class 경주난이도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int max = 0;
			int min = 1001;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (i != 0 && arr[i] - arr[i - 1] > 0)
					max = Math.max(max, arr[i] - arr[i - 1]);
				else if (i != 0 && arr[i] - arr[i - 1] < 0)
					min = Math.min(min, arr[i] - arr[i - 1]);
			}
			if (min == 1001)
				min = 0;
			System.out.println("#" + tc + " " + max + " " + Math.abs(min));

		}
	}
}
