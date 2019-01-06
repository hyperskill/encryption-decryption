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
        String mode = "enc";
        String data = "";
        int key = 0;
        String result;
        String inputFile = "";
        String outputFile = "";
        String algorithm = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.valueOf(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inputFile = args[i + 1];
                    break;
                case "-out":
                    outputFile = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            if (key == 0) {
                key = Integer.valueOf(br.readLine());
            }
            if (!inputFile.isEmpty() && !data.isEmpty()) {
                data = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.isEmpty()) {
            File file = new File(
                    "/mnt/hgfs/share_vm/IdeaProjects/encryption-decryption/src/crypto/"
                            + inputFile);
            StringBuilder sb = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            data = sb.toString();
        }

        CryptContext cryptContext = new CryptContext(
                CypherTypes.valueOf(algorithm.toUpperCase()).createCryptStrategy(key));
        switch (mode) {
            case "enc":
                result = cryptContext.encrypt(data);
                break;
            case "dec":
                result = cryptContext.decrypt(data);
                break;
            default:
                result = "Unknown operation!";
        }

        writeResult(outputFile, result);
    }

    private static void writeResult(String outputFile, String result) {
        if (!outputFile.isEmpty()) {
            File file = new File(
                    "/mnt/hgfs/share_vm/IdeaProjects/encryption-decryption/src/crypto/"
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
}
