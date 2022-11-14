import classes.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static int readInt(Scanner sc, int lower, int upper) {
        int choice;
        while(true) {
            System.out.print("Your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < lower || choice > upper) {
                    System.out.println("Error: Between 1 and 4");
                }
                else
                    return choice;
            }
            else {
                sc.next();
                System.out.println("Error: Invalid input");
            }
        }
    }
    public static void saveFile(String  filename, ArrayList<Users> users){
        File f = new File(filename);
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            for (int i=0; i<users.size(); i++) {
                os.writeObject(users.get(i));
            }
        }
        catch(IOException e) {
            System.err.println(e);
        }
    }
    public static void loadFile(String  filename, ArrayList<Users> users){

        File f = new File(filename);
        try(ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f))))  {

            while(true){
                users.add((Users) os.readObject());

            }
        }
        catch(IOException | ClassNotFoundException e) { }
    }

    public static void main(String[] args) {

        final String filename = "users.bin";
        ArrayList<Users> users = new ArrayList<>();
        loadFile(filename,users);;
        int choice;

        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Menu");
                System.out.println("Press 1 for Register user!");
                System.out.println("Press 2 for Delete user!");
                System.out.println("Press 3 for Print all users!");
                System.out.println("Press 4 Exit!");
                choice=readInt(sc,1,4);

                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("===Insert User===");
                        System.out.print("Give FullName: ");
                        String fullName = sc.nextLine();
                        System.out.print("Give UserName: ");
                        String username = sc.next();
                        System.out.print("Give Password: ");
                        String password = sc.next();
                        System.out.print("Give Role (1-admin, 2-user): ");
                        int role = readInt(sc,1,2);
                        users.add(new Users(fullName, username, password, role ));
                        System.out.println("User has register successfully!");
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("===Delete User===");
                        System.out.print("Give FullName: ");
                        String name = sc.nextLine();
                        boolean found = false;
                        for(int i = 0; i < users.size(); i++){
                            if(users.get(i).getFullName().equals(name)){
                                found = true;
                                users.remove(i);
                                System.out.println("Users has Deleted!");
                                break;
                            }
                        }
                        if (!found)
                            System.out.println("user doesn't exist!");
                        break;

                    case 3:
                        for (int i=0; i< users.size(); i++){
                            System.out.println("All - Users: " +users.get(i));
                        }
                        break;
                    case 4:
                        exit = true;
                        saveFile(filename, users);
                }
            }
        }
    }
}