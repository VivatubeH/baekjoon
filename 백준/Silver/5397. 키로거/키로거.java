import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                execute(br.readLine());
            }
        }
    }

    public static void execute(String sentence) {
        Deque<Character> cursorLeftStack = new ArrayDeque<>();
        Deque<Character> cursorRightStack = new ArrayDeque<>();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch == '<') {
                if (!cursorLeftStack.isEmpty()) {
                    cursorRightStack.addFirst(cursorLeftStack.pollLast());
                }
            } else if (ch == '>') {
                if (!cursorRightStack.isEmpty()) {
                    cursorLeftStack.addLast(cursorRightStack.pollFirst());
                }
            } else if (ch == '-') {
                if (!cursorLeftStack.isEmpty()) {
                    cursorLeftStack.pollLast();
                }
            } else {
                cursorLeftStack.addLast(ch);
            }
        }
        for (Character leftChar : cursorLeftStack) {
            answer.append(leftChar);
        }
        for (Character rightChar : cursorRightStack) {
            answer.append(rightChar);
        }
        answer.append("\n");
    }
}
