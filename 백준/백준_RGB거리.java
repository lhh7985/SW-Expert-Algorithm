package HW;

import java.util.Scanner;

public class 백준_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
			arr[i][2]=sc.nextInt();
		}
		//3가지의 경우를 다 고려해야 함 ㅡㅡ
		for(int i=2; i<=N; i++) {
			//지금 칠하는 집이 빨강 일경우  전에 칠했던 집은 초록, 파랑중 싼 거 칠하기
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
			
			//초록색을 칠해야 할때
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
			
			//blue
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
		}
		
		int min = 987654321;
		for(int i=0; i<3; i++) {
			min = Math.min(arr[N][i], min);
		}
		System.out.println(min);
	}

}

/*
3 

1 20 30 

50 5 6 

9 3 7
*/
