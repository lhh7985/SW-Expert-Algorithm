import java.util.Scanner;

public class 백준_빙고 {

	static int[][] arr = new int[6][6];
	static int eorkrtjs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][5] += arr[i][j];
				arr[5][i] += arr[j][i];
				if(i==j) arr[5][5] += arr[i][j];
				if(i+j==4) eorkrtjs += arr[i][j];
			}
		}
		
		//번호 부르기
		for(int i=0; i<25; i++) {
			int cnt =0;
			int n = sc.nextInt();
			//n 값 찾고 0으로 바꾸기 그리고 각 행열 합한 값-n하기, i==j면 대각선도 뺴주기
			check(n);
			if(i>=11) {		
				for(int j=0; j<5; j++) {
					if(arr[j][5] <= 0) cnt++;
					if(arr[5][j] <= 0) cnt++;
				}
				if(arr[5][5] <= 0) cnt++;
				if(eorkrtjs <= 0) cnt++;
				if(cnt >= 3) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
	
	private static void check(int n) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(arr[i][j] == n) {
					arr[i][j] = 0;
					arr[i][5] -=n;
					arr[5][j] -=n;
					if(i==j) {
						arr[5][5] -=n;
					}
					if(i+j==4) eorkrtjs-=n;
				}
			}
		}
	}

}
