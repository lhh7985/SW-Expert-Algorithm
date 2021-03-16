package com.ssafy.D3;

import java.util.Scanner;

public class 미니멀리즘시계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int h = N/30;//111은 각도
			int m = (N- h*30)*2;
			System.out.println("#"+tc+" "+h+" "+m);
		}
	}
}
