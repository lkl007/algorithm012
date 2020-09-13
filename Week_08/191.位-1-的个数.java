/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
/* 
以下方法都需要算32次
1.for loop：32次
2.%2，/2，相当于把最后一位打掉
3.&1，x = x >> 1
有多少个1就循环多少次
4.while(x > 0) {count++; x = x & (x - 1);}
 */
/* 
//法一：位掩码mask
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
 */
//法二：x & (x - 1)
public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum ++;
            n &= (n - 1);
        }
        return sum;
    }
}

// @lc code=end

