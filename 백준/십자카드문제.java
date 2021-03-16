package HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 십자카드문제 {

	static int[] arr2;
	static int min=988912;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		arr2 = new int[4];
		for(int i=0; i<4; i++) {
			arr2[i] = sc.nextInt();
		}
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				for(int k=1; k<=9; k++) {
					out:for(int l=1; l<=9; l++) {
//						ijkl
						arr[0] = 1000*i+100*j+10*k+l;
//						jkli
						arr[1] = 1000*j+100*k+10*l+i;
//						klij
						arr[2] = 1000*k+100*l+10*i+j;
//						lijk
						arr[3] = 1000*l+100*i+10*j+k;
						Arrays.sort(arr);
						//만약 리스트에 없으면
						for(int x=0; x<list.size(); x++) {
							if(list.get(x) == arr[0])
								continue out;
						}
						list.add(arr[0]);
					}
				}
			}
		}
		
		//가장 작은 시계 수 뽑기
		String str="";
		for(int i=0; i<4; i++) {
			str = arr2[i%4]+""+arr2[(i+1)%4]+arr2[(i+2)%4]+arr2[(i+3)%4];
			min = Math.min(min, Integer.parseInt(str));
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == min) {
				System.out.println(i+1);
				break;
			}
		}

	}

}
