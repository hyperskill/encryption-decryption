package crypto;

import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {
        Crypto m = new Crypto();
        m.start();
    }

    public void start() {
        Scanner scn = new Scanner(System.in);
        String command = scn.nextLine();
        String message;
        int key;
        switch (command) {
            case "encrypt":
                message = scn.nextLine();
                key = scn.nextInt();
                System.out.println(encrypt(message, key));
                break;
            case "decrypt":
                message = scn.nextLine();
                key = scn.nextInt();
                System.out.println(decrypt(message, key));
                break;
        }
    }

    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append((char) (message.charAt(i) + key));
        }
        return result.toString();
    }

    public String decrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append((char) (message.charAt(i) - key));
        }
        return result.toString();
    }
}
