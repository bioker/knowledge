package net.wls.learn.algorithm.search;

import java.util.List;

public class LinearSearch implements Search {

    @Override
    public boolean isExist(List<Integer> list, Integer i) {
        for (Integer number : list) {
            if (number.equals(i)) {
                return true;
            }
        }
        return false;
    }
}
