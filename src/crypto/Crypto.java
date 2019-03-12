package crypto;

import java.util.HashMap;
import java.util.Scanner;

public class Crypto {
    static String operation="";
    static String inputText="";
    static int key=0;
    static String sKey="";

    public static void main(String[] args) {
        //System.out.println("passed arguments: " + args.length);
        HashMap<String, String> hm = new HashMap();
        for(int i=0; i<args.length; i++){
            if("-mode".equals(args[i])){
                if(args.length>=i+1&&("enc".equals(args[i+1]))||"dec".equals(args[i+1])){
                hm.put(args[i], args[i+1]);
                }else
                {hm.put(args[i],"enc");
                }
            }
            if("-key".equals(args[i])&&args.length>=i+1&&!"-data".equals(args[i+1])){
                hm.put(args[i], args[i+1]);
                }


            if("-data".equals(args[i])&&args.length>=i+1){
            hm.put(args[i], args[i+1]);
            } else if(args.length<i+1){
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    inputText = scanner.nextLine();
                }
                if (scanner.hasNextLine()) {
                    sKey = scanner.nextLine();
                }
                hm.put("-data",inputText);
                hm.put("-key",sKey);
            }

        }

        try{
        key = Integer.parseInt(hm.get("-key"));
        }catch (NullPointerException e){
        }

        if("enc".equals(hm.get("-mode"))){
            encrypt(hm.get("-data"),key);
        }else if ("dec".equals(hm.get("-mode"))){
            decrypt(hm.get("-data"),key);
        }
    }


    public static void encrypt(String text, int key) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]+key);
            charText[i] = tmp;
        }
        String encryptText = new String(charText);
        System.out.println(encryptText);
    }

    public static void decrypt(String text, int key) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            char tmp = (char) (charText[i]-key);
            charText[i] = tmp;
        }
        String decryptText = new String(charText);
        System.out.println(decryptText);
    }
}
