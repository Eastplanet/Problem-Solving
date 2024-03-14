import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int min = Integer.MAX_VALUE;
		int soongsil = Integer.parseInt(st.nextToken());
		min = Math.min(min, soongsil);
		int korea = Integer.parseInt(st.nextToken());
		min = Math.min(min, korea);
		int hanyang = Integer.parseInt(st.nextToken());
		min = Math.min(min, hanyang);
		
		
		
		if(soongsil + korea + hanyang >= 100) {
			System.out.println("OK");
		}
		else {
			if(min == soongsil) {
				System.out.println("Soongsil");
			}
			else if(min == korea) {
				System.out.println("Korea");
			}
			else {
				System.out.println("Hanyang");
			}
		}
		
	}
}