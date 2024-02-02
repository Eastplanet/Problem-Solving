import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class File {
	public String fileName;
	public String fileExtension;
	public static HashMap<String, Integer> Extends;
	public boolean isPercept = false;

	public File(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '.') {
				this.fileName = name.substring(0, i);
				this.fileExtension = name.substring(i + 1, name.length());
				break;
			}
		}
	}

}

public class Main {

	static class FileExtension {
		String[] arr;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<File> files = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			File f = new File(in.readLine());
			files.add(f);
		}

		File.Extends = new HashMap<>();
		for (int i = 0; i < M; i++) {
			String ex = in.readLine();
			File.Extends.put(ex, 1);
		}

		for (int i = 0; i < files.size(); i++) {
			if (File.Extends.containsKey(files.get(i).fileExtension)) {
				files.get(i).isPercept = true;
			}

		}

		Collections.sort(files, (e1, e2) -> {
			if (e1.fileName.equals(e2.fileName)) {
				if (e1.isPercept == true && e2.isPercept == false) {
					return -1;
				} else if (e1.isPercept == false && e2.isPercept == true) {
					return 1;
				} else {
					return e1.fileExtension.compareTo(e2.fileExtension);
				}
			} else {
				return e1.fileName.compareTo(e2.fileName);
			}
		});

		for (int i = 0; i < N; i++) {
			sb.append(files.get(i).fileName + "." + files.get(i).fileExtension + "\n");
		}

		System.out.println(sb);

	}
}