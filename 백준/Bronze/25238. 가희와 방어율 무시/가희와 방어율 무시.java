import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N;
	public static List<int[]> list;
	public static List<Integer> LIS;
	public static List<Integer> prev;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(in.readLine());
		int a= Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		double ig = a * (b/100.0);
		double ef = a - ig;
		
		if(ef < 100) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	

	
	
	
	

	

}