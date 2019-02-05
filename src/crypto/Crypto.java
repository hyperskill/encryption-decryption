package crypto;


import java.io.*;
import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int key = 0;
        String mess = "";
        String operation = "enc";
        String fileIn = "";
        String fileOut = "";
        Encoderable encoder = null;
        if(args.length == 6) {
            if (args[0].equals("-mode")) {
                operation = args[1];
            }

            if (args[2].equals("-key")) {
                key = Integer.parseInt(args[3]);
            }
            mess = args[args.length - 1];
        }else if(args.length == 10) {
            if (args[0].equals("-mode")) {
                operation = args[1];
            }
            if(args[2].equals("-alg")){
                if(args[3].equals("morse")){
                    encoder = new Morse();
                }else if(args[3].equals("std")){
                    encoder = new Stand();
                }
            }
            if (args[4].equals("-key")) {
                key = Integer.parseInt(args[5]);
            }
            mess = args[args.length - 1];
            if (args[6].equals("-in")) {
                fileIn = args[7];
            }
            if (args[8].equals("-out")) {
                fileOut = args[9];
            }
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(new File(fileIn)));
                mess = br.readLine();
                br.close();
            } catch (IOException e) {
                System.out.println("Input file doesn't exist");
                e.printStackTrace();

            }

        }else {
            mess = sc.nextLine();
            key = sc.nextInt();
        }
        String res = encoder.encode(mess);
        try(FileWriter fw = new FileWriter(new File(fileOut))) {
            fw.write(res);
            fw.flush();
        } catch (IOException e) {
            System.out.println("Output file name was not found");
            e.printStackTrace();
        }
        System.out.println(res);
    }
}

interface Encoderable{
    String encode(String s);
        }

class Morse implements Encoderable{

    static String morseEncode(char x){
        switch (x)
        {
            case 'a':
                return ".-";
            case 'b':
                return "-...";
            case 'c':
                return "-.-.";
            case 'd':
                return "-..";
            case 'e':
                return ".";
            case 'f':
                return "..-.";
            case 'g':
                return "--.";
            case 'h':
                return "....";
            case 'i':
                return "..";
            case 'j':
                return ".---";
            case 'k':
                return "-.-";
            case 'l':
                return ".-..";
            case 'm':
                return "--";
            case 'n':
                return "-.";
            case 'o':
                return "---";
            case 'p':
                return ".--.";
            case 'q':
                return "--.-";
            case 'r':
                return ".-.";
            case 's':
                return "...";
            case 't':
                return "-";
            case 'u':
                return "..-";
            case 'v':
                return "...-";
            case 'w':
                return ".--";
            case 'x':
                return "-..-";
            case 'y':
                return "-.--";
            // for space
            case 'z':
                return "--..";
        }
        return "";
    }

    static String morseCode(String s)
    {
        // character by character print
        // Morse code
        StringBuilder enc = new StringBuilder();
        for (int i = 0;i<s.length(); i++)
            enc.append(morseEncode(s.charAt(i)));

        return enc.toString();
    }

    @Override
    public String encode(String s) {
        return morseCode(s);
    }
}

class Stand implements Encoderable{

    public String keyCode(String s, int key, String operation){
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if(operation.equals("enc")) {
                sb.setCharAt(i, (char) (sb.charAt(i) + key));
            }else{
                sb.setCharAt(i, (char) (sb.charAt(i) - key));
            }
        }
        return sb.toString();
    }

    @Override
    public String encode(String s) {
        return null;
    }

    public String encode(String s, int key, String oper) {
        return keyCode(s, key, oper);
    }
}

