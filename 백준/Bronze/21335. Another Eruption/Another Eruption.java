import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		// N = PI * r^2
		long N = Long.parseLong(in.readLine());
		double r =  Math.sqrt((double)N/Math.PI);
		// 2 * PI * r
		System.out.println(2*Math.PI*r);
	}





}