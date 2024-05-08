import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] inOrder;
	static int[] inOrderNumberToIdx;
	static int[] postOrder;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		

		inOrder = new int[N];
		inOrderNumberToIdx = new int[100001];
		postOrder = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderNumberToIdx[inOrder[i]] = i;
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		recv(0, N - 1, 0, N - 1);

		// 포스트 오더의 마지막 -> 항상 Root

		// 포스트 오더 이전은 왼쪽 자식? 오른쪽 자식?
		//

		// 1. 포스트 오더로 Root를 찾는다
		// 2. 인오더에서 Root의 오른쪽 범위는 오른쪽 자식이고
		// 3. 주어진 범위에서 포스트오더의 가장 마지막은 Root이다.
		// 4. 인오더에서 Root의 범위 -> 재귀 가능?

		// 2. 인오더에서 Root의 왼 쪽 범위는 왼 쪽 자식이다.

		// 포스트 오더 ->Root의 위치를

		// 1. 포스트오더에서 Root를 찾는다. Inorder에서 어디에 있는지 찾는다.(인덱싱)
		// Inorder의 범위에서 Root의 왼쪽에 있는 노드들의 수와 오른쪽에 있는 노드들의 수를 기억한다.
		// PostOrder의 범위에서 앞에서 왼쪽에 있는 노드들의 수 만큼은 왼쪽의 자식이고
		// PostOrder의 범위에서 그다음 오른쪽에 있는 노드들의 수 만큼은 오른쪽의 자식이다.
		// 왼쪽의 자식들의 범위만큼 재귀를 돌린다. -> 오른쪽의 자식들의 범위만큼 재귀를 돌린다.
		//
		// 재귀?
	}

	// PostOrder 기준 범위를 넘긴다.
	static void recv(int PostStart, int Postend,int InStart,int InEnd) {
		//start~end로 이루어진 부분트리에서 Root를 출력
		int root = postOrder[Postend];
		System.out.print(root+" ");
		
		if(PostStart == Postend) {
			return;
		}
		
		// inOrder에서 루트의 Idx를 가져옴
		int rootIdx = inOrderNumberToIdx[root];
		// rootIdx를 이용해서 왼쪽 트리와 오른쪽 트리 크기를 알아냄
		int leftTreeSize = rootIdx - InStart;
		int rightTreeSize = InEnd - rootIdx;
		
		
		//왼쪽 트리 먼저 방문, 인덱스와 left,right로  범위를 잘 조정한다..
		if(leftTreeSize != 0) {
			recv(PostStart,PostStart+leftTreeSize-1
					,InStart,InStart+leftTreeSize-1);
		}
		
		//오른쪽 트리 먼저 방문
		if(rightTreeSize != 0) {
			recv(PostStart+leftTreeSize,PostStart+leftTreeSize+rightTreeSize-1
					,InStart+leftTreeSize+1,InStart+leftTreeSize+rightTreeSize);
		}
		
	}
}