import java.util.Arrays;
import java.util.Scanner;

public class Flatten {

	private static int arr[] = new int[101];
	
	private static int as(int N) {
		int max=0;
		int min=101, minIndex=0, maxIndex=0;
		
		for(int i=1; i<=100; i++) {
			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
			if(min > arr[i]) {
				min = arr[i];
				minIndex = i;
			}
		}
		arr[maxIndex]--;
		arr[minIndex]++;
		if((max-min)<=1 || N<=0) return max-min;
		return as(N--);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			for(int i=1; i<=100; i++) {
				arr[i] = sc.nextInt();
			}
//			int result = as(sc.nextInt());
//			System.out.println(result);
			
			
//			for(int i=1; i<=N; i++) {
//				Arrays.sort(arr);
//				if(arr[100]-arr[1]<=1)break;
//				arr[1]++;
//				arr[100]--;
//			}
//			Arrays.sort(arr);
//			System.out.println("#"+tc+" "+(arr[100]-arr[1]));
			
			int max = 0, min = 101, minIndex=0, maxIndex=0;
			while(N!=0) {
				max=0;
				min=101;
				for(int i=1; i<=100; i++) {
					if(max < arr[i]) {
						max = arr[i];
						maxIndex = i;
					}
					if(min > arr[i]) {
						min = arr[i];
						minIndex = i;
					}
				}
				if(max-min<=1)break;
				arr[minIndex]++;
				arr[maxIndex]--;
				N--;
			}
			
			
			Arrays.sort(arr);
			System.out.println("#"+tc+" "+(arr[100] - arr[1]));
		}

	}

}
