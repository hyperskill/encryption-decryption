package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String target = scanner.nextLine();
//        String message = "Wabc";
        String message = scanner.nextLine();
        int offset = scanner.nextInt();

        if(target.equals("enc")){
            System.out.println(enc(message, offset));
        } else if(target.equals("dec")){
            System.out.println(dec(message, offset));
        }

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
