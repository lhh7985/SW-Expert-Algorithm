import java.util.Arrays;
import java.util.Scanner;

public class 백준_최단경로 {

	static class Node {
		int y;
		int weight;
		Node next;

		public Node(int y, int weight, Node next) {
			super();
			this.y = y;
			this.weight = weight;
			this.next = next;
		}

		public Node(int y, int weight) {
			super();
			this.y = y;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt() - 1;

		Node[] nodes = new Node[N];

		for (int i = 0; i < E; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int w = sc.nextInt();
			nodes[x] = new Node(y, w, nodes[x]);
		}


		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N];

		dist[start] = 0;

		// 시작 정점에 있는 리스트들을 d에 담기 그리고 가장 dist가 작은 값찾기인덱스를
		for(int x=0; x<N; x++) {
			int idx = 0;
			int min = 987654321;
			
			for(int i=0; i<N; i++) {
				if(dist[i]<min && !visited[i]) {
					min = dist[i];
					idx = i;
				}
			}
			
			visited[idx] = true;

			Node curNode = nodes[idx];
			while (curNode != null) {
				if (!visited[curNode.y] && dist[curNode.y] > curNode.weight + dist[idx])
					dist[curNode.y] = curNode.weight + dist[idx];
				curNode = curNode.next;
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF").append("\n");
		}
		System.out.println(sb);

	}

}
