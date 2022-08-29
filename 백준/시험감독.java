package 백준;
import java.util.Scanner;

public class 시험감독 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();

        long ans = N;
        for (int i = 0; i < N; i++) {
            arr[i] -= A;
            if(arr[i] <= 0) continue;
            if((arr[i] % B) != 0) ans += (arr[i] / B)+1;
            else ans += arr[i] / B;
        }
        System.out.println(ans);
    }
}
