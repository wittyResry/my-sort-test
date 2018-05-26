package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: HeapSort.java, v 0.1 2018-05-26 16:45 resry.lqy Exp $
 */
public class HeapSort extends HeapSupport implements MySort {
    /**
     * ¶ÑÅÅÐòËã·¨
     *
     * @param a
     */
    @Override
    public void sort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 0; --i) {
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            maxHeapify(a, 0, i);
        }
    }


    /**
     * ½¨¶Ñ
     *
     * @param a
     */
    private void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }
}
