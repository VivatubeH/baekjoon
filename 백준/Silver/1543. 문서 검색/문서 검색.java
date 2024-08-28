import java.util.Scanner;

/*
 * 영어로만 이루어진 문서를 검색하는 함수를 만드는데,
 * 함수는 어떤 단어의 총 등장 횟수를 센다.
 * 
 * 그러나,중복되어 세는 것은 빼고 세야한다.
 * 
 * 예시: 문서가 aaaaaaa이고, 찾으려는 단어가 aa이면
 *      이 단어를 0번부터 찾을 수도 있고, 2번부터 찾을 수도 있다.
 *      
 *      그러나 동시에 세는 건 금지다.
 *      
 *     문서가 주어진다. ( 문서의 최대 길이 2500 )
 *     둘째 줄에 검색하고 싶은 단어가 주어지는데 
 *     단어의 길이는 최대 50이고 소문자와 공백으로 이루어진다.
 *     
 *    단어가 같다 = 단어의 시작부터 끝까지 알파벳이 일치한다.
 *    문자열 비교 -> str.equals() 사용한다..
 *    
 *    단어의 길이를 length라고 하면, 문서에서 length 만큼씩 
 *    검색하면 된다.
 *    
 *    만약 문서에서 length만큼 검색해서 단어와 일치하면
 *    count를 늘려주고, 다음 검색위치를 length 뒤로 옮기면 되고
 *     
 *    만약 문서에 length만큼 검색해서 단어와 일치하지 않으면
 *    count는 늘릴 필요 없고 다음 검색위치도 바로 다음 위치다.
 */
public class Main {
	public static void main(String[] args) {
		// 문자열 입력을 위한 Scanner 객체 생
		Scanner scanner = new Scanner(System.in);
		
		// 공백도 읽어와야 하니깐 nextLine을 사용한다.
		String document = scanner.nextLine();
		String word = scanner.nextLine();
		
		// 단어의 길이를 length에 저장한다.
		int length = word.length();
		// 단어가 등장하는 횟수를 구할 변수 count
		int count = 0;
		
		// 문서의 시작부터 문서길아-length까지 검색의 시작위치로 한다.
		for(int start = 0; start <= document.length() - length;) {
			// 문서의 시작위치부터 length까지의 단어가 주어진 단어와 일치하면
			// count를 늘려주고, 다음 시작위치를 length만큼 뒤로 이동
			if (document.substring(start, start+length).equals(word)) {
				count++;
				start += length;
			} else {
				start += 1;
			}
		}
		
		// 최대 몇 번 등장하는 지 중복되지 않게 센 횟수 출력
		System.out.println(count);
		// 자원 반납 
		scanner.close();
	}
}