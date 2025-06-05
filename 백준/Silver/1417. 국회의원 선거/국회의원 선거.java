import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dasomVote = 0; // 다솜이의 투표 수
		int minimumCount = 0; // 매수 해야하는 최소 인원수 
		
		int[] votes = new int[N - 1];
		
		for (int i = 0; i < N; i++) {
			int vote = Integer.parseInt(br.readLine());
			
			if (i == 0) {
				dasomVote = vote;
				continue;
			}
			votes[i - 1] = vote;
		}
		
		while (true) {
			int max = 0; 
			int maxIndex = 0;
			
			for (int i = 0; i < N - 1; i++) {
				if (votes[i] >= max) {
					max = votes[i];
					maxIndex = i;
				}
			}
			
			if (max < dasomVote) {
				break;
			}
			
			votes[maxIndex]--;
			dasomVote++;
			minimumCount++;
		}
		
		System.out.print(minimumCount);
	}
}
