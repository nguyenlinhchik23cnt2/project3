package k23cnt2_nlc_day02.demo;

import k23cnt2_nlc_day02.demo.tight_loosely_coupling.SortAlgorithm;
import java.util.Arrays;

public class LooselyBubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        System.out.println("Sorted using bubble sort algorithm");
        Arrays.stream(arr).sorted().forEach(System.out::println);
    }
}
