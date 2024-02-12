import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			int M = Integer.parseInt(in.readLine());
			for(int j=0;j<M;j++)System.out.print("=");
			System.out.println();
		}
	}
}