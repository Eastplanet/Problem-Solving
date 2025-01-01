
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int treeA = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		int adapW = Integer.parseInt(st.nextToken());
		int adapV = Integer.parseInt(st.nextToken());
		
		if(treeA <= adapW/adapV) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}

}