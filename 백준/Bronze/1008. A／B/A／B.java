import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		// Scanner 클래스의 객체 생성을 먼저 해야함. ( 사용자 입력 )
		// 참조변수 이름은 자유롭게.
		
		// Scanner 클래스의 nextInt 메서드 활용하기.
		
		int a = in.nextInt(); // nextInt는 정수 입력받기.
		int b = in.nextInt(); // nextInt는 정수 입력받기.
		
		System.out.println((double)a/b); 
		// a를 double로 형변환하면 double / int여서 b도 double로 자동 형변환.
		// double / double이니 double의 결과값이 나옴.
		// float로 형변환해버리면 6~7자리까지만 정밀하기 때문에 안됨.
		// double은 14~15자리까지의 정밀도가 보장됨.
	}
}
