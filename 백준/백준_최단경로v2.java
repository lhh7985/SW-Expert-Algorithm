import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 백준_최단경로v2 {
	
	static class Node{
		int x,weight;

		public Node(int x, int weight) {
			super();
			this.x = x;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt()-1;
		List<Node>[] list= new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int weight = sc.nextInt();
			list[x].add(new Node(y,weight));
		}
		
		
		int distance[] = new int[V];
		boolean visited[] = new boolean[V];
		Arrays.fill(distance, 987654321);
		
		distance[start] = 0;
		for(int i=0; i<V; i++) {
			
			// 현재 거리의 최소값 구하기 
			int min = 987654231;
			int idx = 0;
			for(int j=0; j<V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					idx = j;
				}
			}
			visited[idx] = true;
			
			//현재 인덱스에서 갈수 있는 값들을 초기화
			if(list[idx] != null) {	
				for(int j=0; j<list[idx].size(); j++) {
					Node cur = list[idx].get(j);
					if(!visited[cur.x] && distance[cur.x] > distance[idx] + cur.weight)
						distance[cur.x] = distance[idx] + cur.weight;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<V; i++) {
			sb.append(distance[i]!=987654321?distance[i]:"INF").append("\n");
		}
		System.out.println(sb);

	}

}
