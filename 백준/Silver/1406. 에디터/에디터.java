import java.io.*;
import java.util.*;

public class Main {
    public static ArrayDeque<Character> beforeCursorList = new ArrayDeque<>();
    public static ArrayDeque<Character> afterCursorList = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String initialString = br.readLine();
            for (int i = 0; i < initialString.length(); i++) {
                beforeCursorList.addLast(initialString.charAt(i));
            }
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                String instruction = br.readLine();
                execute(instruction);
            }
        }
    }

    public static void execute(String instruction) {
        char startCh = instruction.charAt(0);

        if (startCh == 'L') {
            if (!beforeCursorList.isEmpty()) {
                char ch = beforeCursorList.removeLast();
                afterCursorList.addFirst(ch);
            }
        } else if (startCh == 'D') {
            if (!afterCursorList.isEmpty()) {
                char ch = afterCursorList.removeFirst();
                beforeCursorList.addLast(ch);
            }
        } else if (startCh == 'B') {
            if (!beforeCursorList.isEmpty()) {
                beforeCursorList.removeLast();
            }
        } else {
            char ch = instruction.charAt(2);
            beforeCursorList.addLast(ch);
        }
    }

    public static void output() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Character character : beforeCursorList) {
                bw.write(character);
            }
            for (Character character : afterCursorList) {
                bw.write(character);
            }
            bw.flush();
        }
    }
}
