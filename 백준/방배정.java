package HW;

import java.util.Scanner;

//완전 탐색
public class 방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[2][6];
		int cnt =0;
		for(int i=0; i<N; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt()-1;
			//grade가 인덱스
			if(arr[sex][grade] % M == 0 || arr[sex][grade] == 0) cnt++;
			arr[sex][grade]++;
		}
		

		System.out.println(cnt);
	}

}
