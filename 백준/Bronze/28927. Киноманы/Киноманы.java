import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {

        int sum1 = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        sum1= a*3+b*20+c*120;
        int sum2 = 0;
        StringTokenizer st2 = new StringTokenizer(in.readLine());
        a = Integer.parseInt(st2.nextToken());
        b= Integer.parseInt(st2.nextToken());
        c= Integer.parseInt(st2.nextToken());
        sum2= a*3+b*20+c*120;

        if(sum1<sum2){
            System.out.println("Mel");
        }
        else if(sum1 > sum2){
            System.out.println("Max");
        }
        else{
            System.out.println("Draw");
        }
    }


}