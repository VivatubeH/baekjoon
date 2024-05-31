/*
 * 1에서 6까지의 눈을 가진 3개의 주사위
 * 규칙1 : 같은 눈 3개가 나오면 10000원 + (같은 눈 x 1000)
 * 규칙2 : 같은 눈 2개만 나오면 1000원 + (같은 눈)x100
 * 규칙3 : 모두 다른 눈이 나오는 경우는 (그 중 가장 큰 눈) x 100원
 * 
 * case1 : 입력 3 3 6 - 출력 : 1300
 * case2 : 입력 2 2 2 - 출력 : 12000
 * case3 : 입력 6 2 5 - 출력 : 600
 */

// 사용자로부터 입력을 받아야 하니까 Scanner 클래스 사용
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int firstDice = in.nextInt();
		int secondDice = in.nextInt();
		int thirdDice = in.nextInt();
		// 주사위 값 정수 3개 입력받기.
		
		
		int money = 0; 
		// 상금을 저장할 int 변수 
		
		// 규칙에 따라 상금이 달라진다. ( 조건식 )
		// 같은 눈이 3개만 나오는 경우가 아니다 -> 적어도 하나의 눈은 다름.
		// 한 쌍이라도 같은 걸 구할지, 모두 다른 걸 구할지?
		
		// 주사위 3개의 눈이 같은 경우의 상금
		if ( (firstDice == secondDice) && (secondDice == thirdDice) ) {
			money = 10000 + (firstDice*1000);
		} else if ((firstDice != secondDice) && (secondDice != thirdDice) && (firstDice != thirdDice)) {
			
			/* 세 눈이 모두 다른 경우
			 * 
			 * 적어도 하나는 다른 경우만 넘어온다....
		 int max = 0; 걍 얘를 하나 만들고, 들어오는 세 주사위 눈에 대해
		 얘보다 크면 걔를 max로 바꾸고 최종적으로 max와 값이 같은 주사위가
		 가장 큰 눈의 주사위.
			 */
			int max = 0;
			if (firstDice > max) {
				max = firstDice;
			}
			if (secondDice > max) {
				max = secondDice;
			}
			if (thirdDice > max) {
				max = thirdDice;
			} // else~if를 써 버리면 first가 1만 되도 max로 바뀌고 다음 조건문 실행을 안하니 무의미.
			money = max * 100;
			
		} // 여기까지 넘어온 이상 같은 눈이 나오면 같은 눈이 2개밖에 없는 것.
		else {
			if ( firstDice == secondDice ) {
				money = 1000 + firstDice*100;
			} else if ( secondDice == thirdDice ) {
				money = 1000 + secondDice*100;
			} else {
				money = 1000 + firstDice*100;
			}
			
		}
		System.out.println(money);
		in.close();
		}
		
	}