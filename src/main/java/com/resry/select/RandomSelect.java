package com.resry.select;

import com.resry.sort.RandomizedQuickSort;

/**
 * @author resry.lqy
 * @version $Id: RandomSelect.java, v 0.1 2018-06-16 22:39 resry.lqy Exp $
 */
public class RandomSelect extends RandomizedQuickSort implements MySelect {

    /**
     * 选择第id大小的元素，id取值在[1,a.length]之间
     */
    @Override
    public int select(int[] a, int id) {
        return randomSelect(a, 0, a.length - 1, id);
    }

    private int randomSelect(int[] a, int p, int r, int id) {
        if (p == r) {
            return a[p];
        }
        int q = randomizedPartition(a, p, r);
        int k = q - p + 1;
        if (id == k) {
            return a[q];
        } else if (id < k) {
            return randomSelect(a, p, q - 1, id);
        }
        //id > k
        return randomSelect(a, q + 1, r, id - k);
    }
}
