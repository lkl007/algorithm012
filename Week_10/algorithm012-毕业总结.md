

# 毕业总结

算法训练营很快的结束了，练习之路道阻且长

# 摒弃旧习惯

不要死磕
五毒神掌（敢于放手、敢于死记硬背）
不懒于看高手代码（国际版的高票回答）

最佳方式：
5分钟想不出来，直接看题解或高票，用五毒神掌变成自己的东西。
最差方式：
死磕单挑，很快放弃。

五毒神掌关键是五，过遍数。一道题做五遍。

# 常见复杂度

![](https://raw.githubusercontent.com/FishPancake/fish-image/master/20200914144244.png)



# 二叉树遍历 Pre-order/In-order/Post-order

1.前序（Pre-order）：根-左-右
2.中序（In-order）：左-根-右
3.后序（Post-order）：左-右-根

示例代码

```python
def preorder(self, root): 
	if root: 
		self.traverse_path.append(root.val) 
		self.preorder(root.left) 
		self.preorder(root.right)
def inorder(self, root):
	if root: 
		self.inorder(root.left) 
		self.traverse_path.append(root.val) 
		self.inorder(root.right)
def postorder(self, root):
	if root: 
		self.postorder(root.left) 
		self.postorder(root.right) 
		self.traverse_path.append(root.val)
```

# 递归Recursion

## Python 代码模版

```python
def recursion(level, param1, param2, ...): 
\# recursion terminator 
	if level > MAX_LEVEL: 
		process_result 
		return
\# process logic in current level 
	process(level, data...) 
\# drill down 
	self.recursion(level + 1, p1, ...) 
\# reverse the current level status if needed 
```

## Java 代码模版

```java
public void recur(int level, int param) {
// terminator 
		if (level > MAX_LEVEL) {
// 			process result 
 		return; 
}
// process current logic 
 		process(level, param);
// drill down 
 		recur( level: level + 1, newParam);
// restore current status 
}
```

## 

# DFS与BFS

## 深度优先搜索Depth-First-Search

### DFS 代码 - 递归写法

```python
visited = set() 
def dfs(node, visited): 
if node in visited: # terminator 
# already visited 
return 
 visited.add(node) 
# process current node here. 
...
for next_node in node.children(): 
if not next_node in visited: 
 dfs(next node, visited)
```

### DFS 代码 - 非递归写法

```python
def DFS(self, tree): 
if tree.root is None: 
return [] 
 visited, stack = [], [tree.root] 
while stack: 
 node = stack.pop() 
 visited.add(node) 
 process (node) 
 nodes = generate_related_nodes(node) 
 stack.push(nodes) 
# other processing work 
...
```

## 广度优先搜索Breadth-First-Search

### BFS 代码

```python
def BFS(graph, start, end): 
 queue = [] 
 queue.append([start]) 
 visited.add(start) 
while queue: 
 node = queue.pop() 
 visited.add(node) 
 process(node) 
 nodes = generate_related_nodes(node) 
 queue.push(nodes) 
# other processing work 
...
```

# 二分查找

## 二分查找的前提

1. 目标函数单调性（单调递增或者递减）

2. 存在上下界（bounded）

3. 能够通过索引访问（index accessible)

## 代码模版

```python
left, right = 0, len(array) - 1
while left <= right:
 mid = (left + right) / 2
if array[mid] == target: # find the target!! 
break or return result 
 elif array[mid] < target:
 left = mid + 1
else:
 right = mid - 1
```



# 动态规划

## 递归代码模版

```java
public void recur(int level, int param) {
// terminator 
	if (level > MAX_LEVEL) {
// process result 
 		return; 
  }
// process current logic 
 	process(level, param);
// drill down 
 	recur( level: level + 1, newParam);
// restore current status 
}
```

## 分治Divide & Conquer

```python
def divide_conquer(problem, param1, param2, ...): 
# recursion terminator 
if problem is None: 
 print_result 
return
# prepare data 
 data = prepare_data(problem) 
 subproblems = split_problem(problem, data) 
# conquer subproblems 
 subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
 subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
 subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
… 
# process and generate the final result 
 result = process_result(subresult1, subresult2, subresult3, …) 
# revert the current level states
```



# 字典树Trie与并查集Disjoint Set

## 字典树Trie

```python
class Trie(object): 
  def __init__(self): 
   self.root = {} 
   self.end_of_word = "#"
  def insert(self, word): 
   node = self.root 
  for char in word: 
   node = node.setdefault(char, {}) 
   node[self.end_of_word] = self.end_of_word 
  def search(self, word): 
   node = self.root 
  for char in word: 
  if char not in node: 
  return False 
   node = node[char] 
  return self.end_of_word in node 
  def startsWith(self, prefix): 
   node = self.root 
  for char in prefix: 
  if char not in node: 
  return False 
   node = node[char] 
  return True
```
## 并查集Disjoint Set

#### java

