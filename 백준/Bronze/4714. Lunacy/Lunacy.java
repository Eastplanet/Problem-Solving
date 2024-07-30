import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    
    public static void main(String[] args) throws Exception{

    	while(true) {
    		double N = Double.parseDouble(in.readLine());
    		if(N == -1)break;
    		
    		double first = Math.round(N*100)/100.0;
    		double second = N*0.167;
    		second = Math.round(second*100)/100.0;
    		System.out.print("Objects weighing ");
    		System.out.print(String.format("%.2f",first));
    		System.out.print(" on Earth will weigh ");
    		System.out.print(String.format("%.2f",second));
    		System.out.println(" on the moon.");
    	}
    }
}