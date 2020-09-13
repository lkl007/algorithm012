/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
// 哈希表
/* 
// 1.为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
// S 和 T 都只包含 A-Z 的字母，用一个简单的 26 位计数器表。
// 2.不需要两个计数器数表进行比较，可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
// 时间复杂度：O(n)。时间复杂度为 O(n) 因为访问计数器表是一个固定的时间操作。
// 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 N 有多大，表的大小都保持不变。

class Solution {
    public boolean isAnagram (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count:counter) {
            if (count != 0) return false;
        }
        return true;
    }
}
 */

//或者先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，则 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。
class Solution{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a'] --;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

// 进阶：
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

// 解答：
// 使用哈希表而不是固定大小的计数器。想象一下，分配一个大的数组来适应整个 Unicode 字符范围，这个范围可能超过 100万。
// 哈希表是一种更通用的解决方案，可以适应任何字符范围。

// @lc code=end

