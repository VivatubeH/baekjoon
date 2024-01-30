import java.util.*;

class Main {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		final int N = in.nextInt(); 
		for (int k=0;k<N;k++) { 
			
			for(int i=0;i<k;i++) { 
				System.out.print(" ");
			}
			for(int j=0;j+k<N;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}