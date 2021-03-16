package HW;

import java.util.Scanner;

public class 백준_경사로 {
	
	static int L,N;
	static int[][] arr;
	static boolean[][] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();//경사로 길이
		check = new boolean[N][N];
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//오르막길
		//현재 수가 전에 수보다 크면  L개의 뒤수가 같으면 true후  진행 , 그렇지 않으면 불가능
		//현재의 수가 전의수보다 작으면 현재부터 L개의 수가 앞으로 같으면 바꾸고 true
		
		//가로 검사
		int cnt =0;
		for(int i=0; i<N; i++) {
			boolean curStatus = true;
			for(int j=0; j<N; j++) {
				if(j-1>=0 && arr[i][j] != arr[i][j-1]) {
					if(arr[i][j] > arr[i][j-1]) {
						if(Cross1(i,j)) continue;
						else {
							curStatus = false;
							break;
						}						
					}else {
						if(Cross2(i,j)) continue;
						else {
							curStatus = false;
							break;
						}
					}
				}
			}
			if(curStatus) {
				cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				check[i][j] = false;
			}
		}
		
		
		for(int i=0; i<N; i++) {
			boolean curStatus = true;
			for(int j=0; j<N; j++) {
				if(j-1>=0 && arr[j][i] != arr[j-1][i]) {
					if(arr[j][i] > arr[j-1][i]) {
						if(rowCross1(j,i)) continue;
						else {
							curStatus = false;
							break;
						}						
					}else {
						if(rowCross2(j,i)) continue;
						else {
							curStatus = false;
							break;
						}
					}
				}
			}
			if(curStatus) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
		
		
		
	}
	
	//오르박
	public static boolean Cross1(int r, int c) {
		for(int i=1; i<=L; i++) {
			//뒤의 수를 검사
			if((c-L)<0 || Math.abs(arr[r][c-i] - arr[r][c]) != 1 || check[r][c-i]) {
				return false;
			}
		}
		for(int i=1; i<=L; i++) {
			//뒤의 수를 검사
			check[r][c-i] = true; 
		}
		return true;
	}
	
	public static boolean rowCross1(int r, int c) {
		for(int i=1; i<=L; i++) {
			//뒤의 수를 검사
			if((r-L)<0 || Math.abs(arr[r-i][c] - arr[r][c]) != 1 || check[r-i][c]) {
				return false;
			}
		}
		for(int i=1; i<=L; i++) {
			//뒤의 수를 검사
			check[r-i][c] = true; 
		}
		return true;
	}
	
	//내리막
	public static boolean Cross2(int r, int c) {
		for(int i=0; i<L; i++) {
			//뒤의 수를 검사
			if((c+L)>N ||  Math.abs(arr[r][c+i] - arr[r][c-1]) != 1 || check[r][c+i]) {
				return false;
			}
		}
		
		for(int i=0; i<L; i++) {
			//뒤의 수를 검사
			check[r][c+i] = true; 
		}
		return true;
	}
	
	public static boolean rowCross2(int r, int c) {
		for(int i=0; i<L; i++) {
			//뒤의 수를 검사
			if((r+L)>N ||  Math.abs(arr[r+i][c] - arr[r-1][c]) != 1 || check[r+i][c]) {
				return false;
			}
		}
		
		for(int i=0; i<L; i++) {
			//뒤의 수를 검사
			check[r+i][c] = true; 
		}
		return true;
	}
	
}
