import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static int[] u, size;

	static int find(int a) {
		if (u[a] == a) return a;
		return u[a] = find(u[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b)return;
		u[a] = b;
		size[b] += size[a];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		u = new int[N + 1];
		size = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(in.readLine());
			size[i] = num;
			u[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
			System.out.println(size[find(a)]);

		}

	}
}