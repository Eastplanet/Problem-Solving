import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][3];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			
			
			int sum = 0;
			
			for(int i=0;i<N;i++) {
				int max = 0;
				for(int j=0;j<3;j++) {
					max = Math.max(max,	arr[i][j]);
				}
				
				sum+= max;
			}
			
			System.out.println(sum);
		}
	}

}