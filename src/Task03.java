import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alexe on 19.08.2016.
 */
public class Task03 {


    public Task03() {
        super();
    }

    public static void main(String[] args) {
        ArrayList<Integer> friends[];
        Scanner scan = new Scanner(System.in); //Data input from a keyboard
        int n = scan.nextInt(); // amount of people in the company
        Integer s = scan.nextInt() - 1; // a specific number of person

        int persons[][] = new int[n][n]; // 2-x array for input a matrix
        friends = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            friends[i] = new ArrayList<>(); // lists of friends for each person
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                persons[i][j] = scan.nextInt(); // matrix filling
                if (persons[i][j] != 0) {
                    friends[i].add(j); // adding friends for each person
                }
            }
        }
        scan.close();

        HashSet<Integer> tempSet = new HashSet<>(); // auxiliary set
        tempSet.addAll(friends[s]);

        HashSet<Integer> resultSet = new HashSet<>(); // list of all friends
        resultSet.add(s);

        while (friends[s].size() != 0) {
            for (int x : friends[s]) { //a search of friends for "s"-th person

                friends[x].removeAll(resultSet); // a removal "s"-th person from lists of his friends
                resultSet.add(x); // adding a friend to a result

                tempSet.remove(x); // intermediate calculations
                tempSet.addAll(friends[x]);
            }
            friends[s].clear();
            friends[s].addAll(tempSet);
        }
        resultSet.remove(s); // removal "s"-person from a result

        System.out.println(resultSet.size()); // result output
    }
}
