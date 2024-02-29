import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	String tmp = in.readLine();
	char[] carr = tmp.toCharArray();
	
	
	for(int i=0;i<carr.length;i++) {
		sb.append ((char)(carr[i]^32));
	}
	System.out.println(sb);
}
}