package leetcode.btj.week2;

import java.util.HashMap;

/**
 * 票易通的面试题
 */
public class InterviewTest {

    /**
     * 求在数组中 值出现的频率超过一半的 这个值在数组中的任意索引位置。。如果没有则返回-1；
     * @param arr
     * @return
     */
    public int test1(int[] arr) {
        int temp = arr.length /2 ;
        int index = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i ++) {
            Integer value = map.get(arr[i]);
            if (value  > temp) {
                return index;
            } else if (value == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i],value++);
            }

        }
        return index;
    }


    /**
     *股票的问题： 就是什么时候买进，然后什么时候买出收益最大
     * @param arr
     * @return
     */
    public int test2(int [] arr) {
        int max = 0;
        int b = arr[0];
        for (int i = 1 ; i < arr.length ; i ++) {
            if (arr[i - 1] > arr[i] ) {
                b = arr[i];
            } else {
                max = Math.max(max,arr[i] - b);
            }
        }
        return max;
    }


}
