// 각각의 기타는 모두 다른 시리얼 넘버를 가집니다.
// 기타를 시리얼 번호 순으로 정렬하고자 합니다.
// 모든 시리얼 번호는 알파벳 대문자와 숫자로 이루어집니다.

// 정렬 기준은 다음과 같습니다.
// 1. 두 시리얼 번호의 길이가 다르면 짧은 것이 먼저 옵니다.
// 2. 만약 길이가 같다면 A의 모든 자리수와 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 옵니다. ( 숫자만 더함 )
// 3. 위의 두 가지 조건으로도 비교할 수 없다면, 사전순 비교합니다. ( 숫자가 알파벳보다 사전순으로 작습니다. )

// 문제 조건 : 시리얼이 주어졌을 때 정렬해서 출력하기

// 입력 : 기타의 개수 N ( 첫째 줄에 주어집니다. ) , N <= 50
// 둘째줄부터 N개의 줄에 시리얼 번호가 하나씩 주어집니다. ( 길이는 최대 50 )
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // 기본적으로 입력이 기타 개수 50개 이하, 각 시리얼 번호 50자 이하라서
        // O(n^2)이더라도 2500번의 연산이면 끝납니다.
        // 즉, 이 문제는 시간 복잡도에서는 여유가 있고 정렬만 잘하면 됩니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int guitars = Integer.parseInt(br.readLine()); // 기타의 개수를 저장할 변수입니다.
        ArrayList<String> serialNumbers = new ArrayList<>(); // 시리얼 번호들을 저장할 ArrayList입니다.
        for (int i = 0; i < guitars; i++) { // 기타의 개수만큼 입력을 받아야합니다.
            serialNumbers.add(br.readLine()); // 줄단위로 입력을 받습니다.
        }

        // 정렬 기준에 따른 정렬이 필요합니다.
        Collections.sort(serialNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sum1 = 0;
                int sum2 = 0;

                if (o1.length() != o2.length()) { // 문자열 길이가 다르다면
                    return o1.length() - o2.length(); // 길이순으로 오름차순 정렬합니다.
                } else { // 문자열 길이가 같다면
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            sum1 += o1.charAt(i) - '0';
                        }
                    }
                    for (int j = 0; j < o2.length(); j++) {
                        if (o2.charAt(j) >= '0' && o2.charAt(j) <= '9') {
                            sum2 += o2.charAt(j) - '0';
                        }
                    }
                    // 자릿수의 합으로 비교를 못한다는 건
                    // 둘 다 문자여서 자릿수의 합이 0이거나
                    // 자릿수의 합이 같다는 뜻이므로
                    if (sum1 != sum2) { // 자릿수의 합이 다르면
                        return sum1 - sum2; // 값 기준 오름차순 정렬을 하고
                    } else { // 자릿수의 합이 같으면
                        return o1.compareTo(o2); // 사전순으로 오름차순 정렬을 합니다.
                    }
                }
            }
        });
        for (String str : serialNumbers) {
            System.out.println(str);
        }
    }
}
