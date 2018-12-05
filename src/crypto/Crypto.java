package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();
        String text = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println(encode(mode, text, key));
    }

    private static String encode(String mode, String text, int key)
    {
        String enctext = "";
        for (char c : text.toCharArray()) {
            enctext += (char)((int)c+ (mode.equals("enc")?5:mode.equals("dec")?-5:0));
        }
        return enctext;
    }


}
