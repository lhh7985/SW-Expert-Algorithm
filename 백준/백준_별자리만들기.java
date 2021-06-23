import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 백준_별자리만들기 {

	static class Node{
		float x,y;

		public Node(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(new Node(sc.nextFloat(),sc.nextFloat()));
		}
		
		float[][] map = new float[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i!=j) {
					map[i][j] = (float) Math.sqrt(Math.pow((list.get(j).x-list.get(i).x),2) + Math.pow((list.get(j).y-list.get(i).y), 2));
				}
			}
		}
		
		
		float[] minEdge = new float[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;
		float result = 0;
		for(int i=0; i<N; i++) {
			float min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && map[minVertex][j] !=0 && minEdge[j]>map[minVertex][j]) {
					minEdge[j] = map[minVertex][j];
				}
			}
			
			
		}
		result = (float) (Math.floor(result*100)/100.0);
		System.out.println(result);
		

	}

}
