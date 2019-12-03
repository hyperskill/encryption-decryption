package crypto;

import crypto.strategy.CryptContext;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Crypto {

    private String mode = "enc";
    private String data = "";
    private int key;
    private String result;
    private String outputFile = "";
    private String algorithm;
    private String inputFile = "";

    public Crypto(String mode, String data, int key, String outputFile, String algorithm) {
        this.mode = mode;
        this.data = data;
        this.key = key;
        this.outputFile = outputFile;
        this.algorithm = algorithm;
    }

    public Crypto() {

    }

    public void invoke(String[] args) {
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
    }

    public void start() {
        fillParams();

        if (!inputFile.isEmpty()) {
            data = CryptoUtility.readFromFile(inputFile);
        }

        process();

        makeResult();
    }

    private void fillParams() {
        if (key == 0) {
            key = Integer.valueOf(CryptoUtility.getUserInput("key"));
        }
        if (inputFile.isEmpty() && data.isEmpty()) {
            data = CryptoUtility.getUserInput("message for encryption");
        }
    }

    private void process() {
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
    }

    private void makeResult() {
        if (!outputFile.isEmpty()) {
            File file = new File("crypto/" + outputFile);
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
