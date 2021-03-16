package 설숙제;

import java.util.Scanner;

public class 배열돌리기 {

	static int[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			int dir = sc.nextInt();
			
			arr= new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			dir /= 45;
			if(N==1) {}
			else if(dir<0) {
				dir*=-1;
				for(int i=0; i<dir; i++) {
					leftMove();
				}
			}else {
				for(int i=0; i<dir; i++) {
					rightMove();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
			
		}
	}
	
	public static void rightMove() {
		int temp[][] = new int[N][N];
		for(int i=0; i<4; i++) {
			for(int j=0; j<N; j++) {
				if(i==0) {
					temp[i][j] = arr[j][N/2];
					arr[j][N/2] = arr[j][j];						
				}
				if(i==1) {
					temp[i][j] = arr[j][N-j-1];
					arr[j][N-j-1] = temp[i-1][j];
				}
				if(i==2) {
					temp[i][j] = arr[N/2][N-j-1];
					arr[N/2][N-1-j] = temp[i-1][j];
				}
				if(i==3) {
					arr[j][j] = temp[i-1][N-j-1];
				}
			}
		}
	}

	
	public static void leftMove() {
		int temp[][] = new int[N][N];
		for(int i=0; i<4; i++) {
			for(int j=0; j<N; j++) {
				if(i==0) {
					temp[i][j] = arr[N/2][j];
					arr[N/2][j] =  arr[j][j];					
				}
				if(i==1) {
					temp[i][j] = arr[N-j-1][j];
					arr[N-j-1][j] = temp[i-1][j];					
				}
				if(i==2) {					
					temp[i][j] = arr[j][N/2];
					arr[j][N/2] = temp[i-1][N-j-1];
				}
				if(i==3) {
					arr[j][j] = temp[i-1][j];
				}
			}
		}
	}

}


