package com.resry.sort;

/**
 * @author resry.lqy
 * @version $Id: RadixSort.java, v 0.1 2018-06-13 08:46 resry.lqy Exp $
 */
public class RadixSort implements MySort {
    @Override
    public void sort(int[] a) {
        if (a.length == 0) {
            return;
        }
        // 引理：n个b位数， radix-sort能在O((b/r)(n+2^r))复杂度排序
        // 那么我们希望找到r值（r<b）使得能够最小化(b/r)(n+2^r)，这里取b=lg(n)，具体证明可参考算法导论第8章
        int r = (int) (Math.log(a.length) / Math.log(2));
        if (r == 0) {
            return;
        }
        // radix=2^r
        int radix = 1;
        for (int i = 0; i < r; ++i) {
            radix = radix * 2;
        }
        // 使用计数排序作为稳定排序的每次排序
        for (int t = 0; t < 32; t += r) {
            int[] c = new int[radix];
            for (int i = 0; i < a.length; ++i) {
                ++c[getvalue(a[i], t / r, radix)];
            }
            for (int i = 1; i < radix; ++i) {
                c[i] += c[i - 1];
            }
            int[] b = new int[a.length];
            // 这里a的循环顺序决定了算法的最终的排序顺序
            // 如果是从大到小要遍历要倒过来：for(int i = 0; i < a.length; ++i)
            for (int i = a.length - 1; i >= 0; --i) {
                b[--c[getvalue(a[i], t / r, radix)]] = a[i];
            }
            for (int i = 0; i < a.length; ++i) {
                a[i] = b[i];
            }
        }
    }

    /**
     * 获取第t次基数排序的值
     *
     * @param value
     * @param t
     * @param radix
     * @return
     */
    private int getvalue(int value, int t, int radix) {
        for (int i = 0; i < t; ++i) {
            value /= radix;
        }
        return value % radix;
    }
}
