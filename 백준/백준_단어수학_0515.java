import java.util.Arrays;
import java.util.Scanner;

public class 백준_단어수학_0515 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[10][8];
		int[] alpa = new int[26];
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], '*');
			String str = sc.next();
			int size = str.length();
			for(int j=0; j<str.length(); j++) {
				alpa[str.charAt(j)-'A'] += Math.pow(10, size-1);
				size--;
//				arr[i][8-size+j] = str.charAt(j);
			}
		}
		Arrays.sort(alpa);
		System.out.println(Arrays.toString(alpa));
		
		int num = 9, result = 0;
		
		for(int i=25; i>=16; i--) {
			result += alpa[i]*num--;
		}
		System.out.println(result);
		
//		Arrays.fill(alpa, -1);
		
//		int num = 9;
//		for(int i=0; i<8; i++) {
//			for(int j=0; j<N; j++) {
//				if(arr[j][i] != '*' && alpa[arr[j][i]-'A'] == -1) {
//					alpa[arr[j][i]-'A'] = num--;
//				}
//			}
//		}
//		
//		int result = 0;
//		for(int i=0; i<N; i++) {
//			String s = "";
//			for(int j=0; j<8; j++) {
//				if(arr[i][j] !='*')
//					s += alpa[arr[i][j]-'A'];
//			}
//			result += Integer.parseInt(s);
//		}
//		System.out.println(result);
		

	}

}
