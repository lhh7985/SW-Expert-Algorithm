import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 백준_과제 {

	static class Node implements Comparable<Node>{
		int day;
		int score;
		
		public Node(int day, int score) {
			super();
			this.day = day;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {
			if(this.day == o.day)return this.score-o.score;
			else return this.day-o.day;
		}

		@Override
		public String toString() {
			return "Node [day=" + day + ", score=" + score + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		int maxDay = 0;
		
		for(int i=0; i<N; i++) {
			int day = sc.nextInt();
			int score = sc.nextInt();
			list.add(new Node(day,score));
			maxDay = maxDay<day?day:maxDay;
		}
		
		Collections.sort(list);
		
		int cnt = 0,sum=0;
		for(int i=1000; i>0;i--) {
			int max = 0,idx=0;
			boolean c = false;
			for(int j=0; j<list.size(); j++) {
				if(list.get(j).day >= i && max<list.get(j).score) {
					max = list.get(j).score;
					idx = j;
					c = true;
				}
			}
			if(c) {
				cnt++;
				list.remove(idx);				
				sum+=max;
			}
			if(cnt==maxDay) break;
		}
		
		System.out.println(sum);
		
	}

}
