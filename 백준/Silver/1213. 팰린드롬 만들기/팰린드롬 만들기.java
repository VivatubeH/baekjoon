import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 문제의 입력인 한수의 이름을 입력받습니다. ( 최대 50글자 )

        String answer = makePalindromeByEnglishName(input);

        System.out.println(answer);
    }

    // 영어 이름으로 팰린드롬을 만드는 메서드입니다.
    // 팰린드롬 수가 불가능할 때는 I'm Sorry Hansoo를 만들어서 반환합니다.
    public static String makePalindromeByEnglishName(String name) {
        String palindrome = "";

        int[] frequency = new int[26]; // 각 알파벳이 등장한 빈도를 체크할 것입니다.

        int[] quotient = new int[26]; // 각 알파벳의 등장 횟수를 기반으로 2로 나눈 몫을 구하기 위한 메서드입니다.
        int[] remain = new int[26]; // 각 알파벳의 등장 횟수를 기반으로 2로 나눈 나머지를 구하기 위한 메서드입니다.

        // 이름을 돌면서 알파벳별 등장 횟수를 체크합니다.
        for (int i = 0; i < name.length(); i++) {
            frequency[name.charAt(i) - 'A']++; // 이렇게 하면 A면 frequecy의 0번이 증가되고, B면 frequency의 1번이 증가되는 식입니다.
        }

        // 이제 빈도 배열에 대해서 몫과 나머지를 구합니다.
        for (int i = 0; i < quotient.length; i++) {
            quotient[i] = frequency[i] / 2; // 몫을 몫 배열에 저장하고
            remain[i] = frequency[i] % 2; // 나머지를 빈도 배열에 저장합니다.
        }

        // 팰린드롬을 구할 때
        // ABACABA라면 -> A/2만큼 A를 붙이고, B/2만큼 B를 붙이고, C/2만큼 C를 붙이는 식 문자열 left를 만들고
        // 이후 A%2 만큼 A를 붙이고, B%2만큼 B를 붙이고, C%2만큼 C를 붙아눈 식으로 문자열 middle을 만들고
        // 이후 left를 뒤집은 문자를 결합하게 되면
        // 팰린드롬이 됩니다.

        String left = ""; // 앞문자를 저장하기 위한 변수입니다.
        // 먼저 몫 만큼 문자를 결합합니다.
        for (int i = 0; i < frequency.length; i++) { // 문자를 앞에서부터 순회하면서
            for (int j = 0; j < quotient[i]; j++) { // 등장하는 빈도수만큼 문자를 결합해줍니다.
                left += (char)(i + 'A');
            }
        }

        String middle = ""; // 중간 문자를 저장하기 위한 변수입니다.
        // 나머지만큼 문자를 결합합니다.
        for (int i = 0; i < frequency.length; i++) {
            for (int j = 0; j < remain[i]; j++) {
                middle += (char)(i + 'A');
            }
        }

        palindrome = left + middle + new StringBuilder(left).reverse();

        if (!isPalindrome(palindrome)) return "I'm Sorry Hansoo"; // 팰린드롬이 아니면 I'm sorry Hansoo를 반환합니다.

        return palindrome;
    }

    // 해당 이름이 팰린드롬 이름인지 판단하는 메서드입니다.
    // 팰린드롬 이름이면 true를 아니면 false를 반환합니다.
    public static boolean isPalindrome(String name) {
        boolean isPalindrome = false;
        String reverse = new StringBuilder(name).reverse().toString(); // 걔를 뒤집은 이름을 가지고

        // 팰린드롬 이름이면 true를 반환합니다.
        if (name.equals(reverse)) {
            return true;
        }
        return false;
    }
}
