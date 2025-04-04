import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 사용자로부터 받는 입력을 하나의 문자열로 저장합니다.

        // 이 때 괄호를 통해 전체 값을 최소로 하려면 - 부호에 붙은 절댓값이 최대가 되야 합니다.

        // 1. 모두 +만 있는 경우 -> 그냥 다 더한 값이 최솟값입니다. ( 그 외의 경우가 존재하지 않음. )
        // 2. 모두 -만 있는 경우 -> 그냥 다 더한 값이 최솟값입니다.
        // 3. +와 -가 섞여 있는 경우, +는 최소, -는 최대가 되야 합니다.

        StringTokenizer token = new StringTokenizer(input, "-");
        // -를 기준으로 토큰을 나눕니다.
        // -20+30-40+50+60-13 으로 예시를 두고 로직을 생각해보겠습니다.
        // token은 [20+30, 40+50+60, 13]
        ArrayList<Integer> list = new ArrayList<>();

        // 각 토큰에 대해서 연산을 수행하겠습니다.
        while(token.hasMoreTokens()) {
            // 내부의 개별 토큰인데 +를 기준으로 나눠서 연산을 수행해야 합니다.
            String innerToken = token.nextToken();
            int number = 0;

            // 내부 토큰에 대해서 각각을 연산해서 Integer로 만듭니다.
            StringTokenizer innerTokenizer = new StringTokenizer(innerToken, "+");
            while(innerTokenizer.hasMoreTokens()) {
                number += Integer.parseInt(innerTokenizer.nextToken());
            }
            list.add(number);
        }
        int minSum = 0; // 최소 합계를 구할 변수입니다.

        // 첫 요소는 부호에 따라 -, +가 갈립니다.
        if (input.charAt(0) == '-') {
            minSum = -1 * list.get(0);
        } else {
            minSum = list.get(0);
        }

        // 이후 요소는 무조건 빼주어야 합니다.
        for (int i = 1; i < list.size(); i++) {
            minSum -= list.get(i);
        }

        System.out.println(minSum);
    }
}
