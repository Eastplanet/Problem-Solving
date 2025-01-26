import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(in.readLine());
		
		if(N== 0) {
			System.out.println(0);
		}
		else {
			System.out.println(N/10);
		}
	}

}