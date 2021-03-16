package HW;

import java.util.Scanner;

public class 백준_차이를최대로 {

	static int N;
	static int[] arr;
	static int[] res;
	static boolean[] check;
	static int result;
	public static void recur(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(res[i]-res[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				res[idx] = arr[i];
				check[i] = true;
				recur(idx+1);
				check[i] = false;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr= new int[N];
		res = new int[N];
		check = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		recur(0);
		System.out.println(result);
		

	}

}
