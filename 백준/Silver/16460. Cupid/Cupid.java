import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] arr;

	static class People{
		String name;
		String want;
		int dist;
		
		public People() {
			
		}
		public People(String name, String want, int dist) {
			this.name = name;
			this.want = want;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		
		People my = new People();
		my.name = st.nextToken();
		my.want = st.nextToken();
		my.dist = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(in.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			
			People tmp = new People();
			tmp.name = st.nextToken();
			tmp.want = st.nextToken();
			tmp.dist = Integer.parseInt(st.nextToken());
			
			if(tmp.dist > my.dist)continue;
			if(my.want.equals("MF") || my.want.equals("FM") || my.want.equals(tmp.want)) {
				list.add(tmp.name);
			}
			
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		if(list.size() == 0) {
			System.out.println("No one yet");
		}
		
	}
	
	



}