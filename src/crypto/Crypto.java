package crypto;

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
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();
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
