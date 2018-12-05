package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();
        String text = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());
        String alph = "abcdefghijklmnopqrstuvwxyz";
        String enctext = "";
        switch (mode) {
            case "enc":
                for (char c : text.toLowerCase().toCharArray()) {
                    int i = alph.indexOf(c);
                    if (i != -1) {
                        enctext += alph.charAt(i + key < alph.length() ? i + key : i + key - alph.length());
                    } else {
                        enctext += c;
                    }
                }
                break;
            case "dec":
                for (char c : text.toLowerCase().toCharArray()) {
                    int i = alph.indexOf(c);
                    if (i != -1) {
                        enctext += alph.charAt(i - key > 0 ? i - key : i - key + alph.length());
                    } else {
                        enctext += c;
                    }
                }
                break;
        }
        System.out.println(enctext);

    }
}
