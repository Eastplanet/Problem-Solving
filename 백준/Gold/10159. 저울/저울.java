import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;

    static int[][] arr;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());

        arr = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;

        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)continue;
                    arr[i][j] = 1;
                }
            }
        }


        for(int i=1;i<=N;i++){
            int cnt = 0;
            for(int j=1;j<=N;j++){
                if(i == j)continue;
                if(arr[i][j] == Integer.MAX_VALUE && arr[j][i] == Integer.MAX_VALUE)cnt++;
            }
            System.out.println(cnt);
        }


    }


}