import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		ans = new int[N][N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			int res = solve(L-1,R-1);
			if(res == 1)sb.append(res).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb);

	}

	public static int solve(int L, int R) {
		if(L==R)return ans[L][R] = 1;
		if(R-1 == L) {
			if(arr[L] ==arr[R])return ans[L][R] = 1;
			else return ans[L][R] = -1;
		}
		if(ans[L][R] != 0)return ans[L][R];
		
		if((solve(L+1,R-1) == 1) && (arr[L] == arr[R]) ) {
			return ans[L][R] = 1;
		}
		else {
			return ans[L][R] = -1;
		}
	}
}