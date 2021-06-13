import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_카드정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}

		int sum = 0;
		if (N != 1) {
			while (pq.size() > 1) {
				int a = pq.poll();
				int b = pq.poll();
				sum += a + b;
				pq.add(a + b);
			}
		}

		System.out.println(sum);
	}

}
