import java.util.Arrays;
import java.util.Scanner;

/*
 *	두 영어 단어가 철자 순서만 뒤바꾸어 같아질 수 있으면 두 단어를
 *  서로 애너그램 관계에 있다고 한다. 
 * 예시 ) occurs와 succor는 서로 애너그램 관계에 있다.
 * 
 *  dared와 bread는 서로 애너그램 관계가 아니지만 dared에서 맨 앞 d,
 *  bread에서 맨 앞 b를 제거하면 ared와 read가 애너그램 관계가 된다.
 *  
 *  두 개의 영 단어가 주어질 때 두 단어가 애너그램 관계에 있기위해
 *  제거해야 할 최소 개수의 문자수를 구하는 프로그램을 작성하라.
 *  
 *  1. 어떤 방식으로 애너그램인지 판별할 것인가?
 *  - 두 단어가 순서를 바꿔서 같다. 
 *  - 즉, 각각의 단어의 알파벳의 개수가 같다.
 */
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 두 단어를 입력받는다.
		String str1 = scanner.next();
		String str2 = scanner.next();
		// 각각의 알파벳을 다루기 위해 char[] 배열로 바꾼다.
		char[] word1 = str1.toCharArray();
		char[] word2 = str2.toCharArray();
		// 몇 개를 제거해야 할지는 delete로 결정한다.
		int delete = 0;
		// 각각의 단어의 알파벳의 개수를 센다.
		int[] countWord1 = new int[26];
		int[] countWord2 = new int[26];
		// 'a'=0 'b'=1과 같은 식으로 개수를 세준다.
		// 'z'=25가 되도록 설계한다.
		for(int i = 0; i < word1.length; i++) {
			countWord1[word1[i] - 'a']++;
		}
		for(int j = 0; j < word2.length; j++) {
			countWord2[word2[j] -'a']++;
		}
		// 이후 두 단어를 센 배열을 비교해서 count가 다른 경우에만
		// 둘의 차이의 절댓값 만큼을 제거해줘야 한다.
		for(int k=0; k < 26; k++) {
			if (countWord1[k] != countWord2[k]) {
				if (countWord1[k] > countWord2[k]) {
					delete += countWord1[k] - countWord2[k];
				} else {
					delete += countWord2[k] - countWord1[k];
				}
			}
		}
		System.out.println(delete);
	}
}
