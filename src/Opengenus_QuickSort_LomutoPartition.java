public class Opengenus_QuickSort_LomutoPartition {
    public int lomuto_partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1; // returning index of the pivot element
    }
    public void quick_sort(int[] arr, int l, int h){
        if(l < h){
            int pivot = lomuto_partition(arr, l, h);
            quick_sort(arr, l, pivot - 1);
            quick_sort(arr, pivot+1, h);
        }
    }
    public static void main(String[] args){
        int[] arr = {0, 5, 16, 10, 9, 8, 12};
        Opengenus_QuickSort_LomutoPartition obj = new Opengenus_QuickSort_LomutoPartition();
        obj.quick_sort(arr, 0, 6);
        System.out.print("Sorted Array: ");
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
    }
}
