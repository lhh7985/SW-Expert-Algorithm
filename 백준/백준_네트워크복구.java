import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 백준_네트워크복구 {

	static class Node{
		int r,c,w;

		public Node(int r,int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
	}
	static int N,M;
	static List<Node>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = 0;
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int w = sc.nextInt();
			list[s].add(new Node(s,e,w));
			list[e].add(new Node(e,s,w));
		}
		
		int[] D = new int[N];
		int[] V = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		D[start] = 0;
		
		for(int i=0; i<N; i++) {
			
			int min= 987654321;
			int idx = -1;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min>D[j]) {
					min = D[j];
					idx = j;
				}
			}
			visited[idx] = true;
			
			for(int j=0; j<list[idx].size(); j++) {
				if(!visited[list[idx].get(j).c] && D[list[idx].get(j).c] > min + list[idx].get(j).w) {
					D[list[idx].get(j).c] = min + list[idx].get(j).w;
					V[list[idx].get(j).c] = idx; 
				}
			}
		}
		System.out.println(N-1);
		for(int i=1; i<N; i++) {
			System.out.println((i+1)+" "+(V[i]+1));
		}
		

	}

}
