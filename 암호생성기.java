package com.ssafy.D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			int num = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<8; i++) {
				list.add(sc.nextInt());
			}
			int cnt=1;
			while(list.get(7) > 0) {
				int n = list.get(0);
				list.remove(0);
				int s = (n-cnt) < 0 ? 0 : n-cnt;
				list.add(s);	
				if(cnt<5) cnt++;
				else cnt=1;
			}
			System.out.print("#"+tc+" ");
			for(Integer i : list) {
				System.out.print(i+" ");
			}
            System.out.println();
		}
	}
}
