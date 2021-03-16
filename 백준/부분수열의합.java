package HW;

import java.util.Scanner;

public class 부분수열의합 {

	static int N,S;
	static int[] arr;
	static boolean[] check;
	static int cnt;
	static int checkCnt;
	
	private static void recur(int idx,int c) {
		
		if(idx == N) {
			int sum =0;
			for(int i=0; i<N; i++) {
				if(check[i])
					sum += arr[i];
			}
			if(sum == S && checkCnt!=0) cnt++;
			return;
		}
		
		check[idx] = true;
		recur(idx+1,checkCnt++);
		check[idx] = false;
		recur(idx+1,checkCnt--);
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		check = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		recur(0,checkCnt);
		System.out.println(cnt);
	}

}
