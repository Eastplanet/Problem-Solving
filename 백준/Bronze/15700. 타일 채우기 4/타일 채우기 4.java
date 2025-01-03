
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class Main {

	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		if(N*M % 2 == 0) {
			System.out.println(N*M/2);
		}
		else {
			System.out.println((N*M-1)/2);
		}
				
	}
	
	
	
	
}