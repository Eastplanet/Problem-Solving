import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] u;

	static int find(int a) {
		if (u[a] < 0)
			return a;
		return u[a] = find(u[a]);
	}

	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;

		if (u[a] < u[b]) {
			u[a] += u[b];
			u[b] = a;

		} else {
			u[b] += u[a];
			u[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		u = new int[N + 1];
		Arrays.fill(u, -1);

		// a와 b를 합친다
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			merge(a, b);
		}

		st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list = new ArrayList<>();

		// H팀도 아니고 C 팀도 아닌 집합들을 list에 담는다.
		for (int i = 1; i <= N; i++) {
			if(find(i) == find(C) || find(i) == find(H))continue;
			// 집합과 집합의 크기 저장
			list.add(new int[] {find(i),u[find(i)]});
		}
		
		//집합 크기
		list.sort((l1,l2) -> l1[1]-l2[1]);
		
		int cnt = 0;
		for(int i=0;i<list.size();i++) {
			if(cnt == K)break;
			if(find(C) != find(list.get(i)[0])) {
			merge(find(C),list.get(i)[0]);
			cnt++;
			}
		}
		
		System.out.println(-1 * u[find(C)]);
	}
}