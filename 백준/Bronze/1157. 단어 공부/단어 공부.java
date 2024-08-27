import java.util.Scanner;

public class Main {
	public static int[] getFrequency(String str) {
		// 먼저 대문자로 변환한다.
		String upper = str.toUpperCase();
		// 빈도를 세기 위한 int[] 배열을 생성한다.
		int[] frequency = new int[26];
		// 단어의 시작부터 끝까지를 검사한다. 
		for(int i = 0; i < upper.length(); i++) {
			// 해당되는 알파벳의 빈도를 늘려준다.
			// 예를 들어 'A'라면 0, 'Z'라면 25와 같은 식이다.
			frequency[upper.charAt(i) - 'A']++;
		}
		// 빈도를 나타내는 배열을 반환해준다.
		return frequency;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String word = scanner.next();
		// 등장 빈도를 얻어온다.
		int[] freq = getFrequency(word);
		
		// 가장 많이 등장하는 알파벳의 빈도를 저장할 변수 max
		int max = 0;
		
		// 가장 많이 등장하는 알파벳의 빈도를 센다.
		for(int i = 0; i < freq.length; i++) {
			if (freq[i] >= max) {
				max = freq[i];
			}
		}
		// 이 최대값과 일치하는 알파벳의 개수를 센다.
		// 일치하는 알파벳이 2개 이상이면 ?를 출력한다.
		
		// 일치하는 알파벳이 1개이면 해당 인덱스에 해당하는
		// 알파벳을 출력한다.
		
		// 최댓값과 일치하는 알파벳의 개수를 저장할 변수  
		int match = 0;
		// 최댓값에 해당하는 알파벳의 인덱스를 얻어올 변수
		int index = 0;
		
		for(int i = 0; i < freq.length; i++) {
			if (freq[i] == max) {
				match++;
				index = i;
			}
		}
		
		// 일치하는 알파벳이 1개이면 
		if (match == 1) {
			System.out.println((char)('A'+index));
		} else { // 일치하는 알파벳이 여러개면
			System.out.println("?");
		}
	}
}