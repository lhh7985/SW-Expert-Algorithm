import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 백준_순회강연 {

	static class Node{
		int pay, day;

		public Node(int pay, int day) {
			super();
			this.pay = pay;
			this.day = day;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int p = sc.nextInt();
			int d = sc.nextInt();
			list.add(new Node(p, d));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.day==o2.day) return o1.pay-o2.pay;
				return o1.day-o2.day;
			}
		});
		
		int ans = 0;
		for(int i=10000; i>0; i--) {
			int max = 0,idx=0;
			boolean ch = false;
			for(int j=list.size()-1; j>=0; j--) {
				if(i>list.get(j).day)break;
				if(i<=list.get(j).day && max<list.get(j).pay) {
					max = list.get(j).pay;
					ch = true;
					idx = j;
				}
			}
			if(ch) {
				ans += max;
				list.remove(idx);
			}
		}
		System.out.println(ans);

	}

}
