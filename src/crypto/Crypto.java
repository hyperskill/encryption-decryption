package crypto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {
        String operation = "enc";
        String message = "";
        int key = 0;
        String result;
        String inputFile = "";
        String outputFile = "";

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
                case "-in":
                    inputFile = args[i + 1];
                    break;
                case "-out":
                    outputFile = args[i + 1];
                    break;
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            if (key == 0) {
                key = Integer.valueOf(br.readLine());
            }
            if (!inputFile.isEmpty() && !message.isEmpty()) {
                message = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.isEmpty()) {
            File file = new File("/mnt/hgfs/share_vm/IdeaProjects/encryption-decryption/src/crypto/"
                    + inputFile);
            StringBuilder sb = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            message = sb.toString();
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

        if (!outputFile.isEmpty()) {
            File file = new File("/mnt/hgfs/share_vm/IdeaProjects/encryption-decryption/src/crypto/"
                    + outputFile);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(result);
        }
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
