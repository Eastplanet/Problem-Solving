
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
		
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			
			if(a == 0 && b == 0) {
				System.out.println("AXIS");
				break;
			}
			else if(a == 0 || b == 0) {
				System.out.println("AXIS");
			}
			else if(a > 0 && b > 0) {
				System.out.println("Q1");
			}
			else if(a > 0 && b < 0) {
				System.out.println("Q4");
			}
			else if(a < 0 && b > 0) {
				System.out.println("Q2");
			}
			else {
				System.out.println("Q3");
				}
		}
		

	}


}