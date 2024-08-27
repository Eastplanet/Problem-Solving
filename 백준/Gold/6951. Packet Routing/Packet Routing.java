import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, W, P;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[s][e] = w;
            arr[e][s] = w;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)continue;
                    arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i=0;i<P;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(arr[s][e]);
        }
    }



}