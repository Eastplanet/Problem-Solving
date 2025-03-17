import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int L,N;
    public static List<Pos> waterHoles;

    public static void main(String[] args) throws Exception {
        init();

        Collections.sort(waterHoles);

        int boardCnt = 0;
        int board_end = -1;

        for(Pos pos : waterHoles){

            // 새로운 보드를 설치하지 않아도 된다면
            if(board_end >= pos.end){
                continue;
            }

            int start, end;

            // 현재 물 웅덩이에 보드가 아예 없음
            if(board_end < pos.start){
                start = pos.start;
                end = pos.end;
            }
            // 현재 물 웅덩이에 보드가 일부 걸쳐있음
            else{
                start = board_end;
                end = pos.end;
            }

            int cnt = (end - start) / L;
            if((end - start) % L != 0){
                cnt++;
            }

            boardCnt += cnt;
            board_end = start + (L*cnt);
        }

        System.out.println(boardCnt);
    }

    public static void init() throws Exception {
        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        waterHoles = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            waterHoles.add(new Pos(start,end));
        }
    }

    public static class Pos implements Comparable<Pos>{
        int start,end;
        public Pos(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Pos o){
            return this.start - o.start;
        }
    }

}