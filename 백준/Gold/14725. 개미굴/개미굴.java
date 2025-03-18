import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(in.readLine());

        Node root = new Node(-1, null);

        // 방읆 만든다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());

            int K = Integer.parseInt(st.nextToken());
            Node now = root;

            // 현재 위치에서 해당 이름이 존재하느 지 찾는다. 없다면 만들고 다음 방으로 간다.
            for(int j=0;j<K;j++){
                String food = st.nextToken();
                now = now.findNameIfNotGenerate(food);
            }
        }

        searchTree(root);

    }

    public static void searchTree(Node now){

        // 이름을 출력한다.
        if(now.name != null){
            int depth = now.depth *2;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<depth;i++){
                sb.append("-");
            }
            System.out.println(sb.toString() + now.name);
        }

        // list를 이름 순으로 정렬한다
        Collections.sort(now.child);

        for(Node next : now.child){
            searchTree(next);
        }
    }


    public static class Node implements Comparable<Node>{
        int depth;
        String name;
        List<Node> child;

        public Node(int depth, String name){
            this.depth = depth;
            this.name = name;
            this.child = new ArrayList<>();
        }

        // 자식중에서 name이 있는 지 찾고 없다면 생성한다.
        public Node findNameIfNotGenerate(String name){

            for(Node node : child){
                if(name.equals(node.name)){
                    return node;
                }
            }

            Node node = new Node(this.depth +1, name);
            child.add(node);
            return node;
        }

        @Override
        public int compareTo(Node o){
            return this.name.compareTo(o.name);
        }
    }

}