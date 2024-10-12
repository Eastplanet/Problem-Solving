import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] arr = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			arr[i][0] = L;
			arr[i][1] = R;
		}
		
		int[][] dist = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				dist[i][j] = 100_000;
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)continue;
				
				int[] A = arr[i];
				int[] B = arr[j];
				if(A[0] > B[0]) {
					int[] tmp = A;
					A = B;
					B = tmp;
				}
				
				if(A[1] >= B[0]) {
					dist[i][j] = 1;
				}
				
			}
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					dist[i][j] = Integer.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		int Q = Integer.parseInt(in.readLine());
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(dist[a][b] == 100_000)System.out.println(-1);
			else System.out.println(dist[a][b]);
		}
		
		
	}

}