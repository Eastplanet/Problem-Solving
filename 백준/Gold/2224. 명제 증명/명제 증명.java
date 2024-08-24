import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int[][] adj = new int[52][52];

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(in.readLine());
		
		
		
		adj = new int[52][52];
		for(int i=0;i<52;i++) {
			for(int j=0;j<52;j++) {
				adj[i][j] = 1000000;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			char start = st.nextToken().charAt(0);
			String tmp = st.nextToken();
			char end = st.nextToken().charAt(0);

			adj[charToInt(start)][charToInt(end)] = 1;
		}

		for (int k = 0; k < 52; k++) {
			for (int i = 0; i < 52; i++) {
				for (int j = 0; j < 52; j++) {
					if(adj[i][k] == 1000000 || adj[k][j] == 1000000)continue;
					adj[i][j] = Math.min(adj[i][j],adj[i][k]+adj[k][j]);
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<52;i++) {
			for(int j=0;j<52;j++) {
				if(i==j)continue;
				if(adj[i][j] != 1000000) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		for(int i=0;i<52;i++) {
			for(int j=0;j<52;j++) {
				if(i==j)continue;
				if(adj[i][j] != 1000000) {
					System.out.print(intToChar(i));
					System.out.print(" => ");
					System.out.println(intToChar(j));
				}
			}
		}
		
	}

	static int charToInt(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a' + 26;
		} else {
			return c - 'A';
		}
	}

	static char intToChar(int i) {
		if (i >= 0 && i < 26) {
			return (char) ('A' + i);
		} else {
			return (char) ('a' + i - 26);
		}
	}

}