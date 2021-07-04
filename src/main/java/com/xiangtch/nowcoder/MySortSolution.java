package com.xiangtch.nowcoder;

/**
 *  排序 - Arrays.sort() 或快排
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/7/4 13:39
 */
public class MySortSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1, 4};
        mySort(arr);
    }

    private static int[] mySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            int point = partition(list, left, right);
            quickSort(list, left, point - 1);
            quickSort(list, point + 1, right);
        }
    }

    private static int partition(int[] list, int left, int right) {
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            swap(list, left, right);
            while (left < right && list[left] <= first) {
                left++;
            }
            swap(list, left, right);
        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
