package com.imonit;

import java.util.List;

class Sorter<T extends Comparable<T>> {

    List<T> sort(List<T> listToSort) {
        if (listToSort == null || listToSort.size() == 1) {
            return listToSort;
        }

        for (int i = 0; i < listToSort.size(); i++) {
            for (int j = i + 1; j < listToSort.size(); j++) {
                if (listToSort.get(i).compareTo(listToSort.get(j)) > 0) {
                    swap(listToSort, i, j);
                }
            }
        }
        return listToSort;
    }

    void swap(List<T> list, int pos1, int pos2) {
        if (pos1 < list.size() || pos2 < list.size()) {
            throw new IllegalArgumentException("pos1 and pos2 must be < the size of the list");
        }

        T temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
}
