import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_전기가부족해 {

	static class Node implements Comparable<Node>{
		int s,e,w;

		public Node(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		
	}
	
	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i]= i;
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<K; i++) {
			parents[Integer.parseInt(st.nextToken())-1] = -1; 
		}
		
		Node[] nodes = new Node[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			nodes[i] = new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nodes);
		
		int ans = 0;
		for(Node n : nodes) {
			if(union(n.s, n.e)) {
				ans+=n.w;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int findSet(int a) {
		if(parents[a]==-1)return -1;
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==-1 && bRoot!=-1) {
			parents[bRoot] = aRoot;
			return true;
		}else if(bRoot ==-1 && aRoot!=-1) {
			parents[aRoot] = bRoot;
			return true;
		}
		if(aRoot==bRoot) return false;
		parents[bRoot] = parents[aRoot];
		return true;
	}

}
