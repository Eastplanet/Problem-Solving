
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] arr,visited;
    public static int start;

    public static void main(String[] args) throws Exception {

        init();

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;


        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;

            int next = curr + arr[curr];
            if(canGo(next)){
                q.add(next);
                visited[next] = 1;
            }

            next = curr - arr[curr];

            if(canGo(next)){
                q.add(next);
                visited[next] = 1;
            }
        }

        System.out.println(cnt);

    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        visited = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        start =Integer.parseInt(in.readLine()) - 1;

    }

    public static boolean canGo(int next){
        if(next < 0 || next >= N || visited[next] == 1){
            return false;
        }
        return true;
    }



}