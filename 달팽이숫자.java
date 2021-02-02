package com.ssafy.codingTest;

import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int arr[][] = new int[N][N];
			int num=1;
			
			for(int i=0; i<N; i++) {
				for(int j=i; j<N-i; j++) {
					arr[i][j] = num++;
				}
				for(int j=i+1; j<N-i; j++) {
					arr[j][N-i-1] = num++;
				}
				for(int j=N-i-2; j>=i; j--) {
					arr[N-i-1][j] = num++;
				}
				for(int j = N-i-2; j>=i+1; j--) {
					arr[j][i] = num++;
				}
			}
			
//			for(int x=0; x<N; x++) {
//				for(int j=x; j<N-x; j++) {
//					if(x<=N/2)
//						arr[x][j] = num++;
//				}
//				for(int i=x+1; i<N-x; i++) {
//					arr[i][N-1-x] = num++;
//				}
//
//				for(int i=N-2-x; i>=x; i--) {
//					arr[N-1-x][i] = num++;
//				}
//
//				for(int i=N-2-x; i>=x+1; i--) {
//					arr[i][x] = num++;
//				}
//
//			}
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
		}
	}
}
