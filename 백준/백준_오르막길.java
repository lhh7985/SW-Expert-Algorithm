import java.util.Scanner;

public class 백준_오르막길 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		int max = 0;
		for(int i=0; i<N-1; i++) {
			int c =0;
			for(int j=i+1; j<N; j++) {
				if(arr[j-1]<arr[j]) c+=arr[j]-arr[j-1];
				else break;			
			}
			max = Math.max(c, max);
		}
		System.out.println(max);
	}

}
