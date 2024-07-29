import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// 카드의 개수 n( 3장에서 100장 사이 )
		// 붙여야 할 숫자 M ( 10에서 30만 사이 )
		int n = in.nextInt();
		int m = in.nextInt();
		
		// 현재까지 M에 가까우면서 M보다 크지 않은 가장 큰 값을 저장할 변수 max
		int max = 0;
		
		// 최대 n장의 카드를 저장할 배열 card
		int[] card = new int[n];
		
		for(int i = 0; i < n; i++) { // 카드 n개 입력받기.
			card[i] = in.nextInt();	 
		}
		// 카드를 작은 숫자부터 쭉 정렬.
		// 예) 2 3 7 10 23 39... 이면 
		Arrays.sort(card);
		
		// 현재 세 수의 합을 저장할 변수 now
		int now = 0;
		
		// i, j, k는 겹치지 않게
		// j는 i보다 1크고, k는 j보다 1크도록.
		for(int i = 0; i < n-2; i++) { 
			for(int j = i+1; j < n-1; j++) { 
				for(int k = j+1; k < n; k++) { 
					// 세수의 합이 m보다 작거나 같으면
					// 이 세 수의 합이 후보군.
					if(card[i]+card[j]+card[k] <= m) {
						now = card[i]+card[j]+card[k];
					}
					// 이 후보군이 현재까지의 세 수의 합보다 크거나 같으면
					if (now >= max) {
						max = now;
					}
				}
			}
		}
		System.out.println(max);
		
		
	}
}