import java.util.*;
import java.io.*;
public final class SecureCode{
	private SecureCode() {}
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
        
        try {
            FileReader readFile = new FileReader("DataBaseInformation.txt");
            BufferedReader readBuffer  = new BufferedReader(readFile);
            String read;

            while((read = readBuffer.readLine()) != null) {
                String[] input = read.split(" ");
                map.put(input[0], input[1]);
            }
            readFile.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        boolean condition = true;
        System.out.println("Greetings! Welcome");
        Console console = System.console();

        while (condition) {

			System.out.println("1: Login \n2: Sign up \n3: Exit");
            String option = scan.nextLine();

            switch(option) {

                case "1":
                    boolean flag1 = true;
                    int count = 0;

                    while(flag1) {
                        String userN = console.readLine("Enter your UserName: ");
                        char[] passWord = console.readPassword("Enter your Password: ");
                        String pass = new String(passWord);
                        if(map.containsKey(userN) &&(map.get(userN)).equals(pass)) {
                            System.out.println("Login was Successful");
                            flag1 = false;
                        }
                        else {
                            System.out.println("Login got Failed");
                            count++;
                        }
                        if(count == 3) {
                            flag1 = false;
                            System.out.println("\nAccess Denied");
                            break;
                        }
                    }
                break;
                case "2":
                boolean flag2 = true;
                while (flag2) {
                    String userName = console.readLine("Enter your UserName: ");
                    if (map.containsKey(userName)) {
                        System.out.println("UserName already exists");
                    } else {
                        flag2 = false;
                        char[] password = console.readPassword("Enter your Password: ");
                        String passw = new String(password);
                        try {
                            FileWriter writer = new FileWriter("DataBaseInformation.txt", true);
                            writer.write(userName + " " + passw + "\n");
                            map.put(userName, passw);
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Login was Successful");
                    }
                    break;
                }
                break;
                case "3":
                    System.out.println("Thank You, Visit again");
                    condition = false;
                    break;
                default: break;
		}
	}
}
}