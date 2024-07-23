import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    
    public static void main(String[] args) throws Exception{

    	for(int i=0;i<3;i++) {
    		
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		
    		int h = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		int s = Integer.parseInt(st.nextToken());
    		
    		int sum = h*3600 + m*60 + s;
    		
    		int h1 = Integer.parseInt(st.nextToken() );
    		int m1 = Integer.parseInt(st.nextToken());
    		int s1 = Integer.parseInt(st.nextToken());
    		
    		int sum2 = h1*3600 + m1*60 + s1;
    		
    		sum2 -= sum;
    		
    		int a = sum2/3600;
    		System.out.print(a+" ");
    		sum2 %= 3600;
    		
    		int b = sum2/60;
    		System.out.print(b+" ");
    		
    		sum2 %= 60;
    		
    		System.out.println(sum2);
    		
    	}
    }
}