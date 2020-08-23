/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    int[] father = new int[200];

    public int find(int x) {
        if (father[x] == x) return x;
        //路径压缩
        return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        //初始化f[i]=i
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int i = 0; i < n; i++) {
            //对称矩阵
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        //统计父节点个数
        int res = 0;
        for (int i = 0; i < n; i++) {
            //如果f[i] = i，则说明i就是一个父节点
            if (father[i] == i) {
                res++;
            }
        }
        return res;
    }
}

// @lc code=end

