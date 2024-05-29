import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String tmp;
		while((tmp = in.readLine()) != null) {
			arr.add(Integer.parseInt(tmp));
		}
		
		Node root = makeTree(0,arr.size()-1);
		
		postOrder(root);
		
		
	}
	
	static void postOrder(Node node) {
		
		if(node.left != null)postOrder(node.left);
		if(node.right != null)postOrder(node.right);
		
		System.out.println(node.num);
	}
	
	// subtree의 루트를 반환한
	static Node makeTree(int start,int end) {
		
		//루트는 start이다.
		Node subRoot = new Node();
		subRoot.num = arr.get(start);
		
		if(start == end) return subRoot;
		
		int leftEnd = end;
		//왼쪽 자식을 만들도록 재귀
		for(int i=start+1;i<=end;i++) {
			if(arr.get(i)>arr.get(start)) {
				leftEnd = i-1;
				break;
			}
		}
		
		if(leftEnd == start) {
			subRoot.left = null;
		}
		else {
			subRoot.left = makeTree(start+1, leftEnd);
		}
		
		int rightStart = leftEnd + 1;
		if(rightStart <= end) {
			subRoot.right = makeTree(rightStart, end);
		}
		
		
		return subRoot;
		
	}
	
	static class Node{
		int num;
		Node left,right;
	}
}