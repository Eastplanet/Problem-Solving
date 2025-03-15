import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    // arr[i][j] = 0 -> 흰색 , 1-> 검은색
    public static int[][] arr, flipCnt;
    public static int[] selected;
    public static int minClick;


    public static void main(String[] args) throws Exception{

        int P = Integer.parseInt(in.readLine());

        while(P-- > 0){
            init();
            makeComb(0,0);
            System.out.println(minClick);
        }
    }

    public static boolean isPossible(){

        flipCnt = new int[3][3];

        // 버튼을 눌러본다.
        for(int i=0;i<9;i++){
            if(selected[i] == 1){
                int y = i/3;
                int x = i%3;
                // [y][x] 위치와 상하좌우를 한번씩 뒤집는다.
                BFS(x,y);
            }
        }

        boolean isSame = true;
        // 정답과 같은 지 확인한다.
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j] != flipCnt[i][j]%2){
                    isSame = false;
                }
            }
        }

        return isSame;
    }

    // x,y좌표를 눌렀을 때 주변을 카운트한다.
    public static void BFS(int x,int y){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        flipCnt[y][x]++;

        for(int i=0;i<4;i++){
            int gox = x + dx[i];
            int goy = y + dy[i];

            if(gox < 0 || gox >= 3 || goy < 0 || goy >= 3){
                continue;
            }

            flipCnt[goy][gox]++;
        }
    }

    public static void makeComb(int depth, int cnt){

        // 9개의 보드에 대해 누른다/안누른다 선택 완료
        if(depth == 9){
            //해당 조합에 대해 시뮬레이션 해본다.
            if(isPossible()){
                minClick = Math.min(minClick,cnt);
            }
            return;
        }


        // 누르지 않는다.
        selected[depth] = 0;
        makeComb(depth+1,cnt);
        //누른다
        selected[depth] = 1;
        makeComb(depth+1,cnt+1);

    }

    public static void init() throws Exception{

        arr = new int[3][3];
        selected = new int[9];
        minClick = Integer.MAX_VALUE;

        for(int i=0;i<3;i++) {
            String tmp = in.readLine();
            for (int j = 0; j < 3; j++) {
                if (tmp.charAt(j) == '.') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

    }


}