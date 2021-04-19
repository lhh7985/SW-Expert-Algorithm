import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 백준_나만안되는연애 {

	
	static class Node{
		int end, dist;

		public Node(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = N;
		
		String[] vertex = new String[N];
		for(int i=0; i<N; i++) {
			vertex[i] = sc.next();
		}
		
		List<Node>[] list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int w = sc.nextInt();
			list[s].add(new Node(e,w));
			list[e].add(new Node(s,w));
		}
		
		int[] D = new int[N];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N];
		//임의 정점 선택
		D[0] = 0;
		int result = 0;
		for(int i=0; i<N; i++) {
			//임의 정점에서 갈 수 있는 가장 짧은 선 선택
			int min = 987654321, idx = -1;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min>D[j] ) {
					min = D[j];
					idx = j;
				}
			}
			if(idx==-1) break;
			visited[idx] = true;
			cnt--;
			result+=min;
			
			
			//값 넣기
			for(int j=0; j<list[idx].size(); j++) {
				if(!visited[list[idx].get(j).end] && D[list[idx].get(j).end] > list[idx].get(j).dist  && !vertex[idx].equals(vertex[list[idx].get(j).end])) {
					D[list[idx].get(j).end] = list[idx].get(j).dist ;
				}
			}

		}
		
		System.out.println(cnt==0?result:-1);
		
	}

}
