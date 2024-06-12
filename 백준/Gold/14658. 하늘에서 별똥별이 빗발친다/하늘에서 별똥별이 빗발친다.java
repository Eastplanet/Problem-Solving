import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,L,K;
    static List<int[]> stars;
    static int maxRefCnt = 0;


    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x,y});
        }


        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                dropStarsToMatrixAndGetReflexStarCnt(stars.get(i)[0],stars.get(j)[1]);
            }
        }

        System.out.println(K-maxRefCnt);

    }

    static void dropStarsToMatrixAndGetReflexStarCnt(int x,int y){

//       if(!canInstallMatrix(x,y)) return;


//        System.out.println("x = "+x+" y = "+y);

        int xStart = x;
        int xEnd = x+L;
        int yStart = y;
        int yEnd = y+L;

        int cnt = 0;
        for(int i=0;i<K;i++){
            int[] star = stars.get(i);
            if(xStart <= star[0] && star[0] <= xEnd &&
               yStart <= star[1] && star[1] <= yEnd){
                cnt ++;
            }
        }

        maxRefCnt = Math.max(maxRefCnt, cnt);
    }

    static boolean canInstallMatrix(int x,int y){
        if(x<0 || x+L>N || y<0 || y+L>M)return false;
        return true;
    }


}