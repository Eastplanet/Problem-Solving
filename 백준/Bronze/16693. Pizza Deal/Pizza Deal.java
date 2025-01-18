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

		st = new StringTokenizer(in.readLine());
		int A1 = Integer.parseInt(st.nextToken());
		int P1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int R1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());
		
		double S = A1/(double)P1;
		double R = (double)R1*R1/P2;
		
		if(S > R*Math.PI) {
			System.out.println("Slice of pizza");
		}
		else {
			System.out.println("Whole pizza");
		}
	}
	
	
	

}