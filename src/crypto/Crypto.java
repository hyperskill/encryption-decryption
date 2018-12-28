package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String state = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        String result = "";

        if ("enc".equals(state)) {
            result = encryption(message, key);
        }

        if ("dec".equals(state)) {
            result = decryption(message, key);
        }

        System.out.println(result);
    }

    public static String encryption(String message, int key) {
        String encrypt = "";
        for (int i = 0; i < message.length(); i++) {
            int index = message.charAt(i);

            if (index != -1) {
                int newIndex = index + key;
                char c = (char) newIndex;
                encrypt += c;
            } else {
                encrypt += String.valueOf(index);;
            }
        }

        return encrypt;
    }

    public static String decryption(String message, int key) {
        String encrypt = "";
        for (int i = 0; i < message.length(); i++) {
            int index = message.charAt(i);

            if (index != -1) {
                int newIndex = index - key;
                char c = (char) newIndex;
                encrypt += c;
            } else {
                encrypt += String.valueOf(index);;
            }
        }

        return encrypt;
    }
}
