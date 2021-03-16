package HW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준DFS_BFS {

	static int N, M;
	static boolean[][] arr;
	static boolean[] check;
	static boolean[] check2;

	private static void bfs(int idx) {

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(idx);
		check[idx] = true;
		while (!queue.isEmpty()) {
			int res = queue.poll();
			System.out.print(res + 1+" ");
			for (int i = 0; i < N; i++) {
				if (arr[res][i] && !check[i]) {
					check[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	private static void dfs(int idx) {
		System.out.print(idx+1+" ");
		check2[idx] = true;
		for(int i=0; i<N; i++) {
			if(arr[idx][i] && !check2[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		arr = new boolean[N][N];
		check = new boolean[N];
		check2 = new boolean[N];

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			arr[r][c] = true;
			arr[c][r] = true;
		}

		dfs(start - 1);
		System.out.println();
		bfs(start - 1);

	}

}
