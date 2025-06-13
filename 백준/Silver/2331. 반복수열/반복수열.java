import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1. A와 P를 공백을 기준으로 입력받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 수열의 첫 번째 수는 A입니다.
        list.add(A);

        // 2. ArrayList에 없다면 -> 걔를 ArrayList에 추가한다. ( 순서 유지가 필요 )
        // 3. 있으면 해당 인덱스를 찾아서, 그 인덱스가 개수가 된다.
        int index = 0;

        while (true) {
            // 2. 이전수의 각 자리수를 P 제곱해서 더한다.
            int prev = list.get(index);
            int curr = powEachDigitsByNum(prev, P);

            // 3. ArrayList에 없으면 추가하고, 있으면 해당 인덱스를 찾아서 출력한다.
            boolean isExist = false;
            for (int i = 0; i <= index; i++) {
                int num = list.get(i);

                if (num == curr) {
                    System.out.print(i);
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                break;
            } else {
                list.add(curr);
            }
            index++;
        }
    }

    // 각 자리수를 p제곱해서 더하는 메서드
    public static int powEachDigitsByNum(int num, int p) {
        String digits = String.valueOf(num);
        int sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            int digitNum = digit - '0';
            sum += (int)Math.pow(digitNum, p);
        }

        return sum;
    }
}