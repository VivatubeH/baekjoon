import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder answer = new StringBuilder();

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        while (!(str = br.readLine()).equals("#")) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (set.contains(ch)) count++;
            }
            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }
}
