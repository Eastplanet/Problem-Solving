import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int s1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		if (p1 + p2 > s1 + s2) {
			System.out.println("Persepolis");
		} else if (p1 + p2 < s1 + s2) {
			System.out.println("Esteghlal");
		} else if (p2 > s2) {
			System.out.println("Persepolis");
		} else if (p2 < s2) {
			System.out.println("Esteghlal");
		} else {
			System.out.println("Penalty");
		}

	}

}