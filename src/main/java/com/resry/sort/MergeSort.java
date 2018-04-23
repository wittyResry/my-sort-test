package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: MergeSort.java, v 0.1 2018-04-23 09:05 resry.lqy Exp $
 */
public class MergeSort implements MySort {
    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[p + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[q + 1 + j];
        }
        //Ôö¼ÓÉÚ±ø
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; ++k) {
            if (L[i] < R[j]) {
                a[k] = L[i++];
            } else {
                a[k] = R[j++];
            }
        }
    }

}
