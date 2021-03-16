import java.util.Scanner;

public class 백준_정수제곱근 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		long left = 1;
		long right = S/2;
		long mid = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if((mid*mid) > S || mid*mid <= 0) right = mid-1;
			else left = mid+1;
		}
		if(mid*mid < S) mid++;
		System.out.println(mid);
	}
}
