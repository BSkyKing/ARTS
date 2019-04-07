package leetcode.btj.week1;


public class LeetCodeOne {

//    乘积最大子序列
//    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//    示例 1:
//
//    输入: [2,3,-2,4]
//    输出: 6
//    解释: 子数组 [2,3] 有最大乘积 6。
//    示例 2:
//
//    输入: [-2,0,-1]
//    输出: 0
//    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

    public static void main(String[] args) {

    }


    /**
     *   这个解法耗时比较严重。。甚至在没有nums[i]==0时，直接超出时间了
     *   耗时165ms左右。 时间负责度。。应该是 1 + .. + n。。
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0 ; i < nums.length ; i++) {
            int result = nums[i];
            if (result > max) {
                max = result;
            }
            for (int j = i + 1 ; j < nums.length ; j++) {
                result = result * nums[j];
                if (result > max) {
                    max = result;
                }
                if (nums[j] == 0) {
                    break;
                }
            }
        }
        return max;
    }


    /**
     *  运行了4ms
     *  这个方法。。太特殊了。。根据各种错误情况后进行组合搞出来的的。。
     *  （一个负数，其他全都是正数的情况  所以有了z）
     *   【1，-2，-3，，-3，4】 这种情况增加了temp2;
     *   [1,-2,3,4,-3,-3,4] 这种情况有了count > 0;
     * @param nums
     * @return
     */
    public static int maxProduct1(int [] nums) {
        int max = nums[0]; //默认索引0的值为最大
        int temp = 1; //将数组的值连续相乘。
        int temp2 = 1; //将数组中第一个负数之后的值进行相乘。
        int count = 0; //是为了判断数组里有多少负数。。（是为了temp2服务的）
        int z = 1; //这是为了用来计算连续正整数的值的
        for (int i = 0 ; i < nums.length ; i++) {
            temp = temp * nums[i];
            if (nums[i] < 0 ) {
                count ++;
                z =1;
            }
            if (nums[i] > 0) {
                if (count > 0) {
                    temp2 =temp2 * nums[i];
                }
                z = z * nums[i];
                max = Math.max(max,z);
            } else if (count > 1) {
                temp2 = temp2 * nums[i];
            }

            if (temp >= 0) {
                max = Math.max(max,temp);
            }
            //这边若是temp2>=0，那么就会多出1ms。不需要等于0，是因为若是nums[i]= 0时，temp和temp2的值都为0,若是0是最大值..那么就不需要判断当temp2为0时，再和max进行比大小。
            if (temp2 > 0 && count > 1) {
                max = Math.max(max,temp2);
            }

            //若是数组值为0，那么数组在该索引前的最值和该索引后的最值是没有必然连续的。。。所以对最外面的变量进行重置。
            if (nums[i] ==0) {
                temp = 1;
                temp2 = 1;
                z = 1;
                count = 0;
            }
        }
        return max;
    }

    /**3ms
     * 这个是参考别人的思路
     * @param nums
     * @return
     */
    public static int maxProduct2(int [] nums) {
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        int temp;
        for (int i = 1 , j = nums.length; i < j; i++) {
            if (nums[i] < 0) {
                temp = imax;
                imax = imin; //当数组值为负数时，最大值和最小值相互转化。
                imin = temp;
            }
            imax = Math.max(imax* nums[i],nums[i]);
            imin = Math.min(imin* nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }


    /** 看了别人的思路 2ms
     * 思路是： 从左边开始算最大值与从右边开始算最大值进行比较
     * @param nums
     * @return
     */
    public static int maxProduct3(int [] nums) {
        int max = nums[0];
        int product = 1;
        for (int i : nums) {
            product = product * nums[i];
          max = Math.max(max,product);
          if (nums[i] == 0) {
              product = 1; //为0时重置
          }
        }
        product = 1;
        for (int i = nums.length - 1 ; i >= 0 ; i-- ) {
            product = product * nums[i];
            max = Math.max(product, max);
            if (nums[i] == 0) {
                product = 1;
            }
        }
        return max;
    }

}
