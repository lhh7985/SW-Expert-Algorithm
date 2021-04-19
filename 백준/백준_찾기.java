import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_찾기 {

	static final int MOD = 1000003;
	static final int D = 31;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String T = br.readLine();
		String P = br.readLine();
		int t = T.length();
		int p = P.length();

		if (t < p) {
			System.out.println(0);
			System.exit(0);
		}
		
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		long tHash = 0, pHash = 0, power = 1;

		for (int j = 0; j < p; j++) {
			pHash = (pHash * D + P.charAt(j)) % MOD;
			tHash = (tHash * D + T.charAt(j)) % MOD;
			if (j != 0)
				power = (power * D) % MOD;
		}

		for (int i = 0; i <= t - p; i++) {
			// 해쉬값이 같으면 문자열 검사
			if (tHash == pHash) {
				sb.append(i + 1).append("\n");
				cnt++;
			}
			if(i + p == t) break;
//			tHash = (D * (tHash - T.charAt(i) * power) + T.charAt(i + p)) % MOD;
			tHash = (D * (tHash - T.charAt(i) * power) + T.charAt(i + p)) % MOD;
//			tHash = (tHash - (T.charAt(i-1) *power)) * 2 + T.charAt(p-1+i);
//			tHash = (D*(tHash - T.charAt(i-1) * power) + T.charAt(p-1+i)) % MOD;
			if (tHash < 0)
				tHash += MOD;

			//

		}
		System.out.println(cnt);
		System.out.println(sb);

	}

}
