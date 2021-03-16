import java.util.Arrays;
import java.util.Scanner;

public class 백준_예산 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();//총예산
		
		Arrays.sort(arr);
		int start = 0, end = M;
		int mid = 0;
		
		int sum2 = 0;
		for(int i=0; i<N; i++) {
			sum2+=arr[i];
		}
		if(sum2<=M) {
			System.out.println(arr[N-1]);
			System.exit(0);
		}
		
		while(start<=end) {
			mid = (start+end)/2;
			
			int sum = M;
			for(int i=0; i<N; i++) {
				if(mid>=arr[i]) {
					sum -= arr[i];
				}else {
					sum-=mid;
				}
			}
			if(sum<0)
				end = mid-1;
			else if(sum>=0)
				start = mid+1;
		}
		System.out.println(end);
	}

}
