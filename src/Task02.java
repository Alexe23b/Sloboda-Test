import java.util.Scanner;

/**
 * Created by alexe on 19.08.2016.
 */
public class Task02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //Data input from a keyboard
        int n = scan.nextInt(); // The amount of sheets
        int time1 = scan.nextInt(); // Copy time of 1st Xerox
        int time2 = scan.nextInt(); // Copy time of 2nd Xerox
        scan.close();
        int timeMin;
        int timeMax;
        int odds = 0;
        int result;

        if (time1 < time2) { // Definition of the more fast copier
            timeMin = time1;
            timeMax = time2;
        } else if (time1 > time2) {
            timeMin = time2;
            timeMax = time1;
        } else { // if time1 = time2
            if (n % 2 != 0) { // if n is odd
                result = time1 + (n - 1) * time1 / 2;
            } else { // if n is an even
                result = time1 + n * time1 / 2;
            }
            System.out.println(result);
            return;
        }
        for (int i = 1; i < n; i++) {
            if (i * timeMax > (n - 1 - i) * timeMin) { // Definition numbers of copies for the slow copier
                break;
            } else {
                odds = i;
            }
        }

        result = timeMin + (n - 1 - odds) * timeMin; // Minimum copy time
        System.out.println(result);
    }
}
