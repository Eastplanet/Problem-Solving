import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][]map = new int[201][201];
		for(int i=0;i<N;i++) {
			String [] temp = in.readLine().split(" ");
			int left = Integer.parseInt(temp[0]);
			int bot = Integer.parseInt(temp[1]);
			for(int j=left;j<left+10;j++) {
				for(int k=bot;k<bot+10;k++) {
					map[j][k] = 1;
				}
			}
		}
		
		
		int sum = 0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(map[i][j]==1)sum++;
			}
		}
		
		System.out.println(sum);
		
		
		
	}
}