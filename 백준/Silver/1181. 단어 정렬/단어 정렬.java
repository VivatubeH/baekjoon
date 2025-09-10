import java.io.*;
import java.util.*;

public class Main {
	public static Set<String> set = new HashSet<>();
	public static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		input();
		service();
		output();
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
	}
	
	public static void service() {
		list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<>() {
			public int compare(String s1, String s2) {
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				}
				return s1.compareTo(s2);
			}
		});
	}
	
	public static void output() throws IOException {
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		for (String str : list) {
			br.write(str);
			br.write("\n");
		}
		br.flush();
	}
}
