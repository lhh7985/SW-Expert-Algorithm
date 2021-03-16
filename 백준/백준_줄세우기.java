import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			list.add(i-arr[i],i+1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
		
		

	}

}
