import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_적록색약 {

	static int N;
	static String[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		StringTokenizer st= null;
		for(int i=0;  i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] str = st.nextToken().split("");
			for(int j=0; j<N; j++) {
				arr[i][j] = str[j];
			}
		}
		
		visited = new boolean[N][N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j].equals("G"))
					arr[i][j] = "R";
			}
		}
		
		visited = new boolean[N][N];
		int cnt2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt2++;
				}
			}
		}
		
		
		
		System.out.println(cnt+" "+cnt2);

	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	public static void dfs(int r,int c) {
		
		visited[r][c] = true;
		int nr = 0, nc = 0;
		for(int i=0; i<4; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr<N && nc<N && nc>=0 && nr>=0 && arr[r][c].equals(arr[nr][nc]) && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}

}
