package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: HeapSort.java, v 0.1 2018-05-26 16:45 resry.lqy Exp $
 */
public class HeapSort implements MySort {
    /**
     * 堆排序算法
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
     * 建堆
     *
     * @param a
     */
    private void buildMaxHeap(int[] a) {
        for (int i = a.length/2; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    /**
     * 调用前提：
     * 假定left(i)和right(i)为根的两棵二叉树都是最大堆，但是这是a[i]可能小于其子女
     * maxHeapify让a[i]在最大堆中"下降"，使得以i为根的字数成为最大堆
     *
     * @param a
     * @param i
     * @param size
     */
    private void maxHeapify(int[] a, int i, int size) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && a[l] > a[largest]) {
            largest = l;
        }
        if (r < size && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            //swap(a[i], a[largest]);
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            maxHeapify(a, largest, size);
        }
    }

    /**
     * 左子树
     *
     * @param i
     * @return
     */
    private int left(int i) {
        return to_idx(2 * to_heap_idx(i));
    }
    /**
     * 右子树
     *
     * @param i
     * @return
     */
    private int right(int i) {
        return to_idx(2 * to_heap_idx(i) + 1);
    }
    /**
     * 父节点
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return to_idx(to_heap_idx(i) / 2);
    }

    /**
     * 防止0的情况
     * @param x
     * @return
     */
    private int to_idx(int x) {
        return x - 1;
    }

    /**
     * 防止0的情况，这里在调用left和right以及parent前都要先对当前节点i映射到i+1
     *
     * @param x
     * @return
     */
    private int to_heap_idx(int x) {
        return x + 1;
    }
}
