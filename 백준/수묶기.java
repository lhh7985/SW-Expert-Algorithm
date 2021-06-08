import java.util.Arrays;
import java.util.Scanner;

public class 수묶기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i = N-1; i > 0; i--) {
			if((arr[i]>1 && arr[i-1] >1)) {
				arr[i] = arr[i]*arr[i-1];
				arr[i-1] = 10001;
				i--;
			}else {
				break;
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			if(arr[i]<0 && arr[i+1]<0) {
				arr[i] = arr[i]*arr[i+1];
				arr[i+1] = 0;
				i++;
			}else if(arr[i]<0 && arr[i+1]>=0) {
				if(arr[i+1] !=10001) {
					arr[i] = arr[i]*arr[i+1]>arr[i]+arr[i+1]?arr[i]*arr[i+1]:arr[i]+arr[i+1];
					arr[i+1] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(arr[i]!=10001) {
				sum+=arr[i];
			}
		}
		
		System.out.println(sum);
	}

}
