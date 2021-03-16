package HW;

import java.util.Scanner;

public class 색종이 {

	static boolean arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new boolean[101][101];
		
		int width = 0;
		int T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			for(int i=startRow+1; i<=startRow+10; i++) {
				for(int j=startCol+1; j<=startCol+10; j++) {
					if(!arr[i][j]) {
						arr[i][j] = true;
						width++;
					}
				}
			}
		}
		
		System.out.println(width);
		
	}

}
