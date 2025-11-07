import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            int[] firstFreq = new int[26];
            int[] secondFreq = new int[26];

            if (first.length() != second.length()) {
                bw.write("Impossible\n");
                continue;
            }

            for (int j = 0; j < first.length(); j++) {
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);

                firstFreq[ch1 - 'a']++;
                secondFreq[ch2 - 'a']++;
            }

            boolean isPossible = true;

            for (int j = 0; j < 26; j++) {
                if (firstFreq[j] != secondFreq[j]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) bw.write("Possible\n");
            else bw.write("Impossible\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}