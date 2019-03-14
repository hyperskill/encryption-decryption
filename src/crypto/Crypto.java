import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Crypto4 {
    static String operation="";
    static String inputText="";
    static int key=0;
    static String sKey="";
    static String inputFile="";
    static String outputFile="";

    public static void main(String[] args) {
       /* for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);}*/
        HashMap<String, String> hm = new HashMap();
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                if (args.length >= i + 1 && ("enc".equals(args[i + 1])) || "dec".equals(args[i + 1])) {
                    hm.put(args[i], args[i + 1]);
                } else {
                    hm.put(args[i], "enc");
                }
            }
            if ("-key".equals(args[i]) && args.length >= i + 1 && !"-data".equals(args[i + 1])) {
                hm.put(args[i], args[i + 1]);
            }
            if ("-data".equals(args[i]) && args.length >= i + 1 && !"-in".equals(args[i + 1]) && !"-out".equals(args[i + 1])) {
                hm.put(args[i], args[i + 1]);
            }/* else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter data: ");
                if (scanner.hasNextLine()) {
                    inputText = scanner.nextLine();
                }
                System.out.println("Enter key: ");
                if (scanner.hasNextLine()) {
                    sKey = scanner.nextLine();
                }
                hm.put("-data", inputText);
                hm.put("-key", sKey);
            }*/
            if ("-in".equals(args[i]) && args.length >= i + 1 && !"-out".equals(args[i + 1])) {
                hm.put(args[i], args[i + 1]);
                inputFile=args[i+1];
            }/* else if (args.length < i + 1) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    System.out.println("Enter inputFile: ");
                    inputFile = scanner.nextLine();
                }
                hm.put("-in", inputFile);

            }*/
            if ("-out".equals(args[i]) && args.length >= i + 1) {
                hm.put(args[i], args[i + 1]);
            }}
            System.out.println(Arrays.asList(hm));
            //System.out.println(Collections.singletonList(hm));
            if (!hm.containsKey("-data")){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter data: ");
                if (scanner.hasNextLine()) {
                    inputText = scanner.nextLine();
                }
                System.out.println("Enter key: ");
                if (scanner.hasNextLine()) {
                    sKey = scanner.nextLine();
                }
                hm.put("-data", inputText);
                hm.put("-key", sKey);
            }
        if (!hm.containsKey("-in")){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                System.out.println("Enter inputFile: ");
                inputFile = scanner.nextLine();
            }
            hm.put("-in", inputFile);
        }
        if (!hm.containsKey("-out")){
            hm.put("-out",outputFile);
        }
        //System.out.println(Arrays.asList(hm));
        try {
                key = Integer.parseInt(hm.get("-key"));
            } catch (NullPointerException e) {
            }
        inputFile=hm.get("-in");
        outputFile=hm.get("-out");
            if ("enc".equals(hm.get("-mode"))) {
                encrypt(hm.get("-data"), key, inputFile, outputFile);
            } else if ("dec".equals(hm.get("-mode"))) {
                decrypt(hm.get("-data"), key, inputFile, outputFile);
            }

    }
    //public static void encrypt(String text, int key, String inFile, String outFile) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]+key);
            charText[i] = tmp;
        }
        String encryptText = new String(charText);
        if("".equals(outFile)){
            System.out.println(encryptText);
        }else{
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Java Junior\\Code\\4.Junior-Maven-CSS\\Main\\src\\"+inFile), StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Java Junior\\Code\\4.Junior-Maven-CSS\\Main\\src\\"+outFile), StandardCharsets.UTF_8));){
                int i;
                while((i=reader.read())!=-1){
                    writer.write(i+key);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void decrypt(String text, int key, String inFile, String outFile) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]-key);
            charText[i] = tmp;
        }
        String decryptText = new String(charText);
        if("".equals(outFile)){
            System.out.println(decryptText);
        }else{
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Java Junior\\Code\\4.Junior-Maven-CSS\\Main\\src\\"+inFile), StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Java Junior\\Code\\4.Junior-Maven-CSS\\Main\\src\\"+outFile), StandardCharsets.UTF_8));){
                int i;
                while((i=reader.read())!=-1){
                    writer.write(i-key);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
