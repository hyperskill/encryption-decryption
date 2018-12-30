package crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crypto {

    public static void main(String[] args) {
        String operation = "";
        String message = "";
        int key = 0;
        String result;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            operation = bf.readLine();
            message = bf.readLine();
            key = Integer.valueOf(bf.readLine());
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
