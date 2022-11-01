package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 15:37
 */
public class InversePairs {

    public static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }

    private static int solve(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort(0, n - 1, array, res);
    }

    private static int mergeSort(int left, int right, int[] data, int[] temp) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int res = mergeSort(left, mid, data, temp) + mergeSort(mid + 1, right, data, temp);
        res %= mod;
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            temp[k] = data[k];
        }
        for (int k = left; k <= right; k++) {
            // 左边遍历完了，没数据了，填充右边剩余的数据
            if (i == mid + 1) {
                data[k] = temp[j++];
                // 右边遍历完了，没数据了，或者左边的数据比右边的数据小，填充左边的数据
            } else if (j == right + 1 || temp[i] <= temp[j]) {
                data[k] = temp[i++];
                // 填充右边的数据，填充右边的数据时，说明右边分组从该元素往后都是逆序对
            } else {
                data[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;
    }
}
