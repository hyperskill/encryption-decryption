package crypto;

import java.util.Arrays;
import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {
        Crypto m = new Crypto();
        m.startWithArgs(args);
    }

    public void startWithArgs(String[] args) {
        if (args.length == 6) {
            if (args[0].equals("-mode") && args[2].equals("-key") && args[4].equals("-data")) {
                switch (args[1]) {
                    case "dec":
                        System.out.println(decrypt(args[5], Integer.parseInt(args[3])));
                        break;
                    case "enc":
                        System.out.println(encrypt(args[5], Integer.parseInt(args[3])));
                        break;
                }
            }
        } else {
            System.out.println("bad args");
            return;
        }
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
            result.append((char)(message.charAt(i) + key));
        }
        return result.toString();
    }

    public String decrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append((char)(message.charAt(i) - key));
        }
        return result.toString();
    }

}
