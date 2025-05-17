
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int R,C;
    public static char[][] arr;
    public static int[][] visited;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(in.readLine());

        while(T-- > 0){
            init();

            Queue<int[]> q = new ArrayDeque<>();
            visited[0][0] = 1;
            q.add(new int[]{0,0,1});


            while(!q.isEmpty()){
                int[] curr = q.poll();

                if(curr[0] == R-1 && curr[1] == C-1){
                    System.out.println(curr[2]);
                    break;
                }

                int[][] move = getDt(arr[curr[0]][curr[1]]);
                int[] dy = move[0];
                int[] dx = move[1];
                for(int i=0;i<dy.length;i++){
                    int goy = curr[0] + dy[i];
                    int gox = curr[1] + dx[i];

                    if(gox < 0 || gox >= C || goy < 0 || goy >= R || visited[goy][gox] == 1 || arr[goy][gox] == '*'){
                        continue;
                    }

                    visited[goy][gox] = 1;
                    q.add(new int[]{goy,gox,curr[2] +1});
                }
            }
            if(visited[R-1][C-1] == 0){
                System.out.println(-1);
            }
        }



    }

    public static void init() throws Exception {
        R = Integer.parseInt(in.readLine());
        C = Integer.parseInt(in.readLine());

        arr = new char[R][C];
        for(int i=0;i<R;i++){
            String tmp = in.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] = tmp.charAt(j);
            }
        }

        visited = new int[R][C];
    }


    public static int[][] getDt(char c){
        int[][] result;

        if(c == '*'){
            return new int[][]{{0,0}};
        }

        if(c == '+'){
            result = new int[][]{
                    {0,0,1,-1},
                    {1,-1,0,0}
            };
        }
        else if(c == '-'){
            result = new int[][]{
                    {0,0},
                    {1,-1}
            };
        }
        else{
            result = new int[][]{
                    {1,-1},
                    {0,0}
            };
        }

        return result;
    }

}