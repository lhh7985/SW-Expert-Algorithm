package HW;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_영재의시험 {

	static int arr[] = new int[10];
	static int res[] = new int[10];
	
	public static void recur(int idx,int start) {
		
		if(idx==10) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=start; i<10; i++) {
			res[idx] = i%5+1;
			recur(idx+1,i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
		}
		recur(0,0);
		

	}

}
