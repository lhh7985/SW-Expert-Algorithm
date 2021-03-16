import java.util.Arrays;
import java.util.Scanner;

public class 백준_종이자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] r = new int[K+2];
		int[] c = new int[K+2];
		int idx1 = 1, idx2 = 1;
		
		for(int i=0; i<K; i++) {
			int dir = sc.nextInt();
			if(dir==0) {
				c[idx1++] = sc.nextInt();
			}else if(dir==1){
				r[idx2++] = sc.nextInt();
			}
		}
		c[idx1] = M;
		r[idx2] = N;
		
		Arrays.sort(r);
		Arrays.sort(c);
		int max1 = 0,max2 =0;
		for(int i=0; i<K+2; i++) {
			if(i+1<K+2) {
				max1 = Math.max(max1, Math.abs(c[i]-c[i+1]));
				max2 = Math.max(max2, Math.abs(r[i]-r[i+1]));
			}
		}
		
		System.out.println(max1*max2);

	}

}
