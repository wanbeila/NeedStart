package cn.com.beila.code.algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wanbeila
 * @date 2021-10-15-16:40
 * @desc 快排
 */
public class FastSort {

    public FastSort() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        Random random = new Random();
        arr = random.ints(len, 0, 10).toArray();

        System.out.println("origin array: " + Arrays.toString(arr));
        fastSort(arr, 0, len - 1);
        System.out.println("after array: " + Arrays.toString(arr));
    }

    private static void fastSort(int[] arr, int left, int right) {
        int pivot,pos,t;
        if (left < right) {
            pos = left;
            pivot = arr[pos];
            for (int i = left + 1;i <= right;i ++) {
                if (arr[i] > pivot) {
                    pos ++;
                    t = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = t;
                }
            }
            t = arr[left];
            arr[left] = arr[pos];
            arr[pos] = t;

            fastSort(arr, left, pos);
            fastSort(arr, pos + 1, right);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
