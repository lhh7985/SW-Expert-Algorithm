package HW;

import java.util.Scanner;

public class 백준_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[2][6];
		boolean[] check = new boolean[5];
		for(int i=0; i<6; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
		}
		
		int max = 0;
		int idx = 0;
		for(int i=0; i<6; i++) {
			if(max < arr[1][i]*arr[1][(i+1)%6]) {
				max = arr[1][i]*arr[1][(i+1)%6];
				idx = i;
			}
		}
		
		max = max - arr[1][(idx+3)%6]*arr[1][(idx+4)%6];
		System.out.println(max*N);

	}

}
