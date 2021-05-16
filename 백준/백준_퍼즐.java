import java.util.Scanner;

public class 백준_퍼즐 {
	
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[3][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
