public class Crypto {
    public static void main(String[] args) {
      //  File file = new File(args[7]);
      //  Scanner scanner = new Scanner(file);
        String mode ="dec";
        String comm = "in";
        String data = "data";
        if(args[4].equals(data)){
            char[] dataText = args[5].toCharArray();
            int keyNumber = Integer.parseInt(args[3]);
      
            if (args[1].equals(mode)){
            for (int x = 0; x < dataText.length; x = x + 1) {
	            int y = (int)dataText[x]-keyNumber;
                System.out.print((char)y);
	            } 
            }   
            }else {
                 File file = new File(args[5]);
                 Scanner scanner = new Scanner(file);  
                 String data1 = scanner.nextLine();
                 char[] dataText = data1.toCharArray();
            int keyNumber = Integer.parseInt(args[3]);
      
            if (args[1].equals(mode)){
            for (int x = 0; x < dataText.length; x = x + 1) {
	            int y = (int)dataText[x]-keyNumber;
                System.out.print((char)y);
	            } 
            }   
                
            }
            
            File file = new File(args[7]);
            FileWriter writer = new FileWriter(file); 
    }
}
