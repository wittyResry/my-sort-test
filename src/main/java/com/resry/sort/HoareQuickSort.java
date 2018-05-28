package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: HoareQuickSort.java, v 0.1 2018-05-28 22:40 resry.lqy Exp $
 */
public class HoareQuickSort implements MySort {
    @Override
    public void sort(int[] a) {
        hoareQuickSort(a, 0, a.length - 1);
    }

    private void hoareQuickSort(int[] a, int p, int q) {
        if (p < q) {
            int r = hoarePartition(a, p, q);
            hoareQuickSort(a, p, r - 1);
            hoareQuickSort(a, r + 1, q);
        }
    }

    private int hoarePartition(int[] a, int p, int q) {
        int x = a[p];
        int i = p;
        int j = q + 1;
        while (true) {
            while(a[--j] > x && i < j);//这里有个技巧，必须先j--，否则会数组越界
            while(a[++i] < x && i < j);
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                a[p] = a[j];
                a[j] = x;
                return j;
            }
        }
    }
}
