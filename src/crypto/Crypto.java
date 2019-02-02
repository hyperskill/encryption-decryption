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
        String message, target;
        int key;
        int indTarget=-1, indMessage=-1, indKey=-1;
        for (int i=0; i<args.length-1; i++){
            if(args[i].equals("-mode")) indTarget=i;
            if(args[i].equals("-key")) indKey=i;
            if(args[i].equals("-data")) {indMessage=i; break;}
        }

        if(indTarget>=0) target=args[indTarget+1];
        else target="enc";
        if (indKey>=0) key=Integer.valueOf(args[indKey+1]);
        else key = scan.nextInt();
        if (indMessage>=0) message=args[indMessage+1];
        else message = scan.nextLine();
        if (target.equals("enc") || target.equals("")) encryption(message, key);
        else decryption(message, key);

    }
}
