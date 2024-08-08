import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(in.readLine());

        for(int i=0;i<N;i++){
            int max = 0;
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<5;j++) {

                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }
            System.out.println("Case #"+ (i+1)+": "+max);
        }

    }


}