package HW;

import java.util.Scanner;

public class 백준_로또6603 {

	static int[] arr;
	static int[] res = new int[6];
	static int N;
	static StringBuilder sb;
	private static void recur(int idx,int start) {
		if(idx == 6) {
			for(int i=0; i<6; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			res[idx] = arr[i];
			recur(idx+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do{
			N = sc.nextInt();
			arr = new int[N];
			sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			recur(0,0);
			System.out.println(sb);
		}while(N!=0);

	}

}
