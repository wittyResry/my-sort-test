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
        // ����n��bλ���� radix-sort����O((b/r)(n+2^r))���Ӷ�����
        // ��ô����ϣ���ҵ�rֵ��r<b��ʹ���ܹ���С��(b/r)(n+2^r)������ȡb=lg(n)������֤���ɲο��㷨���۵�8��
        int r = (int) (Math.log(a.length) / Math.log(2));
        if (r == 0) {
            return;
        }
        // radix=2^r
        int radix = 1;
        for (int i = 0; i < r; ++i) {
            radix = radix * 2;
        }
        // ʹ�ü���������Ϊ�ȶ������ÿ������
        for (int t = 0; t < 32; t += r) {
            int[] c = new int[radix];
            for (int i = 0; i < a.length; ++i) {
                ++c[getvalue(a[i], t / r, radix)];
            }
            for (int i = 1; i < radix; ++i) {
                c[i] += c[i - 1];
            }
            int[] b = new int[a.length];
            // ����a��ѭ��˳��������㷨�����յ�����˳��
            // ����ǴӴ�СҪ����Ҫ��������for(int i = 0; i < a.length; ++i)
            for (int i = a.length - 1; i >= 0; --i) {
                b[--c[getvalue(a[i], t / r, radix)]] = a[i];
            }
            for (int i = 0; i < a.length; ++i) {
                a[i] = b[i];
            }
        }
    }

    /**
     * ��ȡ��t�λ��������ֵ
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
