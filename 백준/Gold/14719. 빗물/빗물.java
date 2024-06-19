import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R,C;
    // 1 블록, 2 빗물이 쌓일 수 없음
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        ans = R*C;

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<C;i++){
            int y = Integer.parseInt(st.nextToken());
            for(int j=0;j<y;j++) {
                map[j][i] = 1;
                ans--;
            }
        }

        for(int i=0;i<R;i++){
            fill(i,1);
            fill(i,-1);
        }

        System.out.println(ans);


    }

    static void fill(int y, int dx){

        int x;
        if(dx == 1)x = 0;
        else x = C-1;

        while(true){
            if(x < 0 || x >= C)break;
            if(map[y][x] != 0) break;
            map[y][x] = 2;
            ans --;
            x += dx;
        }
    }



}