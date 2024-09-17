import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[][] invalidCombi;
    static int result;
    static int[] select;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[3];

        invalidCombi = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            invalidCombi[a][b] = 1;
            invalidCombi[b][a] = 1;
        }

        makeComb(0,1);

        System.out.println(result);
    }

    public static void makeComb(int count, int idx){

        if(count == 3){
            result++;
            return;
        }

        for(int i=idx;i<=N;i++){
            if(!invalidCheck(count,i)){
                continue;
            }

            select[count] = i;
            makeComb(count+1, i+1);
        }

    }

    public static boolean invalidCheck(int count,int now){
        if(count == 1) {
            if(invalidCombi[select[0]][now] == 1)return false;
        }
        if(count == 2){
            if(invalidCombi[select[0]][now] == 1)return false;
            if(invalidCombi[select[1]][now] == 1)return false;
        }

        return true;
    }

}