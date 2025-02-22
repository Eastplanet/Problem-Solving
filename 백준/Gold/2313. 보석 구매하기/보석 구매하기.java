import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static long[][] arr, dp;
    public static int[][] prev;
    public static int[] lengthArr;

    public static void main(String[] args) throws Exception{

        input();

        for(int i=0;i<N;i++){


            for(int j=0;j<lengthArr[i];j++){
                dp[i][j] = arr[i][j];
                prev[i][j] = j;

                if(j != 0){
                    long cmpVal = dp[i][j-1] + arr[i][j];

                    // 이전 값이 더 클 경우
                    if(cmpVal > dp[i][j]) {
                        dp[i][j] = cmpVal;
                        prev[i][j] = prev[i][j-1];
                    }
                    // 보석의 개수가 작은 순

                    // 이전 값이랑 같을 경우
                    else if(cmpVal == dp[i][j]) {
                        int cmpLength = j - prev[i][j-1];

                        // 이전 길이랑 같은 경우 오름차순
                        if(cmpLength == j-prev[i][j]){
                            prev[i][j] = prev[i][j-1];
                        }

                    }
                }

            }

        }


        long sum = 0;
        List<int[]> buyList = new ArrayList<>();
        for(int i=0;i<N;i++){

            long max = -1000000;
            int start = 0;
            int end = 0;

            for(int j=0;j<lengthArr[i];j++){
                if(max < dp[i][j]){
                    max = dp[i][j];
                    start = prev[i][j];
                    end = j;
                }
                else if(max == dp[i][j]){
                    if(end - start > j - prev[i][j]){
                        start = prev[i][j];
                        end = j;
                    }
                }
            }

            buyList.add(new int[]{start+1,end+1});
            sum += max;
        }


        System.out.println(sum);
        for(int i=0;i<buyList.size();i++){
            System.out.println(buyList.get(i)[0] + " " + buyList.get(i)[1]);
        }

    }

    public static void input() throws Exception {
        N = Integer.parseInt(in.readLine());
        arr = new long[N][1000];
        dp = new long[N][1000];
        prev = new int[N][1000];
        lengthArr = new int[N];
        for(int i=0;i<N;i++){
            int L = Integer.parseInt(in.readLine());
            lengthArr[i] = L;
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<L;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                prev[i][j] = -1;
            }
        }
    }

}