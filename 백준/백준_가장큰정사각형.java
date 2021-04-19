package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] d = st.nextToken().split("");
			for(int j=1, idx = 0; j<=M; j++,idx++) {
				map[i][j] = Integer.parseInt(d[idx]);
				if(map[i][j] == 1) cnt++;
			}
		}

		
		int max = cnt==0?0:1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j] >0) {
					map[i][j] = Math.min(map[i-1][j], Math.min(map[i-1][j-1], map[i][j-1])) + 1;
					max = Math.max(max, map[i][j]);
				}
			}
		}
		
		System.out.println(max*max);

	}

}
