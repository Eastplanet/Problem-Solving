import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					System.out.print("X");
				}
				System.out.println();
			}
			
			System.out.println();
		}
	}
	

}