package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String cmd = scanner.nextLine();
    	String message = scanner.nextLine();
    	int key = scanner.nextInt();
    	scanner.close();
    	Translater translater = TranslaterFactory.getTranslater(cmd,message,key);
    	System.out.println(translater.translate());
    }
}
