import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            아이디어 정리
            -> 피카츄는 "pi", "ka" "chu"를 발음할 수 있다. -> 세 음절을 합친 단어만 발을 할 수 있다.
            ( 예를 들면 pikapi, pikachu 처럼 )
            -> 문자열이 주어졌을 때 피카츄가 발음할 수 있는 문자열인지 아닌지를 구하기
            -> 문제 조건을 통해 피카츄의 발음을 위해서는 pi, ka, chu 셋 중에 하나에는 반드시 포함되어야 합니다.
            -> 주어지는 문자열의 길이는 최대 5000자이기 때문에 시간 초과를 생각해서 전략을 짜야합니다.
            -> 가장 거슬리는 부분은 주어진 문자열을 pi, ka, chu로 어떻게 구분하느냐 입니다.
            -> 만약 replaceAll을 써서 "pi, ka, chu"를 전부 빈 문자열로 만들어 버리면
            -> 만약 발음할 수 있으면 빈 문자열이 될 것이고, 발음할 수 없어야 빈 문자열이 아닐 것입니다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("pi|ka|chu", "");

        if (str.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
