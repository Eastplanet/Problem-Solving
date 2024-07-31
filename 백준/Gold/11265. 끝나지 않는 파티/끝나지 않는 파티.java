import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static int N,M;
    static long[][] arr;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N+1][N+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                arr[i][j] = 10000000000L;
            }
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(arr[A][B] <= C) System.out.println("Enjoy other party");
            else System.out.println("Stay here");
        }

    }


}