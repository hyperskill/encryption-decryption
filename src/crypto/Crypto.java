package crypto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state = "enc";
        String message = "";
        int key = 0;
        String result = "";
        String in = "";
        String out = "";

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
            } else if ("-in".equals(args[i])) {
                in = args[i + 1];
                i++;
            } else if ("-out".equals(args[i])) {
                out = args[i + 1];
                i++;
            }
        }

        if (key == 0) {
            System.out.print("Enter key: ");
            key = scanner.nextInt();
        }

        if (!in.equals("")) {
            File input = new File(in);
            if (input.exists()) {
                try {
                    message = new String(Files.readAllBytes(Paths.get(input.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (message.equals("")) {
            System.out.print("Enter text: ");
            message = scanner.nextLine();
        }

        if ("enc".equals(state)) {
            result = encryption(message, key);
        }

        if ("dec".equals(state)) {
            result = decryption(message, key);
        }

        if (out.equals("")) {
            System.out.println(result);
        } else {
            File output = new File(out);
            boolean created = true;
            if (!output.exists()) {
                try {
                    created = output.createNewFile();
                } catch (IOException e) {
                    created = false;
                    System.out.println("Cannot create the file: " + output.getPath());
                }
            }
            if (created) {
                try {
                    FileWriter writer = new FileWriter(output);
                    writer.write(result);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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
