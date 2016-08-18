import java.util.Scanner;

/**
 * Created by alexe on 18.08.2016.
 */
public class Task01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //Data input from a keyboard
        int add1 = scan.nextInt(); // The weight of a candy
        int add2 = scan.nextInt(); // The weight of a tangerine
        int add3 = scan.nextInt(); // The weight of an apple
        int sum = scan.nextInt(); // The total weight
        scan.close();

        int check = 0;
        int num = 0;

        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= sum; j++) {
                for (int k = 0; k <= sum; k++) {
                    check = i * add1 + j * add2 + k * add3; // The checking of combinations
                    if (check == sum) {
                        num++; // Count the number of variants
                    }
                    if (check > sum) { // Exit if the option is bigger than the total weight
                        check = 0;
                        break;
                    }
                }
                if (check > sum) { // Exit if the option is bigger than the total weight
                    check = 0;
                    break;
                }
            }
            if (check > sum) break; // Exit if the option is bigger than the total weight
        }
        System.out.println(num); // Output of the result
    }
}

