package crypto;

import java.util.*;

import translater.Translater;
import translater.TranslaterFactory;

public class Crypto {
    public static void main(String[] args) {
    	String cmd = new String("");
    	int key = 0;
    	String message = new String("");
    	boolean check = false;
    	for (int i = 0; i < args.length; i++) {
    		if ("-mode".equals(args[i])) {
    			cmd = args[++i];
    			continue;
    		}
    		if ("-key".equals(args[i])) {
    			key = Integer.parseInt(args[++i]);
    			continue;
    		}
    		if ("-data".equals(args[i])) {
    			message = args[++i];
    			check = true;
    			continue;
    		}
    	}
    	if (!check) {
    		Scanner scanner = new Scanner(System.in);
    		message = scanner.next();
    		key = scanner.nextInt();
    		scanner.close();    		
    	}
    	Translater translater = TranslaterFactory.getTranslater(cmd,message,key);
    	System.out.println(translater.translate());
    }
}
