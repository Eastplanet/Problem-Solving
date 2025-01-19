import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		long sum = 0;
		
		while(true) {
			int num = Integer.parseInt(in.readLine());
			if(num == -1) {
				break;
			}
			sum+= num;
		}
		System.out.println(sum);
	}

}