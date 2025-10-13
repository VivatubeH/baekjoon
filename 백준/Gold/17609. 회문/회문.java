import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                int result = service(word);
                answer.append(result).append("\n");
            }
        }
    }

    public static int service(String word) {
        if (isPalindrome(word)) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = word.length() - 1;
        while (leftIndex < rightIndex) {
            if (word.charAt(leftIndex) != word.charAt(rightIndex)) {
                break;
            }
            leftIndex++;
            rightIndex--;
        }
        String subStr = word.substring(leftIndex, rightIndex + 1);

        String candidate1 = subStr.substring(1);
        String candidate2 = subStr.substring(0, subStr.length() - 1);
        if (isPalindrome(candidate1) || isPalindrome(candidate2)) {
            return 1;
        }

        return 2;
    }

    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char leftChar = word.charAt(left);
            char rightChar = word.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void output() {
        System.out.print(answer);
    }
}
