package HW;

import java.util.Scanner;

public class 백준_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[101][101];
		for(int i=1; i<=N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int j=x,e = x+w; j<e; j++) {
				for(int k=y,t = y+h; k<t; k++) {
					arr[j][k] = i;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int[] ch = new int[101];
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(arr[i][j] == 0) continue;
				ch[arr[i][j]]++;
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(ch[i]).append("\n");
		}
		System.out.println(sb);
		
	}

}
