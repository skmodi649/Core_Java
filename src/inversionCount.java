import java.util.Scanner;

public class inversionCount {
    static int inversionCount(int arr[]){
        int count_inversion=0;
        for(int i=0;i< arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                    count_inversion++;
            }
        }
        return count_inversion;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array : ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int ans=inversionCount(arr);
        System.out.println("Inversion count of the given array is: "+ans);
    }
}
