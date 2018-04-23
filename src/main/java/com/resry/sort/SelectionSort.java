package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: SelectionSort.java, v 0.1 2018-04-23 08:44 resry.lqy Exp $
 */
public class SelectionSort implements MySort {

    /**
     * @see com.resry.sort.MySort#sort(int[])
     */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int min_idx = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            //swap a[i] a[min_index]
            int tmp = a[i];
            a[i] = a[min_idx];
            a[min_idx] = tmp;
        }
    }
}
