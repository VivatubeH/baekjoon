import java.io.*;
import java.util.*;

public class Main {
	public static List<Member> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		input();
		service();
		output();
	}
	
	public static void input() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int age = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				
				Member member = new Member(i, age, name);
				list.add(member);
			}
		}
	}
	
	public static void service() throws IOException {
		Collections.sort(list);
	}
	
	public static void output() throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			for (Member member : list) {
				bw.write(member.getAge() + " " + member.getName());
				bw.write("\n");
			}
			bw.flush();
		}
	}
}

class Member implements Comparable<Member> {
	private int order;
	private int age;
	private String name;
	
	public Member(int order, int age, String name) {
		this.order = order;
		this.age = age;
		this.name = name;
	}
	
	public int getOrder() {
		return order;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Member member) {
		if (this.age != member.getAge()) {
			return this.age - member.getAge();
		} 
		return this.order - member.getOrder();
	}
}
