import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		// Scanner 클래스의 객체 생성을 먼저 해야함. ( 사용자 입력 )
		// 참조변수 이름은 자유롭게.
		
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		
		System.out.println(a+b+c);
	}
}