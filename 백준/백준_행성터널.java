import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 백준_행성터널 {
	
	static class Node{
		int x, y, z;
		int idx;
		public Node(int x, int y, int z, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int i, j;
		int w;
		public Edge(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}

	static int parents[];
	static List<Edge> edgeList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] nodes = new Node[N];
		
		for(int i=0; i<N; i++) {
			nodes[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
		}
		
		parents = new int[N];
		edgeList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
		
		Arrays.sort(nodes, (o1,o2)->o1.x-o2.x);
		for(int i=1; i<N; i++) {
			edgeList.add(new Edge(nodes[i-1].idx, nodes[i].idx, Math.abs(nodes[i-1].x-nodes[i].x)));
		}
		
		Arrays.sort(nodes, (o1,o2)->o1.y-o2.y);
		for(int i=1; i<N; i++) {
			edgeList.add(new Edge(nodes[i-1].idx, nodes[i].idx, Math.abs(nodes[i-1].y-nodes[i].y)));
		}
		
		Arrays.sort(nodes, (o1,o2)->o1.z-o2.z);
		for(int i=1; i<N; i++) {
			edgeList.add(new Edge(nodes[i-1].idx, nodes[i].idx, Math.abs(nodes[i-1].z-nodes[i].z)));
		}
		
		Collections.sort(edgeList);
		
		int ans = 0;
		for(Edge e : edgeList) {
			if(union(e.i,e.j)) {
				ans+=e.w;
			}
		}
		
		System.out.println(ans);
		

	}
	
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = parents[aRoot];
		return true;
	}
	
}
