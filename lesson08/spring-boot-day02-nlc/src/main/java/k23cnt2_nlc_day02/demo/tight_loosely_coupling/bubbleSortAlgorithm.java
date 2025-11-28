package k23cnt2_nlc_day02.demo.tight_loosely_coupling;

public class bubbleSortAlgorithm {
    public void sort(int[] arr){
        System.out.print(" sap xep giat thuat : BubblleSort");
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n-1; i++){
            swapped = false;
            for(int j =0; i < n-i -1; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
                if (!swapped){
                    break;
                }
            }
        }
    }
}
