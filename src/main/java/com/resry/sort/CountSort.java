package com.resry.sort;

import java.util.Arrays;

/**
 * @author resry.lqy
 * @version $Id: CountSort.java, v 0.1 2018-06-12 08:04 resry.lqy Exp $
 */
public class CountSort implements MySort {
    @Override
    public void sort(int[] a) {
        int[] c = new int[a.length];
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; ++i) {
            ++c[a[i]];
        }
        for (int i = 1; i < a.length; ++i) {
            c[i] += c[i - 1];
        }
        //c[a[i]]记录了最终的位置，因为共有c[a[i]]个元素小于等于a[i]
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i]]] = a[i];
        }
        for (int i = 0; i < a.length; ++i) {
            a[i] = b[i];
        }
    }
}
