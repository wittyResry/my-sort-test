package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: HeapSupport.java, v 0.1 2018-05-26 21:29 resry.lqy Exp $
 */
public class HeapSupport {


    /**
     * ����ǰ�᣺
     * �ٶ�left(i)��right(i)Ϊ�������ö������������ѣ���������a[i]����С������Ů
     * maxHeapify��a[i]��������"�½�"��ʹ����iΪ����������Ϊ����
     *
     * @param a
     * @param i
     * @param size
     */
    protected void maxHeapify(int[] a, int i, int size) {
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
     * ����ǰ�᣺
     * a[i]>=a[parent(i)]
     * maxHeapifyUpper��a[i]��������"����"��ʹ��i��parent(i)�����ʵ��Ա���
     *
     * @param a
     * @param i
     */
    protected void maxHeapifyUpper(int[] a, int i) {
        while (i > 0 && a[parent(i)] < a[i]) {
            int tmp = a[i];
            a[i] = a[parent(i)];
            a[parent(i)] = tmp;
            i = parent(i);
        }
    }

    /**
     * ������
     *
     * @param i
     * @return
     */
    protected int left(int i) {
        return to_idx(2 * to_heap_idx(i));
    }

    /**
     * ������
     *
     * @param i
     * @return
     */
    protected int right(int i) {
        return to_idx(2 * to_heap_idx(i) + 1);
    }

    /**
     * ���ڵ�
     *
     * @param i
     * @return
     */
    protected int parent(int i) {
        return to_idx(to_heap_idx(i) / 2);
    }

    /**
     * ��ֹ0�����
     *
     * @param x
     * @return
     */
    protected int to_idx(int x) {
        return x - 1;
    }

    /**
     * ��ֹ0������������ڵ���left��right�Լ�parentǰ��Ҫ�ȶԵ�ǰ�ڵ�iӳ�䵽i+1
     *
     * @param x
     * @return
     */
    protected int to_heap_idx(int x) {
        return x + 1;
    }
}
