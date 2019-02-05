package crypto;
import java.util.Scanner;
import java.io.*;
public class Crypto {
    private static void encryption(String message, int key, String out) {
        char let;
        char let2;
        StringBuilder str = new StringBuilder(message);
        for (int i=0; i<str.length(); i++){
            let = str.charAt(i);
            let2=(char)(let+key);
            str.setCharAt(i, let2);}
        if (out.length()>0){
            File file = new File(out);
           try(FileWriter writer = new FileWriter(file)){
               writer.write(str.toString());
           } catch (IOException e){
               System.out.println("The file can not be opened: " + out);
           }

        }
        else  System.out.println(str);
    }
    private static void decryption(String message, int key, String out) {
        char let;
        char let2;
        StringBuilder str = new StringBuilder(message);
        for (int i=0; i<str.length(); i++){
            let = str.charAt(i);
            let2=(char)(let-key);
            str.setCharAt(i, let2);}
        if (out.length()>0){
            File file = new File(out);
            try(FileWriter writer = new FileWriter(file)){
                writer.write(str.toString());
            } catch (IOException e){
                System.out.println("The file can not be opened: " + out);
            }

        }
        else  System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message="", target;
        int key;
        int kostil=0;
        String out="";
        int indTarget=-1, indMessage=-1, indKey=-1, indIn=-1, indOut=-1;
        for (int i=0; i<args.length; i++){
            if(args[i].equals("-mode")) indTarget=i;
            if(args[i].equals("-key")) indKey=i;
            if(args[i].equals("-data")) indMessage=i;
            if(args[i].equals("-in")) indIn=i;
            if(args[i].equals("-out")) indOut=i;
        }

        if(indTarget>=0) target=args[indTarget+1];
        else target="enc";
        if (indKey>=0) key=Integer.valueOf(args[indKey+1]);
        else key = scan.nextInt();

         if (indIn>=0) {
            File in = new File(args[indIn+1]);
            try(Scanner scanner = new Scanner(in)){
                message = scanner.nextLine();
            } catch (FileNotFoundException e){
                System.out.println("File is not found: " + in);
                message=scan.nextLine();
            }
        }
        if (message.length()>0) kostil++;
        else if (indMessage >=0 ) message = args[indMessage+1];
         else message=scan.nextLine();
        if (indOut>=0) {
            out =args[indOut+1];
        }
        System.out.println(out);
        if (target.equals("enc") || target.equals("")) encryption(message, key, out);
        else decryption(message, key, out);

    }
}