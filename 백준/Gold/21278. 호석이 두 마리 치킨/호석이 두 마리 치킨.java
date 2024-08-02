import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;
    static int[] visited;

    static int[] KFC = new int[2];

    static int minDist = Integer.MAX_VALUE;
    static int firstBuildingNum;
    static int secondBuildingNum;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        arr = new int[N+1][N+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<=N;i++){
            arr[i][i] = 0;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][k] == Integer.MAX_VALUE || arr[j][k] == Integer.MAX_VALUE){
                        continue;
                    }
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        comb(1,0);

        System.out.println(firstBuildingNum + " " + secondBuildingNum + " " + minDist);
    }

    public static void calc(){
        int sum = 0;

        for(int i=1;i<=N;i++){
            int min;
            if(arr[KFC[0]][i] == Integer.MAX_VALUE && arr[KFC[1]][i] == Integer.MAX_VALUE)min = 10000;
            else min = Math.min(arr[KFC[0]][i], arr[KFC[1]][i]);
            sum += min*2;
        }

        if(minDist > sum){
            minDist = sum;
            firstBuildingNum = Math.min(KFC[0],KFC[1]);
            secondBuildingNum = Math.max(KFC[0],KFC[1]);
        }
        else if(minDist == sum){
            int tmpFirst = Math.min(KFC[0],KFC[1]);
            int tmpSecond = Math.max(KFC[0],KFC[1]);
            if(firstBuildingNum > tmpFirst){
                firstBuildingNum = tmpFirst;
                secondBuildingNum = tmpSecond;
            }
            else if(firstBuildingNum == tmpFirst && secondBuildingNum > tmpSecond){
                firstBuildingNum = tmpFirst;
                secondBuildingNum = tmpSecond;
            }
        }
    }

    public static void comb(int idx,int cnt){
        if(cnt == 2){

            int counter = 0;
            for(int i=1;i<=N;i++){
                if(visited[i] == 1){
                    KFC[counter++] = i;
                }
            }
            calc();
        }
        else{
            for(int i=idx;i<=N;i++){
                if(visited[i] == 1)continue;
                visited[i] = 1;
                comb(i+1,cnt+1);
                visited[i] = 0;
            }
        }
    }




}