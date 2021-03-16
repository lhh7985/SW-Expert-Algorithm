package 설숙제;

import java.util.Scanner;

public class 블라인드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res[] = new int[5];
		int num[] = new int[M];
		int cnt = 0;
		
		for(int i=0; i<N*4+N+1; i++) {
			String str = sc.next();
			String str2[] = str.split("#");
			if(str2.length==0)continue;
			
			for(int j=1; j<=M; j++) {
				if(str2[j].equals("****")) {
					num[j-1]+=1;
				}
			}
			cnt++;
			if(cnt==4) {
				cnt=0;
				for(int j=0; j<num.length; j++) {
					res[num[j]]++;
					num[j] = 0;
				}
			}
			
		}

		for(int i=0; i<5; i++) {
			System.out.print(res[i]+" ");
		}
	}

}
