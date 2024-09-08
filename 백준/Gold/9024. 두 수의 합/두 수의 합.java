import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;

    static int[] arr;
    static int resultCnt;
    static int resultMin;

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(in.readLine());

        while(t-- > 0){

            resultMin = Integer.MAX_VALUE;
            resultCnt = 0;

            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for(int i=0;i<N-1;i++){
                BS(i,i+1);
            }

            System.out.println(resultCnt);
        }
    }

    static void BS(int markingPos, int startPos){

        int min = Integer.MAX_VALUE;
        int minCnt = -1;

        int start = startPos;
        int end = N-1;

        while(start <= end){

            int mid = (start + end)/2;

            int hap = arr[markingPos] + arr[mid];
            int diff = K - hap;

            if(Math.abs(diff) < min){
                min = Math.abs(diff);
                minCnt = 1;
            }
            else if(Math.abs(diff) == min){
                minCnt++;
            }

            if(K < hap){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        if(resultMin > min){
            resultMin = min;
            resultCnt = minCnt;
        }
        else if(resultMin == min){
            resultCnt += minCnt;
        }
    }


}