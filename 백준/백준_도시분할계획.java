import java.util.Arrays;
import java.util.Scanner;

public class 백준_도시분할계획 {

	static class Node implements Comparable<Node> {
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aR = findSet(a);
		int bR = findSet(b);
		if(aR==bR) return false;
		
		parents[bR] = parents[aR];
		return true;
	}

	static int N, M;
	static int parents[];
	static Node list[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		parents = new int[N];
		list = new Node[M];

		for (int i = 0; i < M; i++) {
			int f = sc.nextInt()-1;
			int t = sc.nextInt()-1;
			int w = sc.nextInt();
			list[i] = new Node(f, t, w);
		}
		
		Arrays.sort(list);
		
		make();
		int result = 0;
		int count = N;
		for(Node n : list) {
			if(union(n.from, n.to)) {
				result += n.weight;
				if(--count == 2) break;
			}
		}
		
		System.out.println(result);

	}

}
