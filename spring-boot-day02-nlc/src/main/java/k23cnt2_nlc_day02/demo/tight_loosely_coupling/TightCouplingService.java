package k23cnt2_nlc_day02.demo.tight_loosely_coupling;

import java.util.Arrays;

public class TightCouplingService {

    private bubbleSortAlgorithm bubbleSortAlgorithm = new bubbleSortAlgorithm();


    public TightCouplingService() {
    }

    public TightCouplingService(bubbleSortAlgorithm  bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    public void complexBubbleSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    // test
    public static void main(String[] args) {
        TightCouplingService service = new TightCouplingService();
        service.complexBubbleSort(new int[]{11, 12, 13, 42, 15});
    }
}
