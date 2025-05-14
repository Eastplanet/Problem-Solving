
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String A = in.readLine();
        String B = in.readLine();

        int[][] arr = new int[A.length()+1][B.length()+1];

        for(int i=1;i<=A.length();i++){

            for(int j=1;j<=B.length();j++){
                arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);

                if(A.charAt(i-1) == B.charAt(j-1)){
                    arr[i][j] = Math.max(arr[i-1][j-1]+1,arr[i][j]);
                }
            }
        }

        System.out.println(arr[A.length()][B.length()]);
    }
}