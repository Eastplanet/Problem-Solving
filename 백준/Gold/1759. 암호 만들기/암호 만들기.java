import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[] mo = { 'a', 'e', 'i', 'o', 'u' };
	static int[] visited;
	static int[] word;
	static char[] arr;
	static int L, C;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		arr = new char[C];
		visited = new int[C];
		word = new int[L];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);

		back(0, 0);
		System.out.println(sb);
	}

	public static void back(int idx, int start) {

		if (idx == L) {
			int moCount = 0;
			int jacount = 0;

			for (int i = 0; i < L; i++) {

				boolean check = false;
				for (int j = 0; j < mo.length; j++) {
					if (mo[j] == arr[word[i]]) {
						check = true;
					}
				}

				if (check) {
					moCount++;
				} else {
					jacount++;
				}
			}

			if (!(moCount >= 1 && jacount >= 2)) {
				return;
			}
			
			
			for(int i=0;i<L;i++) {
				sb.append(arr[word[i]]);
			}
			sb.append("\n");
			

			return;
		}

		for (int i = start; i < C; i++) {
			if (visited[i] == 1)
				continue;

			visited[i] = 1;
			word[idx] = i;
			back(idx + 1,i+1);
			visited[i] = 0;
		}

	}
}