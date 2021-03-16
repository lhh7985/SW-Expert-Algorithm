package HW;

import java.util.Scanner;

public class 마을의친밀도 {

	static int N;
	static int[][] arr;
	static int result = 98765321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}


		for (int i = 0; i < N; i++) {
			//한점에서 이어지는 가장 짧은 간선 2개를 찾아
			int min1=9876542, min2=987654321;
			for (int j = 0; j < N; j++) {
				if(i!=j) {
					int d1 = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])
					+ Math.abs(arr[i][2] - arr[j][2]);
					
					if(min1>d1) {
						min2 = min1;
						min1 = d1;
					}else if(min2>d1) {
						min2 = d1;
					}
				}
			}
			result = Math.min(min1+min2, result);

		}

		System.out.println(result);

	}

}
