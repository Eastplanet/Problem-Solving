import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,Q;
    public static long[] arr;

    public static void main(String[] args) throws Exception {
        init();

        FT ft = new FT(arr);

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x > y){
                int tmp = x;
                x = y;
                y = tmp;
            }

            // x~y의 합을 구합니다.
            System.out.println(ft.sum(y)-ft.sum(x-1));

            long diff = b - arr[a];
            ft.update(a,diff);
            arr[a] = b;
        }
    }

    public static void init() throws Exception {
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

    }

    public static class FT {
        long[] data;
        int size;

        public FT(long[] arr){
            data = new long[arr.length];
            size = arr.length;

            for(int i=1;i<size;i++){
                update(i,arr[i]);
            }
        }

        public void update(int idx, long diff){
            // 변경 시 Diff 만큼 값들이 변경 됨

            while(idx < size){
                data[idx] += diff;
                idx = idx + (idx & (-idx));
            }
        }

        // 1 ~ idx 까지의 합을 리턴
        public long sum(int idx){
            long total = 0;

            while(idx > 0){
                total += data[idx];
                idx = idx - (idx & (-idx));
            }

            return total;
        }
    }

}