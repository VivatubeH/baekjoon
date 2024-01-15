import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		if ( A == B ) System.out.println(A);
		else if ( B == C ) System.out.println(B);
		else if ( A == C ) System.out.println(C);
		else {
			if ( (A-B)*(A-C) < 0 ) System.out.println(A);
			else if ((B-A)*(B-C)<0) System.out.println(B);
			else if ((C-A)*(C-B)<0) System.out.println(C);
		}
		in.close();
		}
}
