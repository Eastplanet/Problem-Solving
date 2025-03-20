import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static List<int[]> list;
    public static List<Integer> LIS;
    public static int[] index;



    public static void main(String[] args) throws Exception {

        init();

        // sort
        list.sort((int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        });

        // LIS
        for(int i=0;i<list.size();i++) {

            // 새롭게 추가
            if(LIS.isEmpty() || list.get(i)[1] > LIS.get(LIS.size()-1)) {
                LIS.add(list.get(i)[1]);
                index[i] = LIS.size()-1;
            }
            else {
                int idx = findIdx(list.get(i)[1]);
                LIS.set(idx, list.get(i)[1]);
                index[i] = idx;
            }
        }

        // 정답으로 변환
        List<Integer> check = new ArrayList<>();

        int findNum = LIS.size()-1;
        for(int i=index.length-1;i>=0;i--){
            if(index[i] == findNum){
                check.add(list.get(i)[1]);
                findNum--;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int num : check){
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int[] arr : list){
            if(!set.contains(arr[1])){
                result.add(arr[0]);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int i : result){
            System.out.println(i);
        }


    }

    public static int findIdx(int num) {

        int start = 0;
        int end = LIS.size()-1;
        int ans = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(LIS.get(mid) >= num){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }


    public static void init() throws Exception{

        N = Integer.parseInt(in.readLine());

        list = new ArrayList<>();
        LIS = new ArrayList<>();
        index = new int[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a,b});
        }
    }









}