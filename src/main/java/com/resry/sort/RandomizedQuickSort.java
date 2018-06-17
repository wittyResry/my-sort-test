package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: RandomizedQuickSort.java, v 0.1 2018-05-28 12:00 resry.lqy Exp $
 */
public class RandomizedQuickSort extends QuickSort implements MySort {

    @Override
    public void sort(int[] a) {
        randomizedQuickSort(a, 0, a.length - 1);
    }

    private void randomizedQuickSort(int[] a, int p, int q) {
        if (p < q) {
            int r = randomizedPartition(a, p, q);
            randomizedQuickSort(a, p, r - 1);
            randomizedQuickSort(a, r + 1, q);
        }
    }

    protected int randomizedPartition(int[] a, int p, int q) {
        int r = (int) (Math.random() * (q - p + 1)) + p;
        int tmp = a[q];
        a[q] = a[r];
        a[r] = tmp;
        return partition(a, p, q);
    }
}
