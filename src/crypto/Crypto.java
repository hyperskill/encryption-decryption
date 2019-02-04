package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        int key = 0;
        String operation = "enc";
        if(args[0].equals("-mode")){
            operation = args[1];
        }
        if (args[2].equals("-key")){
            key = Integer.parseInt(args[3]);
        }
        String mess = args[args.length - 1];

        StringBuilder sb = new StringBuilder(mess);
        for (int i = 0; i < sb.length(); i++) {
            if(operation.equals("enc")) {
                sb.setCharAt(i, (char) (sb.charAt(i) + key));
            }else{
                sb.setCharAt(i, (char) (sb.charAt(i) - key));
            }
        }
        System.out.println(sb);
    }
}
