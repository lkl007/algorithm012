#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
'''
1.暴力法：sort之后 比较sorted array是否相同
2.hashmap 统计词频，第一个单词计数加一，第二个单词计数减一
'''
# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        m = collections.Counter()
        for i in range(0,len(s)):
            m[s[i]] += 1
            m[t[i]] -= 1


        for key in m:
            if m[key] != 0:
                return False
            else:
                return True

# @lc code=end

