import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    
    public static void main(String[] args) throws Exception{
	     int sum = 0;
	     int sum2 = 0;
	     StringTokenizer st = new StringTokenizer(in.readLine());
	     
	     sum+= Integer.parseInt(st.nextToken())*6;
	     sum+= Integer.parseInt(st.nextToken())*3;
	     sum+= Integer.parseInt(st.nextToken())*2;
	     sum+= Integer.parseInt(st.nextToken())*1;
	     sum+= Integer.parseInt(st.nextToken())*2;
	     
	     st  = new StringTokenizer(in.readLine());
	     sum2+= Integer.parseInt(st.nextToken())*6;
	     sum2+= Integer.parseInt(st.nextToken())*3;
	     sum2+= Integer.parseInt(st.nextToken())*2;
	     sum2+= Integer.parseInt(st.nextToken())*1;
	     sum2+= Integer.parseInt(st.nextToken())*2;
	     
	     System.out.println(sum + " " + sum2);
    }
}