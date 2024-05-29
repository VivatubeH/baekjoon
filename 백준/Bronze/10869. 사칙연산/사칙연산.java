import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		// Scanner 클래스의 객체 생성을 먼저 해야함. ( 사용자 입력 )
		// 참조변수 이름은 자유롭게.
		
		// Scanner 클래스의 nextInt 메서드 활용하기.
		
		int a = in.nextInt(); // nextInt는 정수 입력받기.
		int b = in.nextInt(); // nextInt는 정수 입력받기.
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
	}
}
