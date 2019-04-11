package leetcode.btj.week1;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
            int[] a = new int[]{2,5,3,6,1,6,3,9,34,5,2,45,23,56};
        System.out.println("hh");
           // int [] a = new int[]{5,2};
          //  sort(a,0,a.length -1);
        test(a);
           System.out.println(Arrays.toString(a));
    }

    //快排的核心思想是分而治之。。 时间复杂度为（nlogN）
    //每一次的循环结束都能确定一个基数的索引位置
    public static void sort(int[] arr , int low , int high) {
        int left = low;
        int right = high;
        int cn = arr[low];

        while (left < right) {

            //从后往前。都得不小于基数
            while (left < right && arr[right] >= cn) {
                 right --;}
                if (arr[right] < cn) {
                    arr[left] = arr[right];
                    arr[right] = cn;
                }

            //从前往后。都得不大于基数
            while (left < right && arr[left] <= cn) {
                left ++;}
                if (arr[left] > cn) {
                    arr[right] = arr[left];
                    arr[left] = cn;
                }
        }

        if (left > low) {
            sort(arr,low,left-1);
        }

        if (right < high) {
            sort(arr,right+1,high);
        }
    }

    public static void test(int[] arr) {
        for (int i = 0 ; i< arr.length ; i ++) {
            int max = Integer.MIN_VALUE;
            int b = -1;
            for (int j = 0 ; j < arr.length - i; j ++) {
                if (max < arr[j]) {
                    max = arr[j];
                    b = j;
                }
            }
            if (b > -1) {
                arr[b] = arr[arr.length  - 1 - i];
                arr[arr.length - i -1] = max;
            }
        }
    }
}
