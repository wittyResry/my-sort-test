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
     * 取出最大元素
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
     * 最大堆插入，直接在末尾进行插入
     * <p>调用此函数需要自己对heapSize进行加1</p>
     *
     * @param a
     * @param key
     * @param heapSize
     */
    private void maxHeapInsert(int[] a, int key, int heapSize) {
        heapModifyKey(a, heapSize, key, heapSize + 1);
    }

    /**
     * 修改某个Key的值，这里和算法导论的作了优化，支持key < a[i]分支
     * 对key < a[i]分支，不用直接报错，可以调用maxHeapify(a, i, heapSize);
     *
     * @param a
     * @param i
     * @param key
     * @param heapSize
     */
    private void heapModifyKey(int[] a, int i, int key, int heapSize) {
        if (key < a[i]) {
            //理论上不执行到这里
            maxHeapify(a, i, heapSize);
        } else {
            maxHeapifyUpper(a, i);
        }
    }
}
