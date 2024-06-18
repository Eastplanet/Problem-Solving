import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String a = in.readLine();
		if(a.contains("7")) {
			if(Integer.parseInt(a)%7==0)System.out.println("3");
			else System.out.println("2");
		}
		else {
			if(Integer.parseInt(a)%7==0)System.out.println("1");
			else System.out.println("0");
		}
	}
}