package lesson01_lambda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLambaExample {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("Java","HTML","CSS");
        // Sắp xếp, sử dụng biểu thức lambda
        Collections.sort(list,(String strl, String strl2 ) -> strl.compareTo(strl2));
        for(String str : list){
            System.out.println(str);
        }
    }
}
