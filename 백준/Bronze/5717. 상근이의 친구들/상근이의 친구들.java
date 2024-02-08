import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] tmp = in.readLine().split(" ");
			if(tmp[0].equals("0") && tmp[1].equals("0"))break;
			sb.append(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1])+"\n");
		}
		System.out.println(sb);
	}
}