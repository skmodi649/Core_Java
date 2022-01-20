import java.util.Scanner;

public class crc_check {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the data array: ");
        size = scan.nextInt();
        int[] input_data = new int[size];
        System.out.println("Enter data bits in the array one by one: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter bit " + (size - i) + ":");
            input_data[i] = scan.nextInt();
        }
        System.out.println("Enter the size of the divisor array:");
        size = scan.nextInt();
        int divisor[] = new int[size];
        System.out.println("Enter divisor bits in the array one by one: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter bit " + (size - i) + ":");
            divisor[i] = scan.nextInt();
        }

    }
}
