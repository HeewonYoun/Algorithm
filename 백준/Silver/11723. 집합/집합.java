import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int x;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());

		ArrayList<Integer> s = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String d = st.nextToken();
			if(!d.equals("all")&&!d.equals("empty")) {
				x = Integer.parseInt(st.nextToken());
			}

			switch (d) {
			case "add":
				if (!s.contains(x)) {
					s.add(x);
				}
				break;
			case "remove":
				if (s.contains(x)) {
					s.remove(s.indexOf(x));
				}
				break;
			case "check":
				if (s.contains(x)) {
					bw.write("1");
					bw.newLine();
				} else {
					bw.write("0");
					bw.newLine();
				}
				break;
			case "toggle":
				if (s.contains(x)) {
					s.remove(s.indexOf(x));
				} else {
					s.add(x);
				}
				break;
			case "all":
				s.clear();
				for (int j = 1; j < 21; j++) {
					s.add(j);
				}
				break;
			case "empty":
				s.clear();
				break;
			}
		}
		bw.flush();
	}
}
