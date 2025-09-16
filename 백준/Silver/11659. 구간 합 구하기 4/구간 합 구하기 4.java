import java.io.*;
import java.util.*;

public class Main {
	public static int[] numArray;
	public static int[] prefixSum;
	public static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		output();
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		numArray = new int[N];
		prefixSum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
			prefixSum[i + 1] = prefixSum[i] + numArray[i]; 
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			int current = prefixSum[right] - prefixSum[left - 1];
			answer.append(current).append("\n");
		}
	}
	
	public static void output() {
		System.out.print(answer);
	}
	
}
