package com.resry.sort;

import java.util.ArrayList;

/**
 * @author resry.lqy
 * @version $Id: BucketSort.java, v 0.1 2018-06-15 09:16 resry.lqy Exp $
 */
public class BucketSort implements MySort {
    @Override
    public void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int min = a[0], max = a[0];
        ArrayList[] b = new ArrayList[a.length];
        for (int i = 0; i < a.length; ++i) {
            b[i] = new ArrayList<Integer>();
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            int buc = (int) (a.length / (double) (max - min) * (a[i] - min));
            //process borderline
            if (buc == a.length) buc = a.length - 1;
            if (buc == -1) buc = 0;
            //insert into bucket[buc] by insertion sort
            b[buc].add(a[i]);
            int key = a[i], j = b[buc].size() - 2;
            while (j >= 0 && (int) b[buc].get(j) > key) {
                b[buc].set(j + 1, b[buc].get(j));
                --j;
            }
            b[buc].set(j + 1, key);
        }
        int idx = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b[i].size(); ++j) {
                a[idx++] = (int) b[i].get(j);
            }
        }

    }
}
