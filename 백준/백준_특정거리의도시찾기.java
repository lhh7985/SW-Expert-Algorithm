import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_특정거리의도시찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		
		List<Integer>[] list = new ArrayList[N];
		
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = -1;
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			list[x].add(y);
			
		}
		
		
		
//		List<Integer> res = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		
		distance[start] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			for(int i=0; i<list[cur].size(); i++) {
				if(!visited[list[cur].get(i)] && distance[list[cur].get(i)] == -1) {
					distance[list[cur].get(i)] = distance[cur]+1;
					
					if(distance[cur]+1==K) {
//						res.add(list[cur].get(i)+1);
						hs.add(list[cur].get(i)+1);
					}
					
					q.offer(list[cur].get(i));
				}
			}
		}
		
		List<Integer> list1 = new ArrayList(hs);
		Collections.sort(list1);
		StringBuilder sb = new StringBuilder();
		if(list1.size()>0) {
			for(int i=0; i<list1.size(); i++) {
				sb.append(list1.get(i)).append("\n");
			}			
		}else {
			sb.append(-1);
		}
		
		System.out.println(sb);
		

	}

}
