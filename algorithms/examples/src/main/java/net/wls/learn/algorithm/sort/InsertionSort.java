package net.wls.learn.algorithm.sort;

import java.util.List;

public class InsertionSort implements Sort {

    @Override
    public void sort(List<Integer> integerList) {
        int sortedPartEndIndex = 0;

        while (sortedPartEndIndex < (integerList.size() - 1)) {
            insertNewNumber(integerList, sortedPartEndIndex, sortedPartEndIndex + 1);
            sortedPartEndIndex++;
        }
    }

    private void insertNewNumber(List<Integer> integerList, int sortedPartEndIndex, int numberIndex) {

        for (int i = 0; i <= sortedPartEndIndex; i++) {
            if (integerList.get(i) > integerList.get(numberIndex)) {
                Integer number = integerList.remove(numberIndex);
                integerList.add(i, number);
            }
        }
    }
}
