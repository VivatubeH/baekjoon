import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		// 666이라는 숫자만 포함되어 있으면 됨.
		String str = "666";
		
		// 검색 숫자 666
		int search = 666;
		// 몇 번째로 666이 나왔는지 counting할 count 변수
		int count = 0;
		
		// 사용자로부터 입력을 받기 위한 Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		// N을 입력받고, N번째 666을 찾아서 출력해야 함.
		int N = in.nextInt();
		
		// count는 시작은 0으로 하고, 하나를 발견하면 1 증가 시키도록.
		// count 번째가 즉 N에 도달하면
		// 즉 N번째 숫자를 검색한 이후에 
		// 해당 숫자를 출력해야 함.
		while(true) {
			// 검색하는 숫자에 666이라는 패턴이 포함되어 있는지 검색하기 위해 문자열로 변환
			String cur = Integer.toString(search);
			// String의 contains 메서드로 현재 숫자에 666이 포함되어 있는지 검사.
			if (cur.contains(str)) { // 포함되어 있으면
				count++; // count 증가
			}
			
			// N번째 숫자를 알아내면 탈출.
			if(count == N) {
				break;
			}
			
			// 아직 못 알아낸 경우 search를 늘려서 다음 수로 이동.
			search++;
		}
		
		System.out.println(search);
	}
}