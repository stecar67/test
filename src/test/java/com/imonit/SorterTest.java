package com.imonit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SorterTest {
    @Test
    public void sortStrings() {
        List<String> toBeSorted = Arrays.asList("b", "a", "d", "c", "e");
        assertThat(new Sorter<String>().sort(toBeSorted), is(Arrays.asList("a", "b", "c", "d", "e")));
    }

    @Test
    public void sortIntegers() {
        List<Integer> toBeSorted = Arrays.asList(2, 3, 1, 4, 0);
        assertThat(new Sorter<Integer>().sort(toBeSorted), is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void sortOneElementList() {
        List<Long> toBeSorted = Collections.singletonList(2L);
        assertThat(new Sorter<Long>().sort(toBeSorted), is(toBeSorted));
    }

    @Test
    public void sortEmptyList() {
        List<Integer> toBeSorted = new ArrayList<Integer>();
        assertThat(new Sorter<Integer>().sort(toBeSorted), is(toBeSorted));
    }

    @Test
    public void sortNullList() {
        List<Integer> toBeSorted = null;
        //noinspection ConstantConditions
        assertThat(new Sorter<Integer>().sort(toBeSorted), is(toBeSorted));
    }

    @Test
    public void swapValues() {
        List<Integer> list = Arrays.asList(1, 2);

        Sorter<Integer> integerSorter = new Sorter<Integer>();
        integerSorter.swap(list, 0, 1);
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void swapWrongIndexShouldGiveException() {
        boolean exceptionCaught = false;

        List<Integer> list = Arrays.asList(1, 2);
        Sorter<Integer> integerSorter = new Sorter<Integer>();

        try {
            integerSorter.swap(list, 1, 2);
        } catch (Exception e) {
            exceptionCaught = true;
            // expected
        }
        assertThat(exceptionCaught, is(true));
    }

    @Test
    public void swapEmptyList() {
        List<Integer> list = new ArrayList<Integer>();

        Sorter<Integer> integerSorter = new Sorter<Integer>();
        integerSorter.swap(list, 0, 0);
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void sortWithRestAPI() {
        
    }
}
