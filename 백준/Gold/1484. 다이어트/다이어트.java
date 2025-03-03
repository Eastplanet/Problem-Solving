import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(in.readLine());

        int left = 1;
        int right = 2;

        List<Integer> list = new ArrayList<>();

        while(true){
            if(Math.pow(right,2) - Math.pow(right-1,2) > N){
                break;
            }

            int val = (int)(Math.pow(right,2) - Math.pow(left,2));
            if(val == N){
                list.add(right);
                right++;
            }
            else if(val < N){
                right++;
            }
            else{
                left++;
            }
        }

        if(list.isEmpty()){
            System.out.println(-1);
        }
        else{
            for(int next : list){
                System.out.println(next);
            }
        }
    }


}