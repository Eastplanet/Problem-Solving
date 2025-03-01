import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N, K;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int total = 0;

        while(true){
            // 2진 표현 시 1의 개수가 K를 이하이면 종료
            if(cntOne(N) <= K){
                break;
            }

            // 얼마를 더해야 1이 없어지는 지 구한다
            int num = cntZero(N);
            N += 1 << num;
            total += 1 << num;
        }

        System.out.println(total);

    }

    // 2진으로 표현했을 때 뒤에서부터 연속된 0의 개수를 센다
    // ex 3 -> 011 , cntZero(3) = 0
    // ex 4 -> 100 , cntZero(4) = 2
    public static int cntZero(int num){

        int cnt = 0;
        while(true){
            if((num & (1 << cnt)) == (1 << cnt)){
                return cnt;
            }
            cnt++;
        }
    }

    // 2진으로 표현했을 때, 1의 개수
    // bit는 최대 30을 넘지 않는다.
    // 6 -> 0000000110  , cntOne(6) = 2
    public static int cntOne(int num){

        int cnt = 0;
        for(int i=0;i<=30;i++){

            if((num & (1 << i)) == (1 << i)){
                cnt++;
            }
        }

        return cnt;
    }
}