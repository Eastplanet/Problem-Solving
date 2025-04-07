
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,K;
    public static int[][] arr, visited;


    public static void main(String[] args) throws Exception {

        init();

        st = new StringTokenizer(in.readLine());

        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        Virus[] virusArr = new Virus[1001];
        for(int i=0;i<1001;i++){
            virusArr[i] = new Virus(i);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 0){
                    continue;
                }
                virusArr[arr[i][j]].add(i,j);
            }
        }




        int time = 0;
        while(time < S){

            for(int i=1;i<1001;i++){
                virusArr[i].BFS();
            }

            time++;
        }

        System.out.println(arr[X-1][Y-1]);

    }

    public static class Virus {
        int num;
        Queue<int[]> queue;

        public Virus(int num){
            this.num = num;
            this.queue = new ArrayDeque<>();
        }

        public void add(int x, int y){
            this.queue.add(new int[]{x,y});
        }

        public void BFS(){

            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};

            Queue<int[]> next = new ArrayDeque<>();

            while(!queue.isEmpty()){
                int[] curr = queue.poll();

                for(int i=0;i<4;i++){
                    int gox = curr[0] + dx[i];
                    int goy = curr[1] + dy[i];

                    if(gox < 0 || gox >= N || goy < 0 || goy >= N || visited[gox][goy] == 1){
                        continue;
                    }

                    visited[gox][goy] = 1;
                    arr[gox][goy] = this.num;
                    next.add(new int[]{gox,goy});
                }
            }

            this.queue = next;
        }
    }

    public static void init() throws Exception {

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

}