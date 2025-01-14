import java.util.Scanner;

public class Main {
    public static char[] changeletters(String word){
        char[] originalWord = word.toCharArray();

        for (int i = 0; i < originalWord.length; i++) {
            if (('a' <= originalWord[i]) && (originalWord[i] <= 'z')) { // 소문자면
                originalWord[i] -= 'a' - 'A'; // 대문자로 바꾸고
            } else { // 대문자면
                originalWord[i] += 'a' - 'A'; // 소문자로 바꾼다.
            }
        }
        return originalWord;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 문자열 입력을 받기위한 Scanner 객체 생성

        String word = scanner.next();
        char[] answer = changeletters(word);
        System.out.println(answer);
    }
}