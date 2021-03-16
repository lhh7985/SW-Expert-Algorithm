package com.ssafy.D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			List<String> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				String word = sc.next();
				list.add(word);
			}
			int M = sc.nextInt();
			for(int i=0; i<M; i++) {
				String command = sc.next();
				if(command.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					String z[] = new String[y];
					for(int k = 0; k<y; k++ ) {
						z[k] = sc.next();
					}
					for(int j=0; j<y; j++) {
						list.add(x,z[j]);
						x++;
					}
				}
				else if(command.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0; j<y; j++) {
						list.remove(x+1);
					}
				}
				else if(command.equals("A")) {
					int y = sc.nextInt();
					String s[]= new String[y];
					for(int j=0; j<y; j++) {
						s[j] = sc.next();
						list.add(s[j]);
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}
