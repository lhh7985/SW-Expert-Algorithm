import java.util.Arrays;
import java.util.Scanner;

public class 백준_듣보잡 {

	static int N,M;
	static String[] noListen, noSee;
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		noListen = new String[N];
		noSee = new String[M];
		
		for(int i=0; i<N; i++) {
			noListen[i] = sc.next();
		}
		for(int i=0; i<M; i++) {
			noSee[i] = sc.next();
		}
		Arrays.sort(noListen);
		Arrays.sort(noSee);

		for(int i=0; i<N; i++) {
			search(0,M-1,noListen[i]);
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static void search(int start, int end, String name) {
		
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			if(name.equals(noSee[mid])) {
				sb.append(name).append("\n");
				cnt++;
				break;
			}
			
			if(name.compareTo(noSee[mid])<0) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
			
		}
	}

}
