import classes.Index;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Index in = new Index();

        try (Scanner sc = new Scanner(System.in)) {
            String str ="";
            while (true) {
                System.out.print("Give Word: ");
                str = sc.next();

                if(str.equals("quit"))
                    break;

                char[] characters = str.toCharArray();
                boolean valid = true;

                for(var elem: characters){
                    if(!Character.isAlphabetic(elem)){
                        System.out.println("Wrong input! ");
                        valid=false;
                        break;
                    }
                }
                if(valid)
                    in.add(str.toLowerCase());
            }
            System.out.println(in);
        }
    }
}
