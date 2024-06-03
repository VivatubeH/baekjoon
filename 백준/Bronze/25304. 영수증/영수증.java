import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int n = in.nextInt();
		
		// x는 영수증에 적힌 총 금액 x, y는 영수증에 적힌 구매한 물건 수
		
		int total = 0; // 실제로 계산할 총 금액을 저장할 변수 total
		
		for (int i = 1; i <= n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			total += (a*b); // a*b를 계속 total에 누적해서 계산
		}
		
		if(x == total) { // 총 금액과 계산한 금액이 일치하면
			System.out.println("Yes");
		}
		else { // 일치하지 않으면
			System.out.println("No");
		}
		in.close();
	}
}