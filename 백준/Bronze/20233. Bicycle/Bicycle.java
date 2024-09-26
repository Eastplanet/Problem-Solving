import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());

        int time1 = T-30;
        if(time1 <= 0){
            time1 = a;
        }
        else{
            time1 = (T-30)*21*x+a;
        }

        int time2 = T-45;
        if(time2 <= 0){
            time2 = b;
        }
        else{
            time2 = (T-45)*21*y+b;
        }

        System.out.println(time1 +" "+time2);
    }



}