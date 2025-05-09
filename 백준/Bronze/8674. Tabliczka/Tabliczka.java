
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        if(N%2 == 0 || M %2 == 0){
            System.out.print(0);
        }
        else {
            System.out.print((long)Math.min(N,M));
        }


    }
}