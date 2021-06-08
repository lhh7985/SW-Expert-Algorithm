import java.util.ArrayList;
import java.util.Scanner;

public class 백준_ABCDE {
	
	static int N,M;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N];
		
		for(int i=0; i<N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list[start].add(end);
			list[end].add(start);
		}
		visited = new boolean[N];
		
		
		for(int i=0; i<N; i++) {
			dfs(i,1);
		}
		System.out.println(0);
		
	}
	
	static boolean[] visited;
	public static void dfs(int idx,int cnt) {
		
		if(cnt==5) {
			System.out.println(1);
			System.exit(0);
		}
		
		visited[idx] = true;
		for(int i=0; i<list[idx].size(); i++) {
			if(visited[list[idx].get(i)]) continue;
			dfs(list[idx].get(i),cnt+1);
		}
		visited[idx] = false;
		
	}

}
