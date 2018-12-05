package crypto;

import java.util.Scanner;

public class Crypto {

    private static Scanner scanner;
    private static char[] array;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String value = scanner.nextLine();
        String string = scanner.nextLine();
        int key = scanner.nextInt();

        if(value.equals("enc")) {
            encryption(string, key);
        } else if(value.equals("des")) {
            descryption(string, key);
        }
    }

    private static void descryption(String string, int key) {
        char[] arrayString = string.toCharArray();
        array = new char[string.length()];

        for(int i = 0; i < array.length; i++) {
            array[i] = (char) (arrayString[i] - key);
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    private static void encryption(String string, int key) {
        char[] arrayString = string.toCharArray();
        array = new char[string.length()];

        for(int i = 0; i < array.length; i++) {
            array[i] = (char) (arrayString[i] + key);
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
