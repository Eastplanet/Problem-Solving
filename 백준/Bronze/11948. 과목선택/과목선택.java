import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int sum = 0;
		int min1 = 1000;
		for(int i=0;i<4;i++) {
			int num = Integer.parseInt(in.readLine());
			min1 = Math.min(num, min1);
			sum += num;
		}
		
		sum -= min1;
		
		int min2 = 1000;
		for(int i=0;i<2;i++){
			int num = Integer.parseInt(in.readLine());
			min2 = Math.min(num, min2);
			sum += num;
		}
		
		sum -= min2;
		
		System.out.println(sum);
		
	}

}