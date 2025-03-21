import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N, K;
    public static int[] start;
    public static int[] sequence;

    public static void main(String[] args) throws Exception {

        init();

        System.out.println(dp(0,start[0],start[1]));

    }

    public static int dp(int idx, int left, int right){
        if(idx == K){
            return 0;
        }

        return Math.min(
                dp(idx+1, sequence[idx], right) + Math.abs(sequence[idx]-left),
                dp(idx +1, left, sequence[idx]) + Math.abs(sequence[idx]-right)
        );
    }




    public static void init() throws Exception{

        N = Integer.parseInt(in.readLine());
        start = new int[2];
        st = new StringTokenizer(in.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        Arrays.sort(start);


        K = Integer.parseInt(in.readLine());
        sequence = new int[K];
        for(int i=0;i<K;i++){
            sequence[i] = Integer.parseInt(in.readLine());
        }

    }



}