```java
class UnionFind {
  private int count = 0;
  private int[] parent;
  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
     parent[i] = i; 
    } 
  }
  public int find(int p) {
    while (p != parent[p]) {
     parent[p] = parent[parent[p]];
     p = parent[p];
    }
  	return p; 
  }
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;
     parent[rootP] = rootQ;
     count--;
  } 
}
```
#### python

```python
def init(p): 
# for i = 0 .. n: p[i] = i; 
 p = [i for i in range(n)] 
def union(self, p, i, j): 
 p1 = self.parent(p, i) 
 p2 = self.parent(p, j) 
 p[p1] = p2 
def parent(self, p, i): 
 root = i 
while p[root] != root: 
 root = p[root] 
while p[i] != i: # 路径压缩 ? 
 x = i; i = p[i]; p[x] = root 
return root
```




# 排序算法

![image-20200914144736237](https://raw.githubusercontent.com/FishPancake/fish-image/master/image-20200914144736237.png)



## 排序算法复杂度

![image-20200914144808040](https://raw.githubusercontent.com/FishPancake/fish-image/master/image-20200914144808040.png)



## 初级排序 - O(n^2)

1. #### 选择排序（Selection Sort）

每次找最小值，然后放到待排序数组的起始位置。

2. #### 插入排序（Insertion Sort）

从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

3. #### 冒泡排序（Bubble Sort）

嵌套循环，每次查看相邻的元素如果逆序，则交换。

## 高级排序 - O(N*LogN)

#### • 快速排序（Quick Sort）

数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。

#### • 归并排序（Merge Sort）— 分治

1. 把长度为n的输入序列分成两个长度为n/2的子序列；
2. 对这两个子序列分别采用归并排序；
3. 将两个排序好的子序列合并成一个最终的排序序列。

<!--归并 和 快排 具有相似性，但步骤顺序相反-->
<!--归并：先排序左右子数组，然后合并两个有序子数组-->
<!--快排：先调配出左右子数组，然后对于左右子数组进行排序-->

#### • 堆排序（Heap Sort） — 堆插入 O(logN)，取最大/小值 O(1)

1. 数组元素依次建立小顶堆

2. 依次取堆顶元素，并删除

## 特殊排序 - O(n)

#### • 计数排序（Counting Sort）

计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组

#### • 桶排序（Bucket Sort）

桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

#### • 基数排序（Radix Sort）

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。

## 排序动画

• https://www.cnblogs.com/onepixel/p/7674659.html

• https://www.bilibili.com/video/av25136272

• https://www.bilibili.com/video/av63851336


# 毕业刷题路线

## 基础

- [两数之和](http://leetcode-cn.com/problems/two-sum)（简单）
- [有效的括号](http://leetcode-cn.com/problems/valid-parentheses/)（简单）
- [字符串解码](http://leetcode-cn.com/problems/decode-string/)（中等）
- [LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache/submissions/)（困难）
- [实现 Trie（前缀树）](http://leetcode-cn.com/problems/implement-trie-prefix-tree/)（中等）
- [添加与搜索单词 - 数据结构设计](http://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)（中等）
- [单词搜索 II ](http://leetcode-cn.com/problems/word-search-ii/)（困难）
- [找不同](http://leetcode-cn.com/problems/find-the-difference/)（简单）
- [单词规律](http://leetcode-cn.com/problems/word-pattern/)（简单）
- [字符串中的第一个唯一字符](http://leetcode-cn.com/problems/first-unique-character-in-a-string)（简单）
- [无重复字符的最长子串](http://leetcode-cn.com/problems/longest-substring-without-repeating-characters)（中等）
- [最小覆盖子串](http://leetcode-cn.com/problems/minimum-window-substring/)（困难）
- [合并两个有序链表](http://leetcode-cn.com/problems/merge-two-sorted-lists)（简单）
- [环形链表](http://leetcode-cn.com/problems/linked-list-cycle)（简单）
- [环形链表 II ](http://leetcode-cn.com/problems/linked-list-cycle-ii)（中等）
- [反转链表](http://leetcode-cn.com/problems/reverse-linked-list)（简单）
- [反转链表 II ](http://leetcode-cn.com/problems/reverse-linked-list-ii)（中等）
- [旋转链表](http://leetcode-cn.com/problems/rotate-list)（中等）
- [排序链表](http://leetcode-cn.com/problems/sort-list/)
- [链表中倒数第 k 个节点](http://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
- [两两交换链表中的节点](http://leetcode-cn.com/problems/swap-nodes-in-pairs)（中等）
- [按奇偶排序数组](http://leetcode-cn.com/problems/sort-array-by-parity/)（简单）
- [按奇偶排序数组 II ](http://leetcode-cn.com/problems/sort-array-by-parity-ii/)（简单）
- [有序数组的平方](http://leetcode-cn.com/problems/squares-of-a-sorted-array/)（简单）
- [山脉数组的峰顶索引](http://leetcode-cn.com/problems/peak-index-in-a-mountain-array)（简单）
- [搜索旋转排序数组](http://leetcode-cn.com/problems/search-in-rotated-sorted-array)（困难）
- [搜索旋转排序数组 II ](http://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)（中等）
- [寻找旋转排序数组中的最小值](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)（中等）
- [寻找旋转排序数组中的最小值 II ](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)（困难）
- [搜索二维矩阵](http://leetcode-cn.com/problems/search-a-2d-matrix)（中等）
- [等式方程的可满足性](http://leetcode-cn.com/problems/satisfiability-of-equality-equations/)（中等）
- [朋友圈](http://leetcode-cn.com/problems/friend-circles/)（中等）
- [账户合并](http://leetcode-cn.com/problems/accounts-merge/)（中等）

## 深度优先搜索

- [二叉树的最大深度](http://leetcode-cn.com/problems/maximum-depth-of-binary-tree)（简单）
- [路径总和](http://leetcode-cn.com/problems/path-sum/)（简单）
- [路径总和 II ](http://leetcode-cn.com/problems/path-sum-ii/)（中等）
- [被围绕的区域](http://leetcode-cn.com/problems/surrounded-regions/)（中等）
- [岛屿数量](http://leetcode-cn.com/problems/number-of-islands/)（中等）
- [岛屿的最大面积](http://leetcode-cn.com/problems/max-area-of-island/)（中等）
- [在二叉树中分配硬币](http://leetcode-cn.com/problems/distribute-coins-in-binary-tree/)（中等）

## 回溯

- [括号生成](http://leetcode-cn.com/problems/generate-parentheses/)（中等）
- [N 皇后](http://leetcode-cn.com/problems/n-queens/)（困难）
- [N 皇后 II ](http://leetcode-cn.com/problems/n-queens-ii/)（困难）
- [解数独](http://leetcode-cn.com/problems/sudoku-solver/) （中等）
- [不同路径 III ](http://leetcode-cn.com/problems/unique-paths-iii/)（困难）
- [单词搜索](http://leetcode-cn.com/problems/word-search/)（中等）

## 分治

- [搜索二维矩阵 II ](http://leetcode-cn.com/problems/search-a-2d-matrix-ii/)（中等）
- [合并 K 个排序链表](http://leetcode-cn.com/problems/merge-k-sorted-lists)（中等）
- [为运算表达式设计优先级](http://leetcode-cn.com/problems/different-ways-to-add-parentheses)（中等）
- [给表达式添加运算符](http://leetcode-cn.com/problems/expression-add-operators)（困难）
- [数组中的第 K 个最大元素](http://leetcode-cn.com/problems/kth-largest-element-in-an-array)（中等）
- [最接近原点的 K 个点](http://leetcode-cn.com/problems/k-closest-points-to-origin/)（中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）

## 动态规划

- [使用最小花费爬楼梯](http://leetcode-cn.com/problems/min-cost-climbing-stairs)（简单）
- [爬楼梯](http://leetcode-cn.com/problems/climbing-stairs)（简单）
- [不同路径](http://leetcode-cn.com/problems/unique-paths/)（简单）
- [最小路径和](http://leetcode-cn.com/problems/minimum-path-sum/) （中等）
- [最大子序和](http://leetcode-cn.com/problems/maximum-subarray/) （简单）
- [乘积最大子数组](http://leetcode-cn.com/problems/maximum-product-subarray/)（中等）
- [买卖股票的最佳时机](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)（简单）
- [买卖股票的最佳时机 II ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)（简单）
- [买卖股票的最佳时机 III ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)（困难）
- [买卖股票的最佳时机 IV ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)（困难）
- [最佳买卖股票时机含冷冻期](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)（中等）
- [买卖股票的最佳时机含手续费](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)（中等）
- [零钱兑换](http://leetcode-cn.com/problems/coin-change) （中等）
- [零钱兑换 II ](http://leetcode-cn.com/problems/coin-change-2)（中等）
- [编辑距离](http://leetcode-cn.com/problems/edit-distance)（困难）
- [不同的子序列](http://leetcode-cn.com/problems/distinct-subsequences/)（困难）
- [柱状图中最大的矩形](http://leetcode-cn.com/problems/largest-rectangle-in-histogram/)（困难）
- [最大矩形](http://leetcode-cn.com/problems/maximal-rectangle/)（困难）
- [最大正方形](http://leetcode-cn.com/problems/maximal-square/)（中等）
- [最低票价](http://leetcode-cn.com/problems/minimum-cost-for-tickets/)（中等）
- [区域和检索 - 数组不可变](http://leetcode-cn.com/problems/range-sum-query-immutable/)（简单）
- [二维区域和检索 - 矩阵不可变](http://leetcode-cn.com/problems/range-sum-query-2d-immutable/)（中等）
- [最长上升子序列](http://leetcode-cn.com/problems/longest-increasing-subsequence) （中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）