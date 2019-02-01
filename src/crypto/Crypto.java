package crypto;

import java.util.Scanner;

public class Crypto {
    private static void encryption(String message, int key) {
        char let;
        char let2;
        StringBuilder str = new StringBuilder(message);
        for (int i=0; i<str.length(); i++){
            let = str.charAt(i);
            let2=(char)(let+key);
                str.setCharAt(i, let2);}
        System.out.println(str);
    }
    private static void decryption(String message, int key) {
        char let;
        char let2;
        StringBuilder str = new StringBuilder(message);
        for (int i=0; i<str.length(); i++){
            let = str.charAt(i);
            let2=(char)(let-key);
            str.setCharAt(i, let2);}
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine();
        String message = scan.nextLine();
        int key = scan.nextInt();
        if (target.equals("enc")) {
            encryption(message, key);
        }
        else if (target.equals("dec")) decryption(message, key);

    }
}
