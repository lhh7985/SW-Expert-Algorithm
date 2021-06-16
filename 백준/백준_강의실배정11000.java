import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_강의실배정11000 {
	
	
	static class Node implements Comparable<Node>{
		int start, end;

		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if(this.start==o.start) return this.end-o.end;
			return this.start-o.start;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);
		for(int i=1; i<N; i++) {
			if(pq.peek()>list.get(i).start) {
				pq.add(list.get(i).end);
			}else {
				pq.poll();
				pq.add(list.get(i).end);
			}
		}
		System.out.println(pq.size());
		
		
	}

}



