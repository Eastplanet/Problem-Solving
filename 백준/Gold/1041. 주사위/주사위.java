import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] arr;
    public static long[] typeCnt;
    public static int[] typeToMinVal;

    public static int[][] zero = {
            {1,1,1,1,1,0},
            {1,1,1,1,0,1},
            {1,1,1,0,1,1},
            {1,1,0,1,1,1},
            {1,0,1,1,1,1},
            {0,1,1,1,1,1}
    };

    public static int[][] one = {
            {1,0,0,0,0,0},
            {0,1,0,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,0,1}
    };

    public static int[][] two = {
            {1,1,0,0,0,0},
            {1,0,1,0,0,0},
            {1,0,0,1,0,0},
            {1,0,0,0,1,0},

            {0,1,1,0,0,0},
            {0,1,0,1,0,0},
            {0,1,0,0,0,1},

            {0,0,1,0,1,0},
            {0,0,1,0,0,1},

            {0,0,0,1,1,0},
            {0,0,0,1,0,1},

            {0,0,0,0,1,1}
    };

    public static int[][] three = {
            {1,1,1,0,0,0},
            {1,1,0,1,0,0},
            {1,0,1,0,1,0},
            {1,0,0,1,1,0},

            {0,1,1,0,0,1},
            {0,1,0,1,0,1},

            {0,0,1,0,1,1},

            {0,0,0,1,1,1}
    };

    public static void main(String[] args) throws Exception {

        init();
        cntType();

        // 타입 별로 가장 작은 숫자를 저장한다.
        typeToMinVal = new int[4];
        for(int i=0;i<4;i++){
            typeToMinVal[i] = Integer.MAX_VALUE;
        }


        calcMinValue(0,zero);
        calcMinValue(1,one);
        calcMinValue(2,two);
        calcMinValue(3,three);

        long result = 0;
        for(int i=0;i<4;i++){
            result += (long)typeCnt[i] * typeToMinVal[i];
        }

        System.out.println(result);
    }

    public static void calcMinValue(int idx, int[][] comb){
        for(int[] set : comb){
            int sum = 0;
            for(int i=0;i<set.length;i++){
                if(set[i] == 1){
                    sum += arr[i];
                }
            }
            typeToMinVal[idx] = Math.min(typeToMinVal[idx], sum);
        }
    }

    public static void cntType(){
        if(N == 1){
            typeCnt[0] = 1;
            return;
        }

        typeCnt[1] = ((long)N-2) * (N-2) + (long) (N - 1) *(N-2)*4;
        typeCnt[2] = ((long)N-1) * 4 + ((long)N-2) * 4;
        typeCnt[3] = 4;
    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        arr = new int[6];
        st = new StringTokenizer(in.readLine());
        for(int i=0;i<6;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        typeCnt = new long[4];
    }

}