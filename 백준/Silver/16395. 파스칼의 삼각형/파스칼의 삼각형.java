import java.util.Arrays;
import java.util.Scanner;

class Main{
	
	public static void main(String[] args) {
		
		int[][] pascal = new int[31][31];
		
		for(int i = 1; i <= 30; i++) {
			pascal[i][1] = 1; // 각행의 1열은 1로 고정
			pascal[i][i] = 1; // 각 행의 마지막 열도 1로 고정
		}
		for (int i = 2; i < 30; i++) {
			int j = 2;
			while(j <= i) {
				pascal[i+1][j] = pascal[i][j-1] + pascal[i][j];
				j++;
			}
		}
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println(pascal[n][k]);
		in.close();
	}
}