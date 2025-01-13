import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int P = 5 * N - 400;
		
		System.out.println(P);
		if(P > 100) {
			System.out.println(-1);
		}
		else if(P == 100) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}
	}
}