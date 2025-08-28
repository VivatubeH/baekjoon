import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] frequency = new int[26];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));
            frequency[ch - 'a']++;
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > max) max = frequency[i];
        }
        int count = 0;
        int maxIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (frequency[i] == max) {
                count++;
                maxIndex = i;
            }
        }
        if (count == 1) {
            System.out.print((char)('A' + maxIndex));
        } else {
            System.out.print('?');
        }
    }
}
