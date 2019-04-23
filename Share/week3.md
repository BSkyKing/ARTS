第三周
========
   ## 自己的想法：
      绝不做码农。
      写代码的时候多思考业务之外的东西，不局限于眼前的业务代码，多思考。
  
   ## 数据结构和算法的学习：
   ### 了解基本的概念，然后每周刷一到两题。
   ### 对于时间复杂度的认识：
      
   #### 多项式量级 
          1.T(n) = O(1) 常量阶
            算法中不存在循环和递归
           
          2.T(n)=O(n) 线性阶
           int m = 0 ;
           for (int i = 0 ; i < j ; i++) {
              m += i;
            }          
          
          3.T(n) = O(n^2)) 平方阶
          int m = 0;
          for (int i=0; i< n ; i++) { 
              m += i;
              for (int j = 0 ; j < n ; j++) {
                 m += j;
              }
          }
           
          4.T(n) = O(logn) 对数
            int i = 1;
            while（i <= n）{
              i = i * 2
            }
          
          5.T(n) = O(nlogn) 线性对数阶
             快排就是这样的
             int sum = 0 ;
             for (int i = 0 ; i < n ; n++){
                sum += i;
                int j = 1;
                while (j < n) {
                  sum += j;
                  j *= 2;
                }
             }
             
  #### 非项式量级 
             T（n）= O (2 ^ n) , T(n) = O(n!)
  #### 时间复杂度在同一块代码中的分析
          // n 表示数组 array 的长度
          int find(int[] array, int n, int x) {
            int i = 0;
            int pos = -1;
            for (int i = 0 ; i < n; ++i) {
              if (array[i] == x) {
                 pos = i;
                 break;
              }
            }
            return pos;
          }

       最好时间复杂度  x=array[0] ,时间复杂度为O（1）
       最坏时间复杂度  x = array[n],时间复杂度为O(n)
       平均时间复杂度 :有两种情况  。一种x 在数组里面 ，另一种 x不在数组里面.所以在数组和不在数组的概率都为1/2。若是x在数组里，
                    那么x在数组里所有位置的概率为1/n .
                     1 * 1/2n + 2 * 1/2n + .. + n * 1/2n + n * 1/2 
                     = (3n+1)/4
                    
       均摊时间复杂度:前n个操作复杂度都是O(1)，第n+1次操作的复杂度是O(n)，所以把最后一次的复杂度分摊到前n次上，那么均摊下来每次操作的复杂度为O(1)
             
  ### 空间的复杂度
        O(1) int i = 1;
        O(n) int []arr = new int[n]
        O(n^2) int [][] flat = new int[n][n]
 
          
