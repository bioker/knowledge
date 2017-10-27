package net.wls.learn.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchCycle implements Search {

    @Override
    public boolean isExist(List<Integer> list, Integer i) {
        while (list.size() >= 1) {

            if (list.size() == 1) {
                return list.get(0).equals(i);
            }

            int middleIndex = list.size() / 2;
            Integer middleIndexValue = list.get(middleIndex);

            if (!middleIndexValue.equals(i)) {
                int subListToSearchStartIndex;
                int subListToSearchEndIndex;
                if (middleIndexValue > i) {
                    subListToSearchStartIndex = 0;
                    subListToSearchEndIndex = middleIndex;
                } else if (middleIndexValue < i) {
                    subListToSearchStartIndex = middleIndex;
                    subListToSearchEndIndex = list.size();
                } else {
                    return true;
                }
                list = list.subList(
                        subListToSearchStartIndex, subListToSearchEndIndex);
            } else {
                return true;
            }
        }
        return false;
    }
}
