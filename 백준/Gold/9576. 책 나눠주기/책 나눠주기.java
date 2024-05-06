import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<int[]> list = new ArrayList<>();
			
			for(int i = 0 ;i<M;i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.add(new int[] {start,end});
			}
			
			Comparator<int[]> comp = new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1])return o1[0] - o2[0];
					else return o1[1] - o2[1];
				}
			};
			Collections.sort(list,comp);
			
			
			int count = 0;
			int[] visited = new int[list.size()];
			
			for(int i=1;i<=N;i++) {
				for(int j=0;j<list.size();j++) {
					int[] range = list.get(j);
					if(range[0] <= i && i <= range[1] && visited[j] == 0) {
						count++;
						visited[j] = 1;
						break;
					}
				}
			}
			
			System.out.println(count);
			
			
		}

	}
}