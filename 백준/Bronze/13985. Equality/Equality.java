import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        st.nextToken();
        int C = Integer.parseInt(st.nextToken());

        if(A+B == C){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }


}