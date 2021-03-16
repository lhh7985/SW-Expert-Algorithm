import java.util.Arrays;
import java.util.Scanner;

public class 백준_숫자카드 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int mid =0;
			int start = 0;
			int end = N-1;
			int num = sc.nextInt();
			int res = 0;
			
			while(start<=end) {
				mid = (start+end)/2;
				if(num<arr[mid]) end=mid-1;
				else if(num>arr[mid]) start=mid+1;
				else {
					res = 1;
					break;
				}
			}
			sb.append(res).append(" ");
		}
		System.out.println(sb);

	}

}
