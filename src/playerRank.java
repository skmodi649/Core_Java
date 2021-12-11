import java.util.*;
public class playerRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players in the contest : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the scores of the players : ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Now we will find the Winner , second winner , loser and the second loser

        int first = -9999, second = -9999, last = 100000, secondlast = 100000;
        for (int i = 0; i < n; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (second < arr[i] && first > arr[i]) {
                second = arr[i];
            }
            if (arr[i] < last) {
                secondlast = last;
                last = arr[i];
            } else if (secondlast > arr[i] && arr[i] != last) {
                secondlast = arr[i];
            }
        }
        System.out.println("Winner : " + first);
        System.out.println("Second Winner : " + second);
        System.out.println("Last : " + last);
        System.out.println("Second Last : " + secondlast);
    }
}
