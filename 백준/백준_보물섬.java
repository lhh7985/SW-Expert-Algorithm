import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_보물섬 {

	static int N,M;
	static String[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] str = st.nextToken().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].equals("L")) {
					bfs(i,j,new boolean[N][M]);
				}
			}
		}
		
		System.out.println(ans);

	}
	
	static class Node{
		int r,c,cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static void bfs(int r,int c,boolean[][] visited) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c,0));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(ans<cur.cnt) ans = cur.cnt;
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr<0||nr>=N || nc<0||nc>=M)continue;
				if(map[nr][nc].equals("W")) continue;
				if(visited[nr][nc]) continue;
				q.add(new Node(nr,nc,cur.cnt+1));
				visited[nr][nc] = true;
			}
			
		}
		
	}

}






