import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int sum = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			sum += Integer.parseInt(st.nextToken());
		}

		if(sum == 0)System.out.println("Stay");
		else if(sum>0) System.out.println("Right");
		else System.out.println("Left");
	}
}