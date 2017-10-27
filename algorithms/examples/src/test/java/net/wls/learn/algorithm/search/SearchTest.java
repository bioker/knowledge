package net.wls.learn.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;

public class SearchTest {

    private Search search;

    public SearchTest(Search search) {
        this.search = search;
    }

    /**
     * @param testDataSize - will generate elements from -testDataSize/2 to testDataSize/2
     * @param number       - number for search
     * @return true if number was found and false if not
     */
    public boolean test(int testDataSize, int number) {

        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = -(testDataSize / 2); i < (testDataSize / 2); i++) {
            testData.add(i);
        }

        return search.isExist(testData, number);
    }

}
