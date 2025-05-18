
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int R,C;
    public static char[][] arr;
    public static int[][] visited;
    public static Pair[][] prev;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

       init();

       Queue<int[]> q = new ArrayDeque<>();
       q.add(new int[]{0,0});
       visited[0][0] = 1;
       prev[0][0] = new Pair(-1,-1);

       while(!q.isEmpty()){
           int[] curr = q.poll();

           if(curr[0] == R-1 && curr[1] == C-1){
               break;
           }

           for(int i=0;i<4;i++){
               int gox = curr[1] + dx[i];
               int goy = curr[0] + dy[i];

               if(gox < 0 || gox >= C || goy < 0 || goy >= R || visited[goy][gox] == 1 || arr[goy][gox] == '*'){
                   continue;
               }

               visited[goy][gox] = 1;
               q.add(new int[]{goy,gox});
               prev[goy][gox] = new Pair(curr[1],curr[0]);


           }
       }

       List<Pair> path = new ArrayList<>();

       Pair curr = new Pair(C-1,R-1);

       while(curr.x != -1 && curr.y != -1){
           path.add(curr);
           curr = prev[curr.y][curr.x];
       }

       for(int i=path.size()-1;i>=0;i--){
           System.out.println((path.get(i).y+1) + " " + (path.get(i).x+1));
       }

    }

    public static void init() throws Exception {
        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new int[R][C];
        prev = new Pair[R][C];

        for(int i=0;i<R;i++){
            String tmp = in.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] = tmp.charAt(j);
            }
        }

    }

    public static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}