import java.util.*;

public class Main {
    public static String binary(int number){
        LinkedList<Integer> stack = new LinkedList<>();
        if (number == 0)
            stack.push(0);

        while (number > 0) {
            stack.push(number % 2);
            number = number/2;
        }
        ArrayList<String> BinaryResult  = new ArrayList<>();
        while(!stack.isEmpty()) {
            BinaryResult.add(stack.pop().toString());
        }
        return String.join(" ",BinaryResult);
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Give Number to convert to binary: ");
            int number = sc.nextInt();

            for (int i = 0; i <= number; i++) {
                System.out.printf("%3d: %s\n", i, binary(i));
            }
        }


    }
}
