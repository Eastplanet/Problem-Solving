import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws Exception{

        while(true){
            int N = Integer.parseInt(in.readLine());

            if(N == 0){
                break;
            }

            List<String> leftDeque = new ArrayList<>();
            List<String> rightDeque = new ArrayList<>();

            if(N % 2 == 0){
                for(int i=0;i<N/2;i++){
                    leftDeque.add(in.readLine());
                }
                for(int i=0;i<N/2;i++){
                    rightDeque.add(in.readLine());
                }
            }
            else {
                for(int i=0;i<=N/2;i++){
                    leftDeque.add(in.readLine());
                }
                for(int i=0;i<N/2;i++){
                    rightDeque.add(in.readLine());
                }
            }

            for(int i=0;i<rightDeque.size();i++){
                System.out.println(leftDeque.get(i));
                System.out.println(rightDeque.get(i));
            }

            if(N%2 == 1){
                System.out.println(leftDeque.get(leftDeque.size()-1));
            }
        }
    }






}