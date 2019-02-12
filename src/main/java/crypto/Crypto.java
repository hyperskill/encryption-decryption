package crypto;

import java.util.Scanner;

public class Crypto {

    private static final String ENCRYPTION = "enc";
    private static final String DECRYPTION = "dec";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String message = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());

        String outputString;

        if (ENCRYPTION.equals(operation)) {
            outputString = encrypt(message, key);
        } else if (DECRYPTION.equals(operation)) {
            outputString = decrypt(message, key);
        } else {
            throw new UnsupportedOperationException("Operation '" + operation + "' is not supported.");
        }

        System.out.println(outputString);
    }

    public static String encrypt(String message, int key) {
        char[] sourceData = message.toCharArray();
        char[] transformData = new char[sourceData.length];

        for (int i = 0; i < sourceData.length; i++) {
            transformData[i] = (char) (sourceData[i] + key);
        }

        return new String(transformData);
    }

    public static String decrypt(String message, int key) {
        char[] sourceData = message.toCharArray();
        char[] transformData = new char[sourceData.length];

        for (int i = 0; i < sourceData.length; i++) {
            transformData[i] = (char) (sourceData[i] - key);
        }

        return new String(transformData);
    }
}
