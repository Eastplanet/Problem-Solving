
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(in.readLine());

        st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int sum = 0;
        sum += Math.min(N,A);
        sum += Math.min(N,B);
        sum += Math.min(N,C);

        System.out.println(sum);

    }




}