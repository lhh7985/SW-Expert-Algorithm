package com.ssafy.D3;

import java.util.Scanner;

public class 회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			char arr[][] = new char[8][8];
			String array[] = new String[8];
			for (int i = 0; i < 8; i++) {
				array[i] = sc.next();
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					arr[i][j] = array[i].charAt(j);
				}
			}
			int count = 0;
			for (int i = 0; i < 8; i++) {

				for (int j = 0; j < 9 - N; j++) {
					String result1 = "";
					String result2 = "";
					for (int k = j; k < j + N; k++) {
						result1 += arr[i][k];
					}
					for (int k = j + N - 1; k >= j; k--) {
						result2 += arr[i][k];
					}
					if (result1.equals(result2))
						count++;
				}

				for (int j = 0; j < 9 - N; j++) {
					String result3 = "";
					String result4 = "";
					for (int k = j; k < j + N; k++) {
						result3 += arr[k][i];
					}
					for (int k = j + N - 1; k >= j; k--) {
						result4 += arr[k][i];
					}
					if (result3.equals(result4))
						count++;
				}
			}
			System.out.println("#" + tc + " " + count);

		}
	}
}
