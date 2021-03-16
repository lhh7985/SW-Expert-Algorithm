package HW;

import java.util.Scanner;

public class 백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			//최대값 찾고
			int end = -1, start = 0;
			long res = 0,price = 0, max = 0;
			while(start<N-1) {				
				for(int i=start; i<N; i++) {
					if(max <= arr[i]) {
						max = arr[i];
						end = i;
					}
				}
				for(int i=start; i<end; i++) {					
					price+= arr[i];
				}
				//그날까지 계속 1씩 더해서 그날 팔아
				res += (end - start)*arr[end] - price;
				if(res<0) {
					res = 0;
					break;
				}
				
				start = end+1;
				price =0;
				max = 0;
			}
			System.out.println("#"+tc+" "+res);
			
			
			//그리고 그뒤부터 최대값 찾고 반복
			
		}

	}

}
