package leetcode.btj.week1;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,5, 4, 8 ,1, 0};
        test(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     *
     通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     插入排序非常类似于整扑克牌。在开始摸牌时，左手是空的，牌面朝下放在桌上。
     接着，一次从 桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。
     为了找到这张牌的正确位置，要将 它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。
     如果输入数组已经是排好序的话，插入排序出现最佳情况，其运行时间是输入规模的一个线性函 数。
     如果输入数组是逆序排列的，将出现最坏情况。平均情况与最坏情况一样，其时间代价是(n2)。
     * @param arr
     */
    public static void test(int[] arr) {
        for (int i = 1 , j = arr.length ; i < j ; i++) {
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && value < arr[index]) {
                arr[index + 1] = arr[index];
                index --;
            }
            arr[index + 1] = value;
        }
    }

    public static void quickSort(int[] arr , int low , int high) {
        int left = low;
        int right = high;
        int value = arr[low];
        while (left < right) {

            while(left < right && value <= arr[right]) {
                right--;
            }

            if (value > arr[right]) {
                arr[left] = arr[right];
                arr[right] = value;
            }

            while (left < right && value >= arr[left]) {
              left++;
            }

            if (value < arr[left]) {
                arr[right] = arr[left];
                arr[left] = value;
            }
        }

        if (left > low) {
            quickSort(arr,low,left-1);
        }
        if (right < high) {
            quickSort(arr,right + 1, high);
        }

    }

    public static int  testw(int [] arr) {
        int maxMoney = 0 ;
        int min = arr[0];
        for (int i = 1 ; i < arr.length ; i ++) {
            if (arr[i] - min > maxMoney) {
                maxMoney = arr[i] - min;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return maxMoney;
    }


    public static int test2(int [] arr) {
        int result = 0;
        int a = arr[0];
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > a) {
                result = result + arr[i] - a;
                a = arr[i];
            }
        }
        return result;
    }


}
