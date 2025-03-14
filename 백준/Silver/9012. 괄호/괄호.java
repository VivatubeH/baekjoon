import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            if (isVPS(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        // 괄호 문자열인지 판단할 수 있는 메서드를 만들자.
        // 찾을 수 있는 논리 세우기
        // x가 VPS라면 (x)도 VPS
        // xy가 VPS라면 xy도 VPS
        /*
            AABBABB -> 아님
            AAAABABBAB -> 아님
            AABABBAAABBB -> 맞음
         */
        // AB여야 VPS임은 자명하다.
        // AB를 탐색을 해서, AB인 경우 어떻게 처리할 것인가?
        // 만약 AB이면 얘는 사실 확인할 필요가 없으니 제거하면
    }
    public static boolean isVPS(String inputWord) {
        StringBuilder sb = new StringBuilder(inputWord);
        int index = 0; // 괄호문자열을 체크하기 위한 index 변수를 선언합니다.
        while(true) {
            index = sb.indexOf("()"); // ()이 등장하는 index를 받아옵니다.
            // 만약 ()이 등장하는 인덱스가 없다면 모든 조건 검사가 끝난 것이니 break 합니다.
            if (index == -1) {
                break;
            }
            sb.delete(index, index+2); // 이렇게 하면 index가 -1인 경우가 없고, ()이 보장되기 때문에
            // index+2를 해도 index를 초과하지 않습니다.
        }
        // 모든 반복문이 끝났을 때 빈 문자열이라면
        // 이는 ()로만 이루어진 문자열인 VPS라는 것이 보장됩니다.

        // 자바 11은 StringBuilder에 isEmpty()가 없어서 String으로 변환 후 진행하겠습니다.
        String string = sb.toString();
        if (string.isEmpty()) { // isEmpty는 빈 문자열일 때 true를 반환하도록 되어 있습니다.
            return true;
        }
        return false;
    }
}