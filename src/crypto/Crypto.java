public class Crypto {
    public static void main(String[] args) {
        String mode ="dec";
        char[] dataText = args[5].toCharArray();
        int keyNumber = Integer.parseInt(args[3]);
        if (args[1].equals(mode)){
            for (int x = 0; x < dataText.length; x = x + 1) {
	            int y = (int)dataText[x]-keyNumber;
                System.out.print((char)y);
	        } 
        }   
        else {
            for (int x = 0; x < dataText.length; x = x + 1) {
	            int y = (int)dataText[x]+keyNumber;
                System.out.print((char)y);
            }
        }
    }
}
