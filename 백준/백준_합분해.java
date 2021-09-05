<<<<<<< HEAD
import java.util.Scanner;

public class 백준_합분해 {

	static long dp[][] = new long[201][201];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		for (int i = 0; i < 201; i++) {
			dp[i][0] = 1;
			dp[1][i] = 1;
		}
		for (int i = 1; i < 201; i++) {
			dp[2][i] = i + 1;
		}
		for (int i = 3; i < 201; i++) {
			for (int j = 1; j < 201; j++) {
				for (int k1 = 0; k1 <= j; k1++) {
					dp[i][j] += dp[i - 1][j - k1] % 1000000000;
				}
			}
		}
		System.out.println(dp[k][n] % 1000000000);

	}

}
=======
import java.util.Scanner;

public class 백준_합분해 {

	static long dp[][] = new long[201][201];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		for (int i = 0; i < 201; i++) {
			dp[i][0] = 1;
			dp[1][i] = 1;
		}
		for (int i = 1; i < 201; i++) {
			dp[2][i] = i + 1;
		}
		for (int i = 3; i < 201; i++) {
			for (int j = 1; j < 201; j++) {
				for (int k1 = 0; k1 <= j; k1++) {
					dp[i][j] += dp[i - 1][j - k1] % 1000000000;
				}
			}
		}
		System.out.println(dp[k][n] % 1000000000);

	}

}
>>>>>>> 845d3f5da14febfbe86c1757d0bfa5ca38020d2a
