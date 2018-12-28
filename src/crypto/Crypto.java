package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state = "";
        String message = "";
        int key = 0;
        String result = "";

        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                state = args[i + 1];
                i++;
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
                i++;
            } else if ("-data".equals(args[i])) {
                message = args[i + 1];
                i++;
            }
        }

        if ("".equals(message)) {
            System.out.print("Enter text: ");
            message = scanner.nextLine();
        }

        if ("".equals(state)) {
            state = "enc";
        }

        if (key == 0) {
            System.out.print("Enter key: ");
            key = scanner.nextInt();
        }

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
