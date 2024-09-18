import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(in.readLine());

        while(T-- > 0 ){
            int N = Integer.parseInt(in.readLine());

            for(int i=0;i<N;i++){
                st = new StringTokenizer(in.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                System.out.println(A+B +" "+ A*B);
            }
        }
    }


}