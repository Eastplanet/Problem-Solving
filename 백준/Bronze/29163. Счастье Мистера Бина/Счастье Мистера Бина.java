import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    
    public static void main(String[] args) throws Exception{

    	int N = Integer.parseInt(in.readLine());
    	int cnt = 0;
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	for(int i=0;i<N;i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(num % 2 == 0)cnt++;
    	}
    	
    	if(N-cnt < cnt)System.out.println("Happy");
    	else System.out.println("Sad");
    }
}