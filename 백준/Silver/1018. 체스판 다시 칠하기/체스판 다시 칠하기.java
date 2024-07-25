import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 1. 몇 행 몇 열로 입력받을지를 정하는 int형 변수 N,M 설정하기
		// M - 열의 수, N - 행의 수 
		int N = in.nextInt();
		int M = in.nextInt();

		// 2. N줄의 보드판을 줄 별로 입력받기
		String[] board = new String[N];
		
		for(int i = 0; i < N; i++) {
			board[i] = in.next(); 
		}

		// 3. 검은색으로 시작하는 보드판, 흰색으로 시작하는 보드판 샘플 만들기
		String black = "BWBWBWBW";
		String white = "WBWBWBWB";


		// 5. 8x8씩 잘라서 일치하는 개수 찾기
		// pattern 1과 pattern 2 분리하기
		// 0,2,4,8행 - 2로 나눠서 나누어떨어짐. 
		// 1,3,5,7행 - 2로 나눠서 안 나눠떨어짐.
		// 최소로 수정해서 만들 수 있는 경우의 수를 구하기 위한 변수 min
		// 처음에 min은 충분히 크게 해줘야 함.
		int min = 2500;
		int result = 0;
		/*
		 * 8*8이 아닌 일반적인 경우에 해당하는 N*M(N행 M열)에 대해서도 알아보자.
		 * 시작점의 좌표를 (x,y)라고 하면 길이가 8,8이어야 하므로 
		 * y는 N-8보다 작거나 같아야 한다. ( ex. M이 10이면 y는 2까지만 가능 [ 2~9 ]
		 * 마찬가지로 x도 M-8보다 작거나 같아야 한다.
		 * 즉, 기본조건은 x <= M-8, y <= N-8이어야 하고 순서는
		 * x가 증가했다가 x가 최대 범위에 도달하면 x가 다시 0부터 시작해야 하고,
		 * 반면 y는 열단위 이동시에는 그대로다가, x가 최대 범위에 도달한 다음에 y가 1 증가해야 한다.
		 * 그리고 y도 마찬가지로 y <= N-8 범위에 있어야 한다. 
		 */
		
		// x가 0부터 M-8까지, y도 0부터 N-8까지
		// 검색하는 시작점의 좌표가 x를 이용한 for문에 의해 1칸씩 우측으로 이동하게 되고
		// 검색하는 시작점 좌표가 우측 최후 경계점에 도달하면 x를 이용한 for문이 거짓이 되어서
		// y를 이용한 for문이 돌아가게 된다. ( 이 때, x는 다시 0부터 [왼쪽 끝부터] 검색한다. )
		// 최후에 x도 끝에 도달하고 y도 끝에 도달하게 된 x == M-8, y == N-8인 상황에서 
		// 안쪽 8*8 for문이 끝나면서 x를 증가시켜서 x > M-8이 되어서 x를 이용한 for문이 거짓이 되고
		// 바깥쪽 for문의 증감식이 수행되면서 y의 증감식으로 이동해서 y > N-8이 되어서
		// 전체 for문 탈출. 
		
		// m = 10, n = 13
		for(int y = 0; y <= N-8; y++) { // y <= 5
			for(int x = 0; x <= M-8; x++) { // x <= 2
				
				// 시작이 black 패턴의 개수를 저장할 변수 pattern1과 
				// 시작이 white 패턴의 개수를 저장할 변수 pattern2
				// 항상 한 세트 검사 후에 각 패턴을 계산한 건 초기화가 되어야 한다.
				// 매 세트에 대해서 최소값을 구해야 함.
				int pattern1 = 0;
				int pattern2 = 0;
				// 8*8 구조의 보드를 하나의 연산 단위로 생각해야 한다.
				for(int j = 0; j < 8; j++) {
					for(int i = 0; i < 8; i++) {
						if((j+y)%2==0) { // 시작행이 black인 경우와 white인 경우를 각각 저장
							if(black.charAt(i) != board[j+y].charAt(i+x)) {
								pattern1++;
							} // 패턴은 black이거나 white거나
							else if(white.charAt(i) != board[j+y].charAt(i+x)) {
								pattern2++;
							}	
						} else { // 짝홀수행의 패턴은 반대
							if(white.charAt(i) != board[j+y].charAt(i+x)) {
								pattern1++;
							} // 패턴은 black이거나 white거나
							else if(black.charAt(i) != board[j+y].charAt(i+x)) {
								pattern2++;
							}
						}
					}
				}
				// 여기까지가 8*8인 한 세트 검사.
				// 두 값 중에 더 작은 값이 min에 들어가게 된다.
				result = Math.min(pattern1, pattern2);
				
				// 이번 세트에서의 최소값과 지금까지의 최소값을 비교해서 
				// 더 작은 값이 최소값이 되어야 한다.
				min = Math.min(result, min);	
			}
		}
		System.out.println(min);
	}

}