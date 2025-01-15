import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            st = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N % 2 == 0){
                System.out.println( (N/2) * M);
            }
            else if(M % 2 == 0){
                System.out.println( (M/2) * N);
            }
            else{


                int max = Math.max( (N-1)/2 * M + M/2, (M-1)/2 * N + N/2);
                System.out.println(max);
            }
        }

    }


}