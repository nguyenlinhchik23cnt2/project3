package k23cnt2_nlc_day02.demo.tight_loosely_coupling;

import k23cnt2_nlc_day02.demo.LooselyBubbleSortAlgorithm;
import java.util.Arrays;
import java.lang.reflect.Array;

public class LooselyCoupledService {
    private SortAlgorithm sortAlgorithm;

    public LooselyCoupledService() {}

    public LooselyCoupledService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] arr) {
        sortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        LooselyCoupledService service = new LooselyCoupledService(new LooselyBubbleSortAlgorithm());
        service.complexBusiness(new int[]{42, 15, 23, 8, 16});
    }
}


