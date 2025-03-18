import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] arr;
    public static List<Integer> LIS;

    public static void main(String[] args) throws Exception {

        init();

        LIS = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(LIS.isEmpty() || arr[i] > LIS.get(LIS.size()-1)){
                LIS.add(arr[i]);
            }
            else{
                // 이진탐색으로 업데이트 위치 탐색
                int findIdx = bs(arr[i]);
                LIS.set(findIdx, arr[i]);
            }
        }

        System.out.println(LIS.size());
    }

    // LIS에서 findNum 이상이면서 가장 작은 숫자를 찾는다.
    public static int bs(int findNum){

        int start = 0;
        int end = LIS.size()-1;

        int findIdx = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;
            if(LIS.get(mid) >= findNum){
                findIdx = Math.min(findIdx, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return findIdx;
    }

    public static void init() throws Exception {

        N = Integer.parseInt(in.readLine());

        arr = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

}