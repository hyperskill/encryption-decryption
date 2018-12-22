package crypto;

import crypto.algorithms.CaesarAlgorithm;
import crypto.algorithms.CryptoAlgorithm;
import crypto.algorithms.MorseAlgorithm;
import crypto.algorithms.VigenereAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crypto {
    private CryptoAlgorithm algorithm;
    private  static List<String> argsList;
    public static void main(String[] args) {
        final String MODE = "-mode";
        final String KEY= "-key";
        final String DATA= "-data";
        final String IN = "-in";
        final String OUT = "-out";
        final String ALG = "-alg";

        Scanner scanner = new Scanner(System.in);

        String target = "enc";
        String message = null;
        String processed = null;
        String chiperKey;
        String alg  = "caesar";
        int index = -1;
        String value;
        argsList = Arrays.asList(args);

        /*Algorithm*/
        value = findArgValue(ALG);
        alg = (value != null) ? value: alg;
        final Crypto app = new Crypto(alg);

        /*Mode*/
        value = findArgValue(MODE);
        if(value != null){
            target = value;
        }

        /*Input*/
        value = findArgValue(IN);
        if(value != null){
            try {
                message = readFromFile(value);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else{
            value = findArgValue(DATA);
            if(value != null){
                message = value;
            } else{
                System.out.println("Enter data:");
                message = scanner.nextLine();
            }
        }

        /*Key*/
        value = findArgValue(KEY);
        if(value != null){
            chiperKey = value;
        } else{
            System.out.println("Enter key:");
            chiperKey = scanner.nextLine();

        }

        /*Get message*/
        if(target.equals("dec")){
            processed = app.dec(message, chiperKey);
        } else{
            processed = app.enc(message, chiperKey);
        }

        /*Output*/
        value = findArgValue(OUT);
        if(value != null){
            try {
                writeToFile(value, processed);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else{
            System.out.println(processed);
        }
    }
    public static String findArgValue(String key){
        int index = argsList.indexOf(key);
        if(index != -1){
            return argsList.get(index+1);
        }
        return null;
    }

    public Crypto(String alg) {
        switch (alg) {
            case "caesar":
                this.algorithm = new CaesarAlgorithm();
                break;
            case "morse":
                this.algorithm = new MorseAlgorithm();
                break;
            case "vigenere":
                this.algorithm = new VigenereAlgorithm();
                break;
            default:
                this.algorithm = new CaesarAlgorithm();
        }
    }
    private String enc(String data, String key){
        return algorithm.enc(data, key);
    }
    private String dec(String data, String key){
        return algorithm.dec(data, key);
    }
    private static String readFromFile(String filename) throws IOException {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println("Not found file " + filename);
            throw e;
        }
    }
    private static void writeToFile(String filename, String data) throws IOException {
        File outputFile = new File(filename);
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(data);
            System.out.println("Success! Write to: " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Cannot write output message to file");
            throw e;
        }
    }


}
