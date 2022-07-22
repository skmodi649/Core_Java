import java.util.Scanner;

public class Opengenus_QuickSort_HoarePartition {
    public int partition_Hoare(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                return j;
            // swapping the two values
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void quick_sort(int[] arr, int l, int h){
        if(l < h){
            int pivot = partition_Hoare(arr, l, h);
            quick_sort(arr, l, pivot);
            quick_sort(arr, pivot+1, h);
        }
    }
    public static void main(String[] args){
        int[] arr = {0, -5, 16, 10, 9, 8, 12};
        Opengenus_QuickSort_HoarePartition obj = new Opengenus_QuickSort_HoarePartition();
        obj.quick_sort(arr, 0, 6);
        System.out.print("Sorted Array: ");
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
    }
}
