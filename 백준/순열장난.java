package HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 순열장난 {

	static String N;
	static List<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static String[] str;
	
	private static void recur(int idx, String s) {
		if(idx==N.length()) {
			return;
		}
		
		String st= s+str[idx];
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(st)) {
				String d = list.get(list.size()-1);
				recur(idx,d);
				list.remove(list.size()-1);
			}
		}
		list.add(st);
		sb.append(st).append(" ");
		recur(idx+1,"");
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.next();
		
		str = new String[N.length()];
		for(int i=0; i<N.length(); i++) {
			str[i] = N.charAt(i)+"";
		}
		list.add(str[0]);
		sb.append(str[0]).append(" ");
		recur(1,"");
		
		System.out.println(sb);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}
