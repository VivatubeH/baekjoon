import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> students = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String[] token = br.readLine().split(" ");
			
			String name = token[0];
			int day = Integer.valueOf(token[1]);
			int month = Integer.valueOf(token[2]);
			int year = Integer.valueOf(token[3]);
			
			students.add(new Student(name, day, month, year));
		}
		
		// 나이 많은 사람을 뒤로 보내야 함
		// 1. year이 작을 수록
		// 2. month가 작을 수록
		// 3. day가 작을 수
		Collections.sort(students, (s1, s2) -> {
			if (s1.year != s2.year) return s2.year - s1.year;
			if (s1.month != s2.month) return s2.month - s1.month;
			return s2.day - s1.day;
		});
		
		System.out.println(students.get(0).name);
		System.out.println(students.get(students.size() - 1).name);
	}
}

class Student {
	final String name;
	final int day;
	final int month;
	final int year;
	
	public Student(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
}
