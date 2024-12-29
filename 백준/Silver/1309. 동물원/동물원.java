import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static StringTokenizer st;
	
	public static final int DIVIDE = 9901;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		long[][] arr = new long[N+1][3];
		
		arr[1][0] = 1;
		arr[1][1] = 1;
		arr[1][2] = 1;
		
		
		for(int i=2;i<=N;i++) {
			arr[i][0] = (arr[i-1][0]%DIVIDE + arr[i-1][1]%DIVIDE + arr[i-1][2]%DIVIDE) % DIVIDE;
			arr[i][1] = (arr[i-1][0]%DIVIDE + arr[i-1][2]%DIVIDE) % DIVIDE;
			arr[i][2] = (arr[i-1][0]%DIVIDE + arr[i-1][1]%DIVIDE) % DIVIDE;
		}
		
		System.out.println((arr[N][0]%DIVIDE + arr[N][1]%DIVIDE + arr[N][2]%DIVIDE)%DIVIDE);
		
	}

}