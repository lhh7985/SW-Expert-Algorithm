
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_두용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0, end = arr.length-1;
		int min = 0, max = 0, sum = 2000000000;
		while(start<end) {
			int res = arr[start]+arr[end];
			if(Math.abs(res)<sum) {
				sum = Math.abs(res);
				min = arr[start];
				max = arr[end];
			}
			if(res>0) end--;
			else start++;
		}
		
		System.out.println(min+" "+max);
	}


}

