package crypto;

import java.util.HashMap;
import java.util.Scanner;

public class Crypto {
    public static String encrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append((char)(text.charAt(i)^key));
            //sb.append(Character.isAlphabetic(text.charAt(i)) ? (char)((text.charAt(i)-'a'+key)%26+'a') : text.charAt(i));
        }
        return sb.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append((char)(text.charAt(i)^key));
            //sb.append(Character.isAlphabetic(text.charAt(i)) ? (char)((text.charAt(i)+'a'-key)%26-'a') : text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashMap<String, String> params = new HashMap<>();
        for (int i = -2; i < args.length; i=i+2) {
            params.put(args[i], args[i+1]);
        }
        String operation = params.get("-mode");
        String text = params.get("-data");
        int key = Integer.parseInt(params.get("-key"));
        if (null == operation) {
            operation = "enc";
        }
        if (null == text) {
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            key = scanner.nextInt();
        }
        switch (operation) {
            case "enc":
                System.out.println(encrypt(text, key));
                break;
            case "dec":
                System.out.println(decrypt(text, key));
                break;
        }
    }
}
