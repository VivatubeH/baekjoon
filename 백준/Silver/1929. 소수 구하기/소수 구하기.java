import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// 자연수 m, n이 주어진다.
		// m,n은 각각 100만 이하의 자연수
		int m = in.nextInt();
		int n = in.nextInt();
		
		// 소수는 1과 자기 자신을 제외하고는 나누어떨어지면 안됨.
		// 즉, 1과 자기 자신을 제외한 수로 나눠떨어지면 소수가 아니다.
		
		// m과 n 사이의 자연수가 소수인지 알아보자.
		for(int k = m; k <= n; k++) {
			// 기본값은 일단 소수인걸로
			boolean isPrime = true;
			
			// k에 대해서, 루트 k보다 작거나 같은 수로만 나누면
			// 해당 수에 대한 모든 조합을 구할 수 있음.
			// 1로 나누는 건 의미가 없고,
			// 제곱수가 자신이 같은 수는 1밖에 없음.
			if (k == 1) { // 1이면 소수가 아니니깐 false
				isPrime = false;
			}
			if(k == 2 || k == 3) { // 2나 3은 소수니깐 true로 표시한다.
				isPrime = true;
			}
			for(int i = 2; i <= Math.sqrt(k); i++) {
			// 1,2,3에 대해서는 해당 로직이 수행되지 않는다.
			// 밖에서 따로 처리해준다.
				
			// 에라토스 테네스의 체를 사용하자.
				if(k != 5 && k != 7) {
				// k가 2,3인 경우는 이 로직으로 안 들어오니깐
				// k가 5나 7인 경우만 소수임을 판별하고 로직 탈출
					if((k % 2) == 0 || (k % 3) == 0 || (k % 5 == 0) || (k % 7 == 0)) {
						// 2,3,5,7이 아니면서 2,3,5,7의 배수면
						// 소수가 아니다. ( 에레토스테네스의 체 )
						isPrime = false;
						break;
					}
				}
				
				if(k % i == 0) {
					// 나눠떨어진다 = 소수가 아니다.
					// 소수가 아니면 해당수는 판별끝이니 로직 탈출
					isPrime = false;
					break; 
				}
			}
			// 소수 판별끝
			// 기본값이 소수여야 걸러지지 않은 경우 소수임이 판별된다.
			if (isPrime == true) { // 소수면 출력
				System.out.println(k);
			}
		}
	}
}