package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: BubbleSort.java, v 0.1 2018-04-24 20:45 resry.lqy Exp $
 */
public class BubbleSort implements MySort {
    @Override
    public void sort(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = a.length - 1; j > i; --j) {
                if (a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }
}
