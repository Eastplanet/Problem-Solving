import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		arr = new int[(int) (Math.pow(2, N)-1)];
		tree = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0, arr.length-1);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<tree[i].size();j++) {
				sb.append(tree[i].get(j)).append(" ");
			}
			sb.append("\n");
		}
		
		

		System.out.println(sb);
	}

	public static void solve(int h, int start, int end) {
		
		

		int mid = (start + end) / 2;
		tree[h].add(arr[mid]);
		
		if(h == N-1)return;

		solve(h + 1, start, mid - 1);
		solve(h + 1, mid + 1, end);

	}
}