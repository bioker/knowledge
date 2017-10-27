package net.wls.learn.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

    private Sort sort;

    public SortTest(Sort sort) {
        this.sort = sort;
    }

    /**
     * @param testDataSize - will generate elements from -testDataSize/2 to testDataSize/2
     * @return true if number was found and false if not
     */
    public boolean test(int testDataSize) {

        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = -(testDataSize / 2); i < (testDataSize / 2); i++) {
            testData.add(i);
        }

        Collections.shuffle(testData);

        long start = System.currentTimeMillis();
        sort.sort(testData);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " millis");

        return listIsSorted(testData);
    }

    private boolean listIsSorted(List<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            if (i != (integerList.size() - 1)) {
                if (integerList.get(i) > integerList.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
