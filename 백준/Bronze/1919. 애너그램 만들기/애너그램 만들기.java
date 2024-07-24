import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	String str1 = in.next();
	String str2 = in.next();

	// testcase str1 = vivatube, str2 = civil
	char[] word1 = str1.toCharArray();
	char[] word2 = str2.toCharArray();
	
	int count = 0;
	
	for(int i = 0; i < word1.length; i++) {
		for(int j = 0; j < word2.length; j++) {
			if ((word1[i]==word2[j]) && (word1[i]!='-')) {
				 word1[i] = '-';
				 word2[j] = '-';
			}
		}
	}
	
	for(int i = 0; i < word1.length; i++) {
		if (word1[i] != '-') {
			count++;
		}
	}
	for(int j = 0; j < word2.length; j++) {
		if (word2[j] != '-') {
			count++;
		}
	}
	System.out.println(count);
	}
}