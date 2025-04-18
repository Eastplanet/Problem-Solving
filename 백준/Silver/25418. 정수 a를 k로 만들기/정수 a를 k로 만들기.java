
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int A,K;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int[] visited = new int[1_000_001];

        visited[A] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{A,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == K){
                System.out.println(curr[1]);
                return;
            }

            int next = curr[0]+1;
            if(next <= 1_000_000 && visited[next] == 0){
                visited[next] = 1;
                q.add(new int[]{next, curr[1]+1});
            }

            next = curr[0] *2;
            if(next <= 1_000_000 && visited[next] == 0){
                visited[next] = 1;
                q.add(new int[]{next,curr[1]+1});
            }
        }

    }



}