package com.ssafy.D3;

import java.util.Scanner;

public class 운동관리 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			if(X< L) {
				System.out.println("#"+tc+" "+ (L-X));
			}else if(L < X && X < U)
				System.out.println("#"+tc+" "+ 0);
			else
				System.out.println("#"+tc+" "+ -1);
		}
	}
}
