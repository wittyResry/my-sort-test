package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: QuickSort.java, v 0.1 2018-05-27 12:58 resry.lqy Exp $
 */
public class QuickSort implements MySort {
    /**
     * 快速排序实现
     *
     * @param a
     */
    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 快速排序
     *
     * @param a
     * @param p
     * @param q
     */
    private void quickSort(int[] a, int p, int q) {
        if (p < q) {
            int r = partition(a, p, q);
            quickSort(a, p, r - 1);
            quickSort(a, r + 1, q);
        }
    }

    /**
     * 划分
     *
     * @param a
     * @param p
     * @param q
     * @return pivot的下标位置
     */
    protected int partition(int[] a, int p, int q) {
        int pivot = a[q];
        int i = p - 1;
        for (int j = p; j <= q - 1; j++) {
            if (a[j] <= pivot) {
                ++i;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        int tmp = a[i + 1];
        a[i + 1] = a[q];
        a[q] = tmp;
        return i + 1;
    }
}
