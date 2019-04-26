import java.util.*;
import java.io.*;
public final class UnsecureCode{
    private UnsecureCode() {}
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

        boolean flag = true;
        System.out.println("Greeting! Welcome");
        // Console console = System.console();a

        while (flag) {

            System.out.println("1: Login \n2: Sign up \n3: Exit");
            String option = scan.nextLine();

            switch(option) {

                case "1":
                    boolean flag1 = true;
                    int count = 0;

                    while(flag1) {
                        System.out.print("Enter your UserName: ");
                        String userN = scan.nextLine();
                        // String userN = console.readLine("Enter UserName: ");
                        // char[] passWord = console.readPassword("Enter Password: ");
                        // String pass = new String(passWord);
                        System.out.print("Enter your Password: ");
                        String pass = scan.nextLine();
                        if(map.containsKey(userN) &&(map.get(userN)).equals(pass)) {
                            System.out.println("Login Successfully done");
                            flag1 = false;
                        }
                        else {
                            System.out.println("Login got Failed");
                            count++;
                        }
                    }
                break;
                case "2":
                boolean flag2 = true;
                while (flag2) {
                    System.out.print("Enter your UserName: ");
                    String userName = scan.nextLine();
                    if (map.containsKey(userName)) {
                        System.out.println("UserName already exists");
                    } else {
                        flag2 = false;
                        System.out.print("Enter your Password: ");
                        String passw = scan.nextLine();
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
                    System.out.println("Thank You, visit again");
                    flag = false;
                    break;
                default: break;
        }
    }
}
}