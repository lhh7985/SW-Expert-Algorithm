package HW;

import java.util.Scanner;

public class 도영이의맛있는음식 {

	static int N;
	static int tlsakt[];
	static int Tmsakt[];
	static boolean[] check;
	static int result = 1000000001;
	static int cnt;
	private static void recur(int idx,int cnt) {
		
		if(idx == N) {
			if(cnt>0) {
				int a=1, b=0;
				for(int i=0; i<N; i++) {
					if(check[i]) {
						a*= tlsakt[i];
						b+= Tmsakt[i];
					}
				}
				result = Math.min(result, Math.abs(a-b));				
			}
			return;
		}
		
		
		check[idx] = true;
		recur(idx+1, ++cnt);
		check[idx] = false;
		recur(idx+1, --cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tlsakt = new int[N];
		Tmsakt = new int[N];
		check = new boolean[N];

		for(int i=0; i<N; i++) {
			tlsakt[i] = sc.nextInt(); //곱하기
			Tmsakt[i] = sc.nextInt();	//더하기
		}
		recur(0,0);
		System.out.println(result);
		
	}

}
