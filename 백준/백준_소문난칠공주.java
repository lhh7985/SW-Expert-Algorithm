import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_소문난칠공주 {
	static String map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[5][5];
		visited = new boolean[25];
		
		StringTokenizer st = null;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().split("");
		}
		
		dfs(0,0);
		
		System.out.println(ans);
		
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int ans;
	static boolean visited[];
	private static void dfs(int idx,int start) {
		
		if(idx==7) {
			
			int Scnt = 0;
			int x=0,y=0;
			boolean check[][] = new boolean[5][5];
			for(int i=0; i<25; i++) {
				if(visited[i]) {
					//뽑은 곳 위치확인
					int r = i/5;
					int c = i%5;
					
					check[r][c] = true;
					if(map[r][c].equals("S")) {
						Scnt++;
					}
					x = r;
					y = c;
				}
			}
			
			if(Scnt>=4) {
				//인접하는지 확인
				bfs(x,y,check);
			}
			return;
		}
		
		//7개 뽑기
		for(int i=start; i<25; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(idx+1,i+1);
				visited[i] = false;
			}
		}
	}
	
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	private static void bfs(int x, int y, boolean[][] ch) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		ch[x][y]= false; 
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr<0||nr>=5||nc<0||nc>=5) continue;
				if(!ch[nr][nc])continue;
				q.add(new Node(nr,nc));
				ch[nr][nc] = false;
				cnt++;
			}
		}
		
		if(cnt==7) ans++;		
	}
	
}



