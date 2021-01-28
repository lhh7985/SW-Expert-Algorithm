package com.ssafy.D3;

import java.util.Scanner;

public class 거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc = 1; tc<=T; tc++) {
			int num = sc.nextInt();
			int degree = sc.nextInt();
			int result = recur(num, degree);
			System.out.println(result);
		}
		
	}
	
	public static int recur(int num, int degree) {
		if(degree>0)
			return recur(num, --degree)*num;
		return 1;
	}
}
