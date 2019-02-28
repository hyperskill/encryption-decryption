package crypto;

import java.util.Scanner;

public class Crypto {
    static String operation;
    static String inputText;
    static int key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            operation = scanner.nextLine();
        }
        if (scanner.hasNextLine()) {
            inputText = scanner.nextLine();
        }
        if (scanner.hasNextInt()) {
            key = scanner.nextInt();
        }
        if("enc".equals(operation)){
            encrypt(inputText, key);
        }else if("dec".equals(operation)){
            decrypt(inputText, key);

        }

    }

    public static void encrypt(String text, int key) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]+key);
            charText[i] = tmp;
        }
        String encryptText = new String(charText);
        System.out.println(encryptText);
    }

    public static void decrypt(String text, int key) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]-key);
            charText[i] = tmp;
        }
        String decryptText = new String(charText);
        System.out.println(decryptText);
    }
}
