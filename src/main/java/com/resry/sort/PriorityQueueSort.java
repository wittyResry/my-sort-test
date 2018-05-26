package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: PriorityQueueSort.java, v 0.1 2018-05-26 21:24 resry.lqy Exp $
 */
public class PriorityQueueSort extends HeapSupport implements MySort {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            maxHeapInsert(a, a[i], i);
        }
        for (int i = a.length - 1; i >= 0; --i) {
            int tmp = extractMax(a, i + 1);
            a[i] = tmp;
        }
    }

    /**
     * ȡ�����Ԫ��
     *
     * @param a
     * @param heapSize
     * @return
     */
    private int extractMax(int[] a, int heapSize) {
        int max = a[0];
        a[0] = a[heapSize - 1];
        --heapSize;
        maxHeapify(a, 0, heapSize);
        return max;
    }

    /**
     * ���Ѳ��룬ֱ����ĩβ���в���
     * <p>���ô˺�����Ҫ�Լ���heapSize���м�1</p>
     *
     * @param a
     * @param key
     * @param heapSize
     */
    private void maxHeapInsert(int[] a, int key, int heapSize) {
        heapModifyKey(a, heapSize, key, heapSize + 1);
    }

    /**
     * �޸�ĳ��Key��ֵ��������㷨���۵������Ż���֧��key < a[i]��֧
     * ��key < a[i]��֧������ֱ�ӱ������Ե���maxHeapify(a, i, heapSize);
     *
     * @param a
     * @param i
     * @param key
     * @param heapSize
     */
    private void heapModifyKey(int[] a, int i, int key, int heapSize) {
        if (key < a[i]) {
            //�����ϲ�ִ�е�����
            maxHeapify(a, i, heapSize);
        } else {
            maxHeapifyUpper(a, i);
        }
    }
}
