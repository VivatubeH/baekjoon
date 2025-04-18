import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            아이디어
            -> 특정 패턴과 일치하는 파일 이름을 적절히 출력하지 못하는 버그
            -> 패턴은 소문자 여러 개 + 별표 하나로 이루어진 문자열
            -> 파일 이름이 패턴에 일치하기 위해서는 패턴에 있는 별표를 알파벳 소문자로 이루어진 임의의
            -> 문자열로 변환해서 파일 이름과 같게 만들 수 있어야 함. ( 빈 문자열도 가능합니다. )
            -> 예를 들어 "abcd", "ad", "anestonestod"는 모두 패턴 "a*d"와 일치합니다.
            -> 하지만 "bcd"는 일치하지 않습니다.

            -> 문제는 패턴과 파일 이름이 모두 주어졌을 때 각각의 파일 이름이 패턴과 일치하는지를 구해야 합니다.
            -> 첫째 줄에는 파일의 개수 N ( 1 <= N <= 100 )
            -> 둘째 줄에는 패턴이 주어집니다. ( 패턴은 알파벳 소문자와 * (아스키 코드값 42) 1개로 이루어집니다. )
            -> 문자열의 길이는 100을 넘지 않으며 별표는 문자열의 시작과 끝이 아닙니다. ( 정규식 써야할듯 )
            -> N개의 줄에 걸쳐 입력으로 주어진 i번째 파일 이름이 패턴과 일치하면 "DA", 일치하지 않으면 "NE"

            -> 예를 들어 a*d면 a로 시작하고, d로 끝나기만 하면 되므로
            -> 이 때는 startsWith()과 endsWith()으로 검사하면 됩니다.
            
            -> 반례 : 만약 ab*bc의 경우 abc가 통과가 되어버리므로 길이 체크를 해줘야 합니다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String regex = br.readLine();

        int index = regex.indexOf("*"); // *이 등장하는 위치를 구하고

        String start = regex.substring(0, index);
        String end = regex.substring(index+1);

        int length = start.length() + end.length();

        // ab*bc인 경우 abc는 둘 다 참이지만, 정답이 아니므로 길이 체크도 해줘야 합니다.
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() < length) {
                System.out.println("NE");
            }
            else if (str.startsWith(start) && str.endsWith(end)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
