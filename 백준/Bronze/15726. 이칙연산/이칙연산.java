
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class Main {

	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		double num1 = A * B / C;
		double num2 = A / B * C;
		
		if(num1 > num2)System.out.println((int)num1);
		else System.out.println((int)num2);
				
	}
	
	
	
	
}