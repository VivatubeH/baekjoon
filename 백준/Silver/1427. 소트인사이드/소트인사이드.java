import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 대신 문자열로 입력받아서 처리하겠습니다.
        String N = br.readLine();
        // 정렬을 사용하기 위해 Collection을 구현한 클래스를 사용합니다.
        ArrayList<String> numbers = new ArrayList<>();

        // 각 문자를 한 글자씩 추출해서 문자열 배열에 담아버립니다.
        for (int i = 0; i < N.length(); i++) {
            numbers.add(N.substring(i, i+1));
        }

        // 역순으로 문자열을 정렬합니다.
        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // 출력할 땐 줄바꿈 없이 숫자처럼 출력하겠습니다.
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
    }
}
