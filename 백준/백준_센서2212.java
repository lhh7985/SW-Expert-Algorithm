import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 백준_센서2212 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		Integer[] D = new Integer[N-1];
		for(int i=0; i<N-1; i++) {
			D[i] = arr[i+1]-arr[i];
		}
		Arrays.sort(D,Collections.reverseOrder());
		int sum = 0;
		for(int i=K-1; i<N-1; i++) {
			sum+=D[i];
		}
		System.out.println(sum);

	}

}
