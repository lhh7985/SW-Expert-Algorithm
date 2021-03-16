import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_멋쟁이토마토 {

	static int N, M;
	static int[][] arr;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		arr = new int[M][N];
		int zero = 0;
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
//				arr[i][j] = sc.nextInt();
				arr[i][j] = Integer.parseInt(str[j]);
				if (arr[i][j] == 0)
					zero++;
			}
		}
		if (zero == 0) {
			System.out.println(0);
			System.exit(0);
		}

		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1)
					q.offer(new Node(i, j));
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = node.x + dr[i];
				int nc = node.y + dc[i];

				if (nr >= 0 && nc >= 0 && nr < M && nc < N && arr[nr][nc] == 0) {
					arr[nr][nc] = arr[node.x][node.y] + 1;
					q.offer(new Node(nr, nc));
				}
			}
		}

		int result = 0;
		out: for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					result = -1;
					break out;
				} else
					result = Math.max(arr[i][j], result);

			}
		}
		System.out.println(result == -1 ? result : result - 1);

	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
