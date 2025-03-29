
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] indegree, processTime;
    public static int[][] arr;
    public static List<Integer>[] adj,prevAdj;

    public static void main(String[] args) throws Exception {

        init();

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            int maxPrevTime = 0;
            for(int prev : prevAdj[curr]){
                // 이전 레벨의 processTime과 여기로 전송하기 까지의 시간을 계산한다.
                int prevTime = processTime[prev];
                int transferTime = (int)Math.pow(prev-curr,2);
                maxPrevTime = Math.max(maxPrevTime, prevTime + transferTime);
            }
            processTime[curr] = maxPrevTime + arr[curr][1];

            for(int next : adj[curr]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        int completeTime = 0;
        for(int time : processTime){
            completeTime = Math.max(completeTime,time);
        }
        System.out.println(completeTime);
    }


    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());

        arr = new int[N+1][2];
        indegree = new int[N+1];
        processTime = new int[N+1];

        adj = new ArrayList[N+1];
        prevAdj = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
            prevAdj[i] = new ArrayList<>();
        }

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // indegree 설정, 인접 행렬 설정
        for(int i=1;i<=N;i++) {
            for(int j=i+1;j<=N;j++){

                if(arr[i][0] == arr[j][0] - 1){
                    indegree[j]++;
                    adj[i].add(j);
                    prevAdj[j].add(i);
                }
                else if(arr[i][0] == arr[j][0] + 1){
                    indegree[i]++;
                    adj[j].add(i);
                    prevAdj[i].add(j);
                }
            }
        }
    }
}