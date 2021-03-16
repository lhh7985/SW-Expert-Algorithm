package HW;

import java.util.Scanner;

public class 색종이붙이기_성공 {
	
	static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(res==987654321? -1:res);
		
		
	}

	static int[] remain = {5,5,5,5,5};
	static int res = 987654321;
	private static void dfs(int num) {
		
		for(int i=0; i<5; i++) {
			if(remain[i] <0) return;
		}
		
		//1인 값 찾기
		int nr =0, nc = 0;
		boolean check = false;
		out:for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(arr[i][j] == 1) {
					nr = i;
					nc = j;
					check = true;
					break out;
				}
			}
		}
		
		//1이 없는 경우
		if(!check) {
			res = Math.min(res, num);
			return;
		}
		
		
		out:for(int i=4; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				for(int k=0; k<=i; k++) {
					if(nr+i>=10 || nc+i>=10 || arr[nr+j][nc+k] ==0) continue out;
				}
			}
			//모두다 1이면
			
			for(int j=0; j<=i; j++) {
				for(int k=0; k<=i; k++) {
					arr[nr+j][nc+k] = 0;
				}
			}
			remain[i]--;
			dfs(num+1);
			remain[i]++;
			for(int j=0; j<=i; j++) {
				for(int k=0; k<=i; k++) {
					arr[nr+j][nc+k] = 1;
				}
			}

		}
		
		
		
		
	}
}
