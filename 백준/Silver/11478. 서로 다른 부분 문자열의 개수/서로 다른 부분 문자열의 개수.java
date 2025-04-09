import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열의 길이가 최대 1000이므로 2중 for문을 돌아도 최대 100만회의 연산이면 가능합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str);

        int length = str.length();

        // 중복을 없애기 위해서 이중 for문을 돌면서 O(n^2) + HashSet에 값을 대입하고 O(1)
        HashSet<String> differentStrings = new HashSet<>();

        for (int size = 1; size <= length; size++) { // 각 문자열의 길이를 size로 정하고 인덱스를 이동시킵니다.
            for (int index = 0; index + size <= length; index++) {
                differentStrings.add(sb.substring(index, index + size));
            }
        }
        // 이후 Set의 size()가 서로 다른 부분 문자열의 개수가 될 테니 그대로 출력합니다.
        System.out.println(differentStrings.size());
    }
}
