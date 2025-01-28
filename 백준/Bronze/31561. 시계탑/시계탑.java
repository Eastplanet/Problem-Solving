import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(in.readLine());

        if(N <= 30){
            System.out.println((double)N/2);
        }
        else{
            System.out.println(15 + ((double)(N-30))*((double)3/2));
        }



    }


}