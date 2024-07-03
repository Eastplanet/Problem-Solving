import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());


        PriorityQueue<Integer> rightQ = new PriorityQueue<>((o1, o2)-> o1-o2);
        PriorityQueue<Integer> leftQ = new PriorityQueue<>((o1, o2)-> o2-o1);
        for(int i=1;i<=N;i++){

            int num = Integer.parseInt(in.readLine());

            // left에 넣고 right에 넣어서 숫자 순서를 맞춤
            leftQ.add(num);
            rightQ.add(leftQ.poll());

            // 크기 맞추기
            while(leftQ.size() - rightQ.size() > 1)rightQ.add(leftQ.poll());
            while(leftQ.size() - rightQ.size() < -1)leftQ.add(rightQ.poll());

            if(i % 2 == 0) System.out.println(leftQ.peek());
            else {
                if(leftQ.size() > rightQ.size()) System.out.println(leftQ.peek());
                else System.out.println(rightQ.peek());
            }
        }


    }
}