import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str5 ="enc";
    String str1 = scanner.nextLine();
	String text = scanner.nextLine();
	Integer number = scanner.nextInt();
	char[] str2 = text.toCharArray();
	if(str1.equals(str5)){
	    for (int x = 0; x < str2.length; x = x + 1) {
	    int y = (int)str2[x]+number;
        System.out.print((char)y);
	    }
	}
	else{
	   for (int x = 0; x < str2.length; x = x + 1) {
	    int y = (int)str2[x]-number;
        System.out.print((char)y);
	    }
	}
    }
}

