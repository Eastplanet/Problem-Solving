import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static FWTree tree;

    public static class FWTree{
        long[] arr;
        int size;

        public FWTree(int size){
            this.arr = new long[size+1];
            this.size = size;
        }

        public void update(int idx, long dt){

            while(idx <= size){
                arr[idx] += dt;
                idx = idx + (idx & (-idx));
            }
        }

        public long get(int idx){
            long sum = 0;

            while(idx > 0){
                sum += arr[idx];
                idx = idx - (idx & (-idx));
            }

            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        for(int i=0;i<M;i++){
            command();
        }
    }

    public static void command() throws Exception{
        st = new StringTokenizer(in.readLine());

        int cmd = Integer.parseInt(st.nextToken());
        if(cmd == 1){
            int idx = Integer.parseInt(st.nextToken());
            long num = Long.parseLong(st.nextToken());
            tree.update(idx,num);
        }
        else{
            int num = Integer.parseInt(st.nextToken());
            System.out.println(bs(num));
        }
    }

    public static int bs(int num){
        int start = 1;
        int end = N;

        int result = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;
            if(tree.get(mid) >= num){
                result = Math.min(result, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return result;
    }

    public static void init() throws Exception {

        N = Integer.parseInt(in.readLine());

        tree = new FWTree(N);

        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(st.nextToken());
            tree.update(i, num);
        }

        M = Integer.parseInt(in.readLine());

    }

}