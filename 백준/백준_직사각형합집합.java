import java.util.Scanner;

public class 백준_직사각형합집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][4];
		int[][] map = new int[101][101];
		int cnt = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				arr[i][j] = sc.nextInt();
			}
			for(int j=arr[i][0]; j<arr[i][2]; j++) {
				for(int k = arr[i][1]; k<arr[i][3]; k++) {
					if(map[j][k] !=1) {
						map[j][k] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		
	}
}
