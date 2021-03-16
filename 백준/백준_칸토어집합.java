package HW;

import java.util.Scanner;

public class 백준_칸토어집합 {

	static int N;
	static StringBuilder sb;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			N = sc.nextInt();
			sb = new StringBuilder();
			int t = (int) Math.pow(3, N);
			ch = new char[t];
			for(int i=0; i<t; i++) {
				ch[i] = '-';
			}
			divide(0,t);
			
			for(int i=0; i<t; i++) {
				sb.append(ch[i]);
			}
			System.out.println(sb);
		}while(sc.hasNext());		

	}

	public static void divide(int start, int end) {
		if(start>=end || end-start == 1) return;

		int y = (end-start)/2+start;
		int num = (end+1-start)/3;
		for(int i=0; i<num; i++) {
			ch[y-(num/2)+i] = ' ';
		}
		divide(start,y-(num/2)-1);
		divide(y+(num/2)+1,end);
		
	}

}
