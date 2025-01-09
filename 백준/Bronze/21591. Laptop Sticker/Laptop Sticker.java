
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

	public static StringTokenizer st;
	public static int N, maxDay;
	public static int[] visited, permutation, consumeLimit, energy;
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		if(A >= C+2 && B >= D+2) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}

	}


}