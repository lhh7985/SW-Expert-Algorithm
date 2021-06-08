import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_행렬_0513 {
	
	static boolean check[][];
	static int[][] A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] str = st.nextToken().split("");
			for (int j = 0; j < M; j++) {
				A[i][j] =Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] str = st.nextToken().split("");
			for (int j = 0; j < M; j++) {
				B[i][j] =Integer.parseInt(str[j]);
				if(A[i][j]==B[i][j]) check[i][j] =true;
			}
		}
		int cnt = 0;
		out2:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check[i][j] && i+3<=N && j+3<=M) {
					//뒤집기
					reverse(i,j);
					cnt++;
				}
				boolean status = true;
				out:for (int x = 0; x < N; x++) {
					for (int y = 0; y < M; y++) {
						if(!check[x][y]) {
							status = false;
							break out;
						}
					}
				}
				
				if(status) {
					break out2;
				}
				
				
			}
		}
		
		int c = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if(!check[x][y]) {
					c++;
				}
			}
		}
		
		
		if(c>0) System.out.println(-1);
		else System.out.println(cnt);
		
		
	}
	
	private static void reverse(int r, int c) {
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				A[i][j] = A[i][j]==1? 0:1;
				check[i][j] = !check[i][j];
			}
		}
	}
}
