package HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		String arr[] = str.split("-");
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			int sum=0;
			if(arr[i].contains("+")) {
				String num[] = arr[i].split("\\+");
				for(int j=0; j<num.length; j++) {
					sum+=Integer.parseInt(num[j]);
				}				
			}else {
				sum = Integer.parseInt(arr[i]);
			}
			list.add(sum);
		}
		
		int result = list.get(0);
		for(int i=1; i<list.size(); i++) {
			result -= list.get(i);
		}

		System.out.println(result);
	}

}
