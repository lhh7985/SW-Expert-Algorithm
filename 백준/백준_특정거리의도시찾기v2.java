import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_특정거리의도시찾기v2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		
		List<Integer>[] list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			list[x].add(y);
			
		}
		
		
		Queue<Integer> q = new LinkedList<>();
//		for(int i=0; i<list[start].size(); i++) {
//			q.offer(list[start].get(i));
//		}
		q.offer(start);
		boolean visited[] = new boolean[N];
		visited[start] = true;
		int d = 1,size;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			
			size = q.size();
			while(--size>=0) {
				int cur = q.poll();
//				
				if(d-1==K) {
					System.out.println(cur+1);
					cnt++;
				}
				
				for(int i=0; i<list[cur].size(); i++) {
					if(!visited[list[cur].get(i)]) {
						visited[list[cur].get(i)] = true;
						q.offer(list[cur].get(i));
						
					}
				}
			}
			d++;
		}
		

		if(cnt==0)
			System.out.println(-1);
	}

}
