import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// m을 분해해서 n을 만들 수 있으면 m을 n의 생성자라 함.
		// n을 입력받고 n의 가장 작은 생성자 구하기
		int n = in.nextInt();
		
		// 검색에 사용할 숫자 search, 존재여부 검사 check
		int search = 0;
		boolean check = false;
		
		// 어차피 6자리수를 다 더해도 최대가 54니깐
		// n과 54 이상으로 차이가 벌어지면 
		// 절대로 생성자가 될 수 없음.
		
		// 54보다 작은 경우는 그냥 센다.
		
		if (n <= 54) { // 54보다 작은 경우에는 1부터 그냥 세고.
			search = 1; 
		} else { // 54보다 큰 경우에는 n-54부터 센다.
			search = n - 54;
		}
		
		// 최대 54개 까지만 검사
		while(search <= n) {
			// 비교를 위해 사용할 변수 compare
			// 자기 자신도 더해야하니깐 compare의 초기값은 search
			int compare = search;
			// 1. search를 문자열로 변환
			String src = Integer.toString(search);
			// 2. 해당 문자열의 각 자리수를 
			// 정수로 변환한 다음 더 한다.
			for(int i = 0; i < src.length(); i++) {
				// 이렇게 얻은 각 자리수를
				// 더해서 compare를 만든다.
				int a = src.charAt(i) - '0';
				compare += a;
			}
			// 이렇게 만든 compare과 n과 일치하면
			if (compare == n) {
				// 발견했으니 true로 하고
				check = true;
				// 탈출
				break;
			}
			// 못찾은 경우 search를 늘려간다.
			search++; 
		}
		
		if (check) { // 찾았으면 가장 작은 생성자
			// 해당되는 숫자인 search를 출력한다.
			System.out.println(search);
		} else { // 못찾았으면 생성자 없음.
			// 0을 출력
			System.out.println(0);
		}
	}
}