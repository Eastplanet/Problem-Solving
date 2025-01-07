import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class Main {

	public static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String a =in.readLine();
		
		if(a.length() == 4) {
			System.out.println(20);
			return;
		}
		
		if(a.charAt(1) == '0') {
			System.out.println(10 + (a.charAt(2)-'0'));
		}
		else if(a.length()==3 && a.charAt(2) == '0') {
			System.out.println(10 + (a.charAt(0)-'0'));
		}
		else {
			System.out.println((a.charAt(0)-'0') + (a.charAt(1)-'0'));
		}
				
	}
	
	
}