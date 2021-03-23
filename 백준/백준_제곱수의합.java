package HW;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_제곱수의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[1] = 1;
		for(int i=2; i<=N; i++) {
			
			if(i<N/2 && i*i<=N && i*i>0)
				arr[i*i] = 1;
			
			int k = 1;
			while(true) {
				if(i-k >= k) {
					arr[i] = Math.min(arr[i], arr[i-k]+arr[k]);
				}else {
					break;
				}
				k++;
			}
		}
		
		System.out.println(arr[N]);

	}

}
