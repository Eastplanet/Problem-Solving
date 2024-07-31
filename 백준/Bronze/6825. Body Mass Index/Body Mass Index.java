import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {

        double weight = Double.parseDouble(in.readLine());
        double height = Double.parseDouble(in.readLine());

        double result = (double)weight/(height*height);
        if(result >= 25){
            System.out.println("Overweight");
        }
        else if(result >= 18.5){
            System.out.println("Normal weight");
        }
        else{
            System.out.println("Underweight");
        }
    }


}