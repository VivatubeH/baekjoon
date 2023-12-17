import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		int[] score = new int[5];
		int id = 0;
		
		for ( int i =0; i<t; i++) {
			score[i] = in.nextInt();
		}
		
		if ( score[0] > score[2] ) {
			id += ((score[0]-score[2])*508);
		}
		else {
			id += ((score[2]-score[0])*108);
		}
		
		if (score[1] > score[3]) {
			id += ((score[1]-score[3])*212);
		}
		else {
			id += ((score[3]-score[1])*305);
		}
		
		id += (score[4]*707);
		
		id *= 4763;
		System.out.println(id);
	}
}