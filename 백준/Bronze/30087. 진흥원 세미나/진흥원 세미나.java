import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			if(tmp.contains("Al"))System.out.println(204);
			else if(tmp.contains("Da"))System.out.println(207);
			else if(tmp.contains("Ar"))System.out.println(302);
			else if(tmp.contains("Cy"))System.out.println("B101");
			else if(tmp.contains("Ne"))System.out.println(303);
			else if(tmp.contains("Sta"))System.out.println(501);
			else if(tmp.contains("Tes"))System.out.println(105);
		}
	}
}