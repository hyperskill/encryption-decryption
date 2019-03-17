package crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Crypto {
    interface  Strategy {
        String encrypt(String text, int key);
        String decrypt(String text, int key);
    }
    public class Xor implements Strategy{
        @Override
        public String encrypt(String text, int key) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                sb.append((char) (text.charAt(i) ^ key));
            }
            return sb.toString();
        }
        @Override
        public String decrypt(String text, int key) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                sb.append((char) (text.charAt(i) ^ key));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> params = new HashMap<>();
        for (int i = 0; i < args.length / 2; i++) {
            params.put(args[i], args[i + 1]);
        }
        String operation = params.get("-mode");
        String text = params.get("-data");
        int key = Integer.parseInt(params.get("-key"));
        String inputFileName = params.get("-in");
        String outputFileName = params.get("-out");
        String algorithm = params.get("-alg");
        Strategy strategy;
        //if (algorithm.isEmpty()) {
            strategy = new Crypto().new Xor();
        //}
        if (operation.isEmpty()) {
            operation = "enc";
        }
        if (!text.isEmpty() && !inputFileName.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            key = scanner.nextInt();
            scanner.close();
        }
        if (inputFileName.isEmpty()) {
            String result = "";
            switch (operation) {
                case "enc":
                    result = strategy.encrypt(text, key);
                    break;
                case "dec":
                    result = strategy.decrypt(text, key);
                    break;
            }
            if (outputFileName.isEmpty()) {
                System.out.println(result);
            } else {
                try {
                    FileWriter writer = new FileWriter(new File(outputFileName));
                    writer.write(result);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } else {
            try {
                Scanner scanner = new Scanner(new File(inputFileName));
                while (scanner.hasNextLine()) {
                    String result = "";
                    switch (operation) {
                        case "enc":
                            result = strategy.decrypt(scanner.nextLine(), key);
                            break;
                        case "dec":
                            result = strategy.decrypt(scanner.nextLine(), key);
                            break;
                    }
                    if (outputFileName.isEmpty()) {
                        System.out.println(result);
                    } else {
                        try {
                            FileWriter writer = new FileWriter(new File(outputFileName));
                            writer.write(result);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Input file does not exist");
            }
        }
    }
}