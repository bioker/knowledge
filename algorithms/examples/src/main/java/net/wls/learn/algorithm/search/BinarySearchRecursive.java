package net.wls.learn.algorithm.search;

import java.util.List;

public class BinarySearchRecursive implements Search {

    @Override
    public boolean isExist(List<Integer> list, Integer i) {
        return recursiveSearch(list, i);
    }

    private boolean recursiveSearch(List<Integer> list, Integer i) {

        if (list.isEmpty()) {
            return false;
        }

        if (list.size() == 1) {
            return list.get(0).equals(i);
        }

        int middleIndex = list.size() / 2;

        Integer middleIndexValue = list.get(middleIndex);

        if (!middleIndexValue.equals(i)) {
            int subListToDeleteStartIndex;
            int subListToDeleteEndIndex;
            if (middleIndexValue > i) {
                subListToDeleteStartIndex = 0;
                subListToDeleteEndIndex = middleIndex;
            } else if (middleIndexValue < i) {
                subListToDeleteStartIndex = middleIndex;
                subListToDeleteEndIndex = list.size();
            } else {
                return true;
            }
            return recursiveSearch(list.subList(subListToDeleteStartIndex, subListToDeleteEndIndex), i);
        } else {
            return true;
        }
    }
}
