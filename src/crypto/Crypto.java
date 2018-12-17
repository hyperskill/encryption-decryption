package crypto;

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
    public static void main(String[] args) {
        final String MODE = "-mode";
        final String KEY= "-key";
        final String DATA= "-data";
        final String IN = "-in";
        final String OUT = "-out";

        Scanner scanner = new Scanner(System.in);

        String target;
        String message = null;
        String processed = null;
        int offset;
        int index = -1;
        List argsList = Arrays.asList(args);

        /*Mode*/
        index = argsList.indexOf(MODE);
        if(index != -1){
            target = args[index+1];
        } else{
            target = "enc";
        }

        /*Input*/
        index = argsList.indexOf(IN);
        if(index != -1){
            try {
                message = new String(Files.readAllBytes(Paths.get(args[index + 1])));
            } catch (IOException e) {
                System.out.println("Not found file " + args[index + 1]);
            }
        } else{
            index = argsList.indexOf(DATA);
            if(index != -1 && message != null){
                message = args[index + 1];
            } else{
                System.out.println("Enter data:");
                message = scanner.nextLine();
            }
        }

        /*Key*/
        index = argsList.indexOf(KEY);
        if(index != -1){
            offset = Integer.parseInt(args[index+1]);
        } else{
            System.out.println("Enter key:");
            offset = scanner.nextInt();

        }

        if(target.equals("enc")){
            processed = enc(message, offset);
        } else if(target.equals("dec")){
            processed = dec(message, offset);
        }

        /*Output*/
        index = argsList.indexOf(OUT);
        if(index != -1){
            File outputFile = new File(args[index + 1]);
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(processed);
            } catch (IOException e) {
                System.out.println("Cannot write output message to file");
            }
        } else{
            System.out.println(processed);
        }
    }

    public Crypto() {
    }

    public static String enc(String originalStr, int offset){
        return offsetAll(originalStr, offset);
    }

    public static String dec(String originalStr, int offset){
        return offsetAll(originalStr, -offset);
    }
    public static String offsetAll(String originalStr, int offset){
        final int lettersStar = 97;
        final int lettersAmount = 26;

        StringBuilder out = new StringBuilder();
        char[] letters = new char[originalStr.length()];
        originalStr.getChars(0, originalStr.length(), letters, 0  );

        for (int letter : letters){
            letter = (letter + offset);
            out.append((char)letter);
        }

        return out.toString();
    }
}
