import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		ArrayList<String> candidates = new ArrayList<>();
		
		for (int i = 1; i < word.length() - 1; i++) {
			for (int j = i+1; j < word.length(); j++) {
				// i, j가 fix된 이후에야 쪼갬.
				StringBuilder original = new StringBuilder(word);
				original.insert(i, "/");
				original.insert(j + 1, "/");
				
				String[] split = original.toString().split("/");
				
				StringBuilder firstPart = new StringBuilder(split[0]);
				StringBuilder secondPart = new StringBuilder(split[1]);
				StringBuilder thirdPart = new StringBuilder(split[2]);
				
				String makedWord = (firstPart.reverse())
						.append(secondPart.reverse())
						.append(thirdPart.reverse())
						.toString();
				
				candidates.add(makedWord);
			}
		}
		
		Collections.sort(candidates);
		System.out.print(candidates.get(0));
	}
}
