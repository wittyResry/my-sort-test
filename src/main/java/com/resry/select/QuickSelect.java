package com.resry.select;

import com.resry.sort.QuickSort;

/**
 * @author resry.lqy
 * @version $Id: QuickSelect.java, v 0.1 2018-06-17 08:00 resry.lqy Exp $
 */
public class QuickSelect extends QuickSort implements MySelect {
    /**
     * ˼·�����ÿ��������partition����������ƽ��ʱ�临�Ӷ�O(N)����������Ѿ��ź����ʱ�临�ӶȻ��˻�ΪO(N^2)
     */
    @Override
    public int select(int[] a, int id) {
        return quickSelect(a, 0, a.length - 1, id);
    }

    private int quickSelect(int[] a, int p, int r, int id) {
        if (p == r) {
            return a[p];
        }
        int q = partition(a, p, r);
        int k = q - p + 1;
        if (id == k) {
            return a[q];
        } else if (id < k) {
            return quickSelect(a, p, q - 1, id);
        }
        //id > k
        return quickSelect(a, q + 1, r, id - k);
    }
}
