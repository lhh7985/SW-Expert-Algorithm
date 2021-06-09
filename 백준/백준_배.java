import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 백준_배 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> weight = new ArrayList<>();
		for(int i=0; i<N; i++)
			weight.add(sc.nextInt());
		
		int K = sc.nextInt();
		List<Integer> box = new ArrayList<>();
		for(int i=0; i<K; i++)
			box.add(sc.nextInt());
		
		Collections.sort(weight, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		if(weight.get(0)<box.get(0)) {
			System.out.println(-1);
			System.exit(0);
		}
		int cnt = 0;
		while(!box.isEmpty()) {
			
			int idx = 0,widx=0;
			while(widx<N) {
				if(box.get(idx)<=weight.get(widx)) {
					box.remove(idx);
					widx++;
				}else {
					idx++;
				}
				
				if(idx>=box.size()) break;
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
/*
3
1 2 3
6
2 2 2 2 2 2


3
6 8 9
9
1 2 3 4 5 6 7 8 9
*/
