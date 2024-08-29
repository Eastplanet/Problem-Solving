import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        int A = Integer.parseInt(in.readLine());
        int B = Integer.parseInt(in.readLine());
        int C = Integer.parseInt(in.readLine());
        int D = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());

        int sum = 0;
        if(A < 0){
            sum = A*-1*C;
            A = 0;
            sum += D;
        }

        sum += (B-A)*E;
        System.out.println(sum);
    }



}