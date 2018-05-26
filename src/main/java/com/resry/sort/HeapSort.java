package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: HeapSort.java, v 0.1 2018-05-26 16:45 resry.lqy Exp $
 */
public class HeapSort implements MySort {
    /**
     * �������㷨
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
     * ����
     *
     * @param a
     */
    private void buildMaxHeap(int[] a) {
        for (int i = a.length/2; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    /**
     * ����ǰ�᣺
     * �ٶ�left(i)��right(i)Ϊ�������ö������������ѣ���������a[i]����С������Ů
     * maxHeapify��a[i]��������"�½�"��ʹ����iΪ����������Ϊ����
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
     * ������
     *
     * @param i
     * @return
     */
    private int left(int i) {
        return to_idx(2 * to_heap_idx(i));
    }
    /**
     * ������
     *
     * @param i
     * @return
     */
    private int right(int i) {
        return to_idx(2 * to_heap_idx(i) + 1);
    }
    /**
     * ���ڵ�
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return to_idx(to_heap_idx(i) / 2);
    }

    /**
     * ��ֹ0�����
     * @param x
     * @return
     */
    private int to_idx(int x) {
        return x - 1;
    }

    /**
     * ��ֹ0������������ڵ���left��right�Լ�parentǰ��Ҫ�ȶԵ�ǰ�ڵ�iӳ�䵽i+1
     *
     * @param x
     * @return
     */
    private int to_heap_idx(int x) {
        return x + 1;
    }
}
