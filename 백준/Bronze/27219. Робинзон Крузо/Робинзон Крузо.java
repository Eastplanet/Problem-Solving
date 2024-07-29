import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    
    public static void main(String[] args) throws Exception{

    	int N = Integer.parseInt(in.readLine());
    	int five = N/5;
    	for(int i=0;i<five;i++)System.out.print("V");
    	for(int i=0;i<N%5;i++)System.out.print("I");
    }
}