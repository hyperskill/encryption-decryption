package crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crypto {

    public static void main(String[] args) {
        String operation = "enc";
        String message = "";
        int key = 0;
        String result;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    key = Integer.valueOf(args[i + 1]);
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            if (key == 0) {
                key = Integer.valueOf(br.readLine());
            }
            if (message.isEmpty()) {
                message = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (operation) {
            case "enc":
                result = encrypt(message, key);
                break;
            case "dec":
                result = decrypt(message, key);
                break;
            default:
                result = "Unknown operation!";
        }
        System.out.println(result);
    }

    private static String encrypt(String s, int key) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            sb.append((char) (c + key));
        }
        return sb.toString();
    }

    private static String decrypt(String s, int key) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            sb.append((char) (c - key));
        }
        return sb.toString();
    }
}
