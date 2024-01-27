package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Student {
	int classNum;
	String name;

	public Student(String name) {
		this.name = name;
	}
}

class Ban {
	int classNum;
	List<Student> students = new ArrayList<>();
}

public class BOJ_23056 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Ban> bans = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			Ban temp = new Ban();
			temp.classNum = i;
			bans.add(temp);
		}

		while (true) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if (num == 0)
				break;

			if(bans.get(num-1).students.size() >= M)continue;
			
			bans.get(num-1).students.add(new Student(name));
		}

		for (int i = 0; i < N; i++) {
			// 반 안의 학생들 정렬
			bans.get(i).students.sort((e1, e2) -> {
				if (e1.name.length() == e2.name.length()) {
					return e1.name.compareTo(e2.name);
				}
				return e1.name.length() - e2.name.length();
			});
		}

		bans.sort((e1, e2) -> {
			if (e1.classNum % 2 == e2.classNum % 2) {
				return e1.classNum - e2.classNum;
			} else {
				return (e2.classNum % 2) - (e1.classNum % 2);
			}
		});

		for (Ban b : bans) {
			for (int i = 0; i < b.students.size(); i++) {
				
				sb.append(b.classNum).append(" ").append(b.students.get(i).name).append("\n");
			}
		}
		System.out.print(sb);
	}
}
