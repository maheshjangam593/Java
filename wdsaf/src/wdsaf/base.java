package wdsaf;
import java.util.Scanner;
public class base {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Enter a string: ");
		int decimalExample = sc.nextInt();
		String re = "";
	if(decimalExample>6) {
			while (decimalExample > 6) {
				if (decimalExample % 6 == 0) {
					re += Integer.toString(0);
				} else {
					re += Integer.toString(decimalExample % 6);
				}
				decimalExample = decimalExample / 6;
			}
			re+=Integer.toString(0);
	}
	else {
		//
		
	}

		for (int j = re.length() - 1; j >= 0; j--) {
			System.out.println(re.charAt(j));
		}
	}
}
