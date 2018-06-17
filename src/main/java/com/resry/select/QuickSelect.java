package com.resry.select;

import com.resry.sort.QuickSort;

/**
 * @author resry.lqy
 * @version $Id: QuickSelect.java, v 0.1 2018-06-17 08:00 resry.lqy Exp $
 */
public class QuickSelect extends QuickSort implements MySelect {
    /**
     * 思路：利用快速排序的partition来进行排序，平均时间复杂度O(N)，如果数组已经排好序，最坏时间复杂度会退化为O(N^2)
     */
    @Override
    public int select(int[] a, int id) {
        return quickSelect(a, 0, a.length - 1, id);
    }

    private int quickSelect(int[] a, int p, int r, int id) {
        if (p == r) {
            return a[p];
        }
        int q = partition(a, p, r);
        int k = q - p + 1;
        if (id == k) {
            return a[q];
        } else if (id < k) {
            return quickSelect(a, p, q - 1, id);
        }
        //id > k
        return quickSelect(a, q + 1, r, id - k);
    }
}
