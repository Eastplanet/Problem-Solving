
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M,T;
    public static int[][] arr;
    public static int[][][] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};



    public static void main(String[] args) throws Exception {

        init();

        Queue<Node> q = new ArrayDeque<>();
        visited[0][0][0] = 1;
        q.add(new Node(0,0,0,0));

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.y == N-1 && curr.x == M-1){
                if(T < curr.dist){
                    break;
                }
                System.out.println(curr.dist);
                return;
            }

            if(arr[curr.y][curr.x] == 2){
                curr.sword = 1;
            }

            for(int i=0;i<4;i++){
                int gox = curr.x + dx[i];
                int goy = curr.y + dy[i];

                if(gox < 0 || gox >= M || goy < 0 || goy >= N || visited[goy][gox][curr.sword] == 1){
                    continue;
                }

                if(curr.sword == 0 && arr[goy][gox] == 1){
                    continue;
                }

                visited[goy][gox][curr.sword] = 1;
                q.add(new Node(goy,gox,curr.sword,curr.dist+1));
            }
        }

        System.out.println("Fail");

    }

    public static class Node {
        int y,x,sword,dist;
        public Node(int y,int x,int sword,int dist){
            this.y = y;
            this.x = x;
            this.sword = sword;
            this.dist = dist;
        }
    }



    public static void init() throws Exception {

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new int[N][M][2];

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}