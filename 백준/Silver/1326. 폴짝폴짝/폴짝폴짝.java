
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N, start, end;
    public static int[] arr;

    public static void main(String[] args) throws Exception {

        init();

        int[] visited = new int[N];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{start,0});
        visited[start] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == end){
                System.out.println(curr[1]);
                return;
            }

            for(int i=1;i<=N;i++){

                int nextLeftPos = curr[0] - arr[curr[0]]*i;
                int nextRightPos = curr[0] + arr[curr[0]]*i;

                // 둘다 만족 안할 시 종료
                if(nextLeftPos < 0 && nextRightPos >= N){
                    break;
                }

                if(nextLeftPos >= 0){
                    if(visited[nextLeftPos] == 0){
                        visited[nextLeftPos] = 1;
                        q.add(new int[]{nextLeftPos, curr[1]+1});
                    }
                }
                if(nextRightPos < N){
                    if(visited[nextRightPos] == 0){
                        q.add(new int[]{nextRightPos, curr[1]+1});
                    }
                }

            }
        }

        System.out.println(-1);

    }

    public static void init() throws Exception {

        N = Integer.parseInt(in.readLine());
        arr = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        start = Integer.parseInt(st.nextToken());
        start--;
        end = Integer.parseInt(st.nextToken());
        end--;
    }

}