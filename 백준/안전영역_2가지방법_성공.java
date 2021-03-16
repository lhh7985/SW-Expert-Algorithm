package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역_2가지방법_성공 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st = null;
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		
		int res =0;
		for(int i=0; i<max; i++) {
			visited= new boolean[N][N];
			int num = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(arr[j][k] > i && !visited[j][k]) {
						bfs(j,k,i);
						num++;
					}
				}
			}
			res = Math.max(res, num);
		}
		
		//DFS 
//		int res =0;
//		for(int i=0; i<max; i++) {
//			visited= new boolean[N][N];
//			int num = 0;
//			for(int j=0; j<N; j++) {
//				for(int k=0; k<N; k++) {
//					if(arr[j][k] > i && !visited[j][k]) {
//						dfs(j,k,i);
//						num++;
//					}
//				}
//			}
//			res = Math.max(res, num);
//		}
		System.out.println(res);
		
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean visited[][];
	
	//DFS 풀이법
	private static void dfs(int r, int c, int max) {
		
		int nr = 0, nc = 0;
		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc] > max && !visited[nr][nc]) {
				dfs(nr,nc,max);
			}
		}

	}
	
	
	
	// BFS 풀이법
	private static void bfs(int r, int c, int max) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(r,c));

		int nr=0, nc=0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				nr= cur.x+dr[i];
				nc = cur.y+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc]>max && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Node(nr,nc));
				}
			}
		}
	}
	
	
	

}

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
