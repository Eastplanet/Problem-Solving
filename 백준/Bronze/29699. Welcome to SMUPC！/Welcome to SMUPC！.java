import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
       
    	int N = Integer.parseInt(in.readLine());
    	String tmp = "WelcomeToSMUPC";
    	N--;
    	System.out.println(tmp.charAt((N%14)));
    }
    


}