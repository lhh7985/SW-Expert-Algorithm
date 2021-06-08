import java.util.Scanner;

public class 백준_AB_0511 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		int cnt = 0;
		while(true) {			
			if(a==b) {
				System.out.println(cnt+1);
				break;
			}
			if(b%10==1 && b!=0) {
				b = (b-1)/10;
				cnt++;
			}else if(b%2==0 && b!=0) {
				b = b/2;
				cnt++;
			}else {
				System.out.println(-1);
				break;				
			}
		}

	}

}
