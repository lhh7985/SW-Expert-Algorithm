import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_컵라면 {

	static class Node implements Comparable<Node>{
		int day, cnt;

		public Node(int day, int cnt) {
			super();
			this.day = day;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if(this.day==o.day) Integer.compare(this.cnt, o.cnt);
			return Integer.compare(this.day, o.day);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		StringTokenizer st = null;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int day = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list.add(new Node(day,cnt));
		}
		
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			pq.add(list.get(i).cnt);
			if(pq.size()>list.get(i).day) {
				pq.poll();
			}
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		
		System.out.println(ans);
		
	}

}
