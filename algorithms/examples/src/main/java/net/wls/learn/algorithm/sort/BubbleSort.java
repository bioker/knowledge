package net.wls.learn.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements Sort {

    @Override
    public void sort(List<Integer> integerList) {

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < integerList.size(); i++) {
                if (i != (integerList.size() - 1)) {
                    if (integerList.get(i) > integerList.get(i + 1)) {
                        swapped = true;
                        Collections.swap(integerList, i, i + 1);
                    }
                }
            }
        }

    }

}
