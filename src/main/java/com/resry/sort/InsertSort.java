package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: InsertSort.java, v 0.1 2018-04-22 21:21 resry.lqy Exp $
 */
public class InsertSort implements MySort {
    /**
     * @see com.resry.sort.MySort#sort(int[])
     */
    public void sort(int[] a) {
        if (a == null) {
            return;
        }
        for (int j = 1; j < a.length; ++j) {
            int key = a[j];
            int i = j - 1;
            while (i > -1 && a[i] > key) {
                a[i+1] = a[i];
                --i;
            }
            a[i+1] = key;
        }
    }
}
