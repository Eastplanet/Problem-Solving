import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a= Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if((double)a >= (double)b/2)System.out.println("E");
		else System.out.println("H");
	}

}