import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int increasingLength = 1;
		int decreasingLength = 1;
		
		int maxLength = 1;
		
		StringTokenizer numTokens = new StringTokenizer(br.readLine());
		ArrayList<Integer> numArray = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(numTokens.nextToken());
			numArray.add(num);
		}
		for (int i = 0; i + 1 < N; i++) {
			int prev = numArray.get(i);
			int next = numArray.get(i + 1);
			
			if (prev < next) {
				increasingLength++;
				
				if (decreasingLength > maxLength) {
					maxLength = decreasingLength;
				}
				
				decreasingLength = 1;
			}
			else if (prev > next) {
				decreasingLength++;
				
				if (increasingLength > maxLength) {
					maxLength = increasingLength;
				}
				
				increasingLength = 1;
			} else {
				increasingLength++;
				decreasingLength++;
			}
			
			if (i + 1 == N - 1) {
				int maxCurrentLength = Math.max(increasingLength, decreasingLength);
				if (maxCurrentLength > maxLength) {
					maxLength = maxCurrentLength;
				}
			}
		}
		
		System.out.print(maxLength);
	}
}
