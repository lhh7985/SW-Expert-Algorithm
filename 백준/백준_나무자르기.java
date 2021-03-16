import java.util.Arrays;
import java.util.Scanner;

public class 백준_나무자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//나무 수
		int M = sc.nextInt();//갖고갈 최소 나무길이
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		Arrays.sort(arr);

		int mid=0, start = 0, end = N-1;
		int result = 0;
		for(int i=arr[N-1]-1; i>=0; i--) {
			start = 0;
			end = N-1;
			while(start<=end) {
				mid = (start+end)/2;
				//먼저 다뺴고
				int sum = 0;
				for(int j=0; j<N; j++) {
					if(arr[j]>mid)
						sum+= arr[j]-mid;
				}
				if(sum>M) {
					start = mid+1;
				}else if(sum<M)
					end = mid-1;
				else{
					break;
				}
				
				
//				if(arr[mid]<i)
//					start = mid+1;
//				else if(arr[mid]>i)
//					end = mid-1;
//				else
//					break;
			}
			int sum = 0;
			for(int j=mid; j<N; j++) {
				sum += arr[j]-i;
			}
			if(sum>=M) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
