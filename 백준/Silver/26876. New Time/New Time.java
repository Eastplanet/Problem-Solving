
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] start,end;

    public static void main(String[] args) throws Exception {
        init();

        int[][] visited = new int[25][61];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == end[0] && curr[1] == end[1]){
                System.out.println(curr[2]);
                return;
            }

            int nextH = (curr[0] + 1) %24;
            if(visited[nextH][curr[1]] == 0){
                visited[nextH][curr[1]] = 1;
                q.add(new int[]{nextH, curr[1], curr[2] +1});
            }

            int nextM = (curr[1] + 1)%60 ;
            if(nextM == 0){
                curr[0]++;
                if(curr[0] == 24){
                    curr[0] = 0;
                }
            }
            if(visited[curr[0]][nextM] == 0){
                visited[curr[0]][nextM] = 1;
                q.add(new int[]{curr[0], nextM, curr[2] + 1});
            }
        }

    }

    public static void init() throws Exception {
        String tmp = in.readLine();
        String[] arr = tmp.split(":");

        start = new int[]{Integer.parseInt(arr[0]),Integer.parseInt(arr[1])};

        tmp = in.readLine();
        arr = tmp.split(":");

        end = new int[]{Integer.parseInt(arr[0]),Integer.parseInt(arr[1])};
    }
}