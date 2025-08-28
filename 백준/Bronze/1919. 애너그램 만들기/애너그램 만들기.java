import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[] frequencyOfFirst = new int[26];
        int[] frequencyOfSecond = new int[26];

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            frequencyOfFirst[ch - 'a']++;
        }

        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);
            frequencyOfSecond[ch - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(frequencyOfFirst[i] - frequencyOfSecond[i]);
            sum += diff;
        }
        System.out.print(sum);
    }
}
