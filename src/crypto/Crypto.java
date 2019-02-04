package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String mess = scanner.nextLine();
        int key = scanner.nextInt();
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
