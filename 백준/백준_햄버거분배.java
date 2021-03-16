package HW;

import java.util.Scanner;

public class 백준_햄버거분배 {

	static int N, K;
	static String[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		String str = sc.next();
		arr = str.split("");
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(arr[i].equals("P")) {
				for(int j=i-K; j<=i+K; j++) {
					if(j<0 || j>=N) continue;
					if(arr[j].equals("H")) {
						cnt++;
						arr[j] = "0";
						break;						
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
