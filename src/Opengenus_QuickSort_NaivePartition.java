public class Opengenus_QuickSort_NaivePartition {
    public int partition(int[] arr, int low, int high) {
        int temp[] = new int[(high - low) + 1];
        int pivot = arr[high];
        int index = 0;

        // smaller number
        for (int i = low; i <= high; ++i) {
            if (arr[i] < pivot) {
                temp[index++] = arr[i];
            }
        }
        int pos = index;
        temp[index++] = pivot;

        for (int i = low; i <= high; ++i) {
            if (arr[i] > pivot) {
                temp[index++] = arr[i];
            }
        }
        for (int i = low; i <= high; ++i) {
            arr[i] = temp[i - low];
        }
        return pos;
    }
    public void quick_sort(int[] arr, int l, int h){
        if(l < h){
            int pivot = partition(arr, l, h);
            quick_sort(arr, l, pivot - 1);
            quick_sort(arr, pivot+1, h);
        }
    }
    public static void main(String[] args){
        int[] arr = {0, 5, 16, 10, 9, 8, 12};
        Opengenus_QuickSort_NaivePartition obj = new Opengenus_QuickSort_NaivePartition();
        obj.quick_sort(arr, 0, 6);
        System.out.print("Sorted Array: ");
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
    }
}
