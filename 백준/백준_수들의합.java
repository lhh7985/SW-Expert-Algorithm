package HW;

import java.util.Scanner;

public class 백준_수들의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		int cnt=1;
		int i =1;
		while(true) {
			if(N==0 || i>N) break;
			if((N-i)>i) {
				N -= i;
				cnt++;
			}
			i++;
		}
		System.out.println(cnt);
	}

}
