package crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class CryptoUtility {

    private CryptoUtility() {

    }

    public static String readFromFile(final String inputFile) {
        final File file = new File("crypto/" + inputFile);
        final StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
        }
        return stringBuilder.toString();
    }

    public static String getUserInput(final String message) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", message);
        userInput = scanner.nextLine();
        return userInput;
    }
}
