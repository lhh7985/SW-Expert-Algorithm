import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준_네트워크연결 {

	
	static class Node implements Comparable<Node>{
		int x,y,w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
		
	}
	
	static int N;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
//		List<Node> list = new ArrayList<>();
		Node[] list = new Node[K];
		
		StringTokenizer st = null;
		for(int i=0; i<K; i++) {
//			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			st = new StringTokenizer(br.readLine()," ");
			list[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
//		Collections.sort(list);
		Arrays.sort(list);
		
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		
		for(Node n : list) {
			if(union(n.x,n.y)) {
				result+= n.w;
			}
		}
		
		System.out.println(result);
		
		

	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a , int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot== bRoot) return false;
		
		parents[bRoot] = parents[aRoot];
		return true;
	}

}
