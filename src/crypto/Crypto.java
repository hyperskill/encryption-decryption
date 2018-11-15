package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	
	String act = scanner.nextLine();
        String line = scanner.nextLine();
        int shift = scanner.nextInt();  
        String newLine = "";
        
        switch (act) {
        case "enc":
        	for (int i = 0; i < line.length(); i++) {  	
      			newLine += (char)  (line.charAt(i) + shift);
        	}
        	System.out.print(newLine);  
        	break;
        	
        case "dec":
        	for (int i = 0; i < line.length(); i++) {  	
      			newLine += (char)  (line.charAt(i) - shift);
            	}
        	System.out.print(newLine);  
        	break;
        default:
        	System.out.println("Unknown operation");
        }
    }
}
