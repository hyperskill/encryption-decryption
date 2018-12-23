package crypto;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Crypto {

    private Scanner scn;
    private FileWriter fw;

    public static void main(String[] args) {
        Crypto m = new Crypto();
        m.startWithArgs(args);
    }

    public void startWithArgs(String[] args) {
        if (args.length < 6) {
            return;
        }
        String mode = "";
        String data = "";
        int key = 0;
        if (!args[0].equals("-mode")) {
            System.out.println("Bad args");
            return;
        } else {
            mode = args[1];
        }
        if (!args[2].equals("-key")) {
            System.out.println("Bad args");
            return;
        } else {
            key = Integer.parseInt(args[3]);
        }
        if (args[4].equals("-data")) {
            data = args[5];
        } else if (args[4].equals("-in")) {
            try {
                scn = new Scanner(new File(args[5]));
                while (scn.hasNextLine()) {
                    data += scn.nextLine() + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            scn = new Scanner(System.in);
            data = scn.nextLine();
        }
        if (args.length > 6) {
            if (args[6].equals("-out")) {
                try {
                    fw = new FileWriter(new File(args[7]));
                    fw.write(data);
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(data);
        }

    }

    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append((char)(message.charAt(i) + key));
        }
        return result.toString();
    }

    public String decrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append((char)(message.charAt(i) - key));
        }
        return result.toString();
    }

}
