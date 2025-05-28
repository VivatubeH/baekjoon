import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[3];
        for (int i = 0; i < 3; i++) {
            words[i] = br.readLine();
        }
        int number = 0;
        int numberIndex = 0;
        // 숫자를 포함하고 있으면 걔를 통해서 숫자 추론
        for (int i = 0; i < 3; i++) {
            String word = words[i];
            boolean isNumber = false;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= '0' && word.charAt(j) <= '9') {
                    number = Integer.parseInt(word);
                    numberIndex = i;
                    isNumber = true;
                    break;
                }
            }
            if (isNumber) break;
        }
        // 해당 숫자가 index번째면
        // 3 - index을 더한 게 구하려는 숫자
        number = number + (3 - numberIndex);

        // 이제 해당 숫자를 기반으로 출력
        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.print("FizzBuzz");
        } else if ((number % 3) == 0) {
            System.out.print("Fizz");
        } else if ((number % 5) == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(number);
        }
    }
}
