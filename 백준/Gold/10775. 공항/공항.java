import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] u;
	
	static int find(int a) {
		if(u[a] < 0)return a;
		return u[a] = find(u[a]);
	}
	
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		if(a==b)return;
		
		//게이트 번호가 작은게 부모가 되도록
		if(a < b) {
			u[a] += u[b];
			u[b] = a;
		}
		else {
			u[b] += u[a];
			u[a] = b;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(in.readLine());
		int P = Integer.parseInt(in.readLine());
		
		u = new int[G+1];
		Arrays.fill(u, -1);
		
		int cnt = 0;
		for(cnt =0;cnt <P;cnt++) {
			int airplane = Integer.parseInt(in.readLine());
			
//			if(airplane > G)airplane = G;
			int blankGate = find(airplane);
			if(blankGate == 0) {
				break;
			}
			
			merge(blankGate-1, blankGate);
		}
		
		System.out.println(cnt);
	}
}