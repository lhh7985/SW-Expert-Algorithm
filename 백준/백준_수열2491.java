import java.util.Scanner;

public class 백준_수열2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int result = 0;
		for(int i=1; i<N; i++) {
			if(arr[i-1] <= arr[i]) max++;
			else {
				result = Math.max(result, max);
				max = 0;
			}
		}
		result = Math.max(result, max);
		
		int min = 0;
		int result2 =0;
		for(int i=1; i<N; i++) {
			if(arr[i-1] >= arr[i]) min++;
			else {
				result = Math.max(result, min);
				min = 0;
			}
		}
		result = Math.max(result, min);
		
		System.out.println(Math.max(result, result2)+1);
	}
}