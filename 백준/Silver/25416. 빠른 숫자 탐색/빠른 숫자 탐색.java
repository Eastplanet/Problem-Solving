
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[][] arr,visited;
    public static int[] end;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

        init();

        st = new StringTokenizer(in.readLine());

        Queue<int[]> q = new ArrayDeque<>();

        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        q.add(new int[]{startY,startX,0});
        visited[startY][startX] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == end[0] && curr[1] == end[1]){
                System.out.println(curr[2]);
                return;
            }

            for(int i=0;i<4;i++){
                int gox = curr[1] + dx[i];
                int goy =  curr[0] + dy[i];

                if(gox < 0 || gox >= N || goy < 0 || goy >= N || visited[goy][gox] == 1 || arr[goy][gox] == -1){
                    continue;
                }

                visited[goy][gox] = 1;
                q.add(new int[]{goy,gox, curr[2] + 1});
            }

        }

        System.out.println(-1);
    }

    public static void init() throws Exception{
        N = 5;

        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());

            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    end = new int[]{i,j};
                }
            }
        }
    }

}