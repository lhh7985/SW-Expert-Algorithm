import java.util.Scanner;

public class 백준_경비원 {

	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int store = sc.nextInt();
		int[][] arr = new int[2][store+1];
		for(int i=0; i<store+1; i++) {
			arr[0][i] = sc.nextInt();//방향
			arr[1][i] = sc.nextInt();//값
		}
		
		//store번쨰 배열은 내가 있는 곳
		int distance = 0;
		for(int i=0; i<store; i++) {
			distance += go(arr[0][store],arr[1][store], arr[0][i],arr[1][i]);
		}
		System.out.println(distance);
		

	}
	

	//1:북, 2:남, 3:서, 4:동
	//북 서 : 북 + 서
	//서 남 : (M-서)+남
	//남 동 : (N-남)+(M-동)
	//동 북 : 동+(N-북)
	
	//북 남 : min(M+북+남, M+(N-북)+(N-남)
	//동 서 : min(N+동+서, N+(M-동)+(M-서)
	public static int go(int dir1, int me, int dir2, int store) {
		//북서
		if(dir1==1 && dir2==3 || dir1==3 && dir2==1) {
			return me+store;
		}
		if(dir1==3 && dir2==2 || dir1==2 && dir2==3) {
			if(dir1==3) return (M-me)+store;
			if(dir1==2) return (M-store)+me;
		}
		if(dir1==2 && dir2==4 || dir1==4 && dir2==2) {
			if(dir1==2) return (N-me)+(M-store);
			if(dir1==4) return (N-store)+(M-me);
		}
		if(dir1==4 && dir2==1 || dir1==1 && dir2==4) {
			if(dir1==4) return me+(N-store);
			if(dir1==1) return store+(N-me);
		}
		
		if(dir1==1 && dir2==2 || dir1==2 && dir2==1) {
			return Math.min(M+me+store, M+(N-me)+(N-store));
		}
		if(dir1==3 && dir2==4 || dir1==4 && dir2==3) {
			return Math.min(N+me+store, N+(M-me)+(M-store));
		}
		return Math.abs(store-me);
	}

}
