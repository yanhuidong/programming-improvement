# [D. Kousuke's Assignment](https://codeforces.com/contest/2033/problem/D)

一道div3的D题，但是比C题的分数要低一点，但也是道1400的题，需要用到动态规划（Dynamic Programming）思想，感觉官方的和洛谷的题解都不是很好懂，这里还是直接看AI生成的好理解一点

以下是看题解写的代码，用AI生成了注释

```cpp

#include<bits/stdc++.h>  // 包含常用的头文件，如iostream, vector, algorithm等
using namespace std;

// 定义一个函数solve，用于处理每个测试用例
void solve() {
    int n;  // 定义一个整数n，表示数组的长度
    cin >> n;  // 从标准输入读取n的值

    int nums[100010]{};  // 定义一个大小为100010的数组nums，并初始化为0，用于存储输入的数组元素
    set<long long> check;  // 定义一个set集合check，用于存储前缀和，判断是否出现过
    check.insert(0);  // 在check中插入0，表示前缀和为0的情况

    long long sum = 0, ans = 0;  // 定义两个长整型变量sum和ans，sum用于计算前缀和，ans用于记录满足条件的子数组个数

    // 遍历数组中的每个元素
    for (int i = 1; i <= n; ++i) {
        cin >> nums[i];  // 读取数组的第i个元素
        sum += nums[i];  // 计算当前的前缀和

        // 如果当前前缀和已经在check中出现过，说明从某个位置到当前位置的子数组和为0
        if (check.count(sum)) {
            ans++;  // 满足条件的子数组个数加1
            sum = 0;  // 重置前缀和为0
            check.clear();  // 清空check集合
            check.insert(0);  // 重新插入0，表示新的前缀和计算开始
        } else {
            check.insert(sum);  // 如果当前前缀和没有出现过，则将其插入check集合中
        }
    }

    cout << ans << endl;  // 输出满足条件的子数组个数
}

int main() {
    cin.tie(NULL);  // 取消cin与cout的绑定，提高输入输出效率
    ios_base::sync_with_stdio(false);  // 关闭C++标准库与C标准库的同步，提高输入输出效率

    int t;  // 定义一个整数t，表示测试用例的个数
    cin >> t;  // 从标准输入读取t的值

    // 循环处理每个测试用例
    while (t--)
        solve();  // 调用solve函数处理当前测试用例

    return 0;  // 程序正常结束
}
```

**注意**：这里不能使用 `unordered_set` ，会超时，原因是之后的测试案例哈希冲突过于严重，导致 `unordered_set` 的插入和查找功能的时间复杂度达到 $O(N)$，具体可以看看[unordered_set和set对比](../../库函数%20&%20扩展知识/unordered_set与set对比.md)

以下是对代码的详细分析，包括代码的功能、实现思路、关键点以及时间复杂度等。

---

### **代码功能**
该代码用于处理多个测试用例，每个测试用例包含一个整数数组。对于每个数组，代码计算满足条件的子数组个数，这些子数组的和为0。具体来说：
1. 输入一个长度为 `n` 的数组。
2. 通过计算前缀和，判断是否存在某个子数组的和为0。
3. 统计满足条件的子数组个数，并输出结果。

---

### **实现思路**
1. **前缀和**：
   - 前缀和是指从数组起始位置到当前位置的所有元素之和。
   - 如果两个前缀和相等，说明这两个位置之间的子数组和为0。
   - 例如，数组 `[1, -1, 2, -2]` 的前缀和为 `[1, 0, 2, 0]`，其中前缀和为0的位置表示子数组和为0。

2. **Set集合**：
   - 使用一个 `set<long long>` 集合 `check` 来存储已经出现过的前缀和。
   - 初始化时，将0插入集合中，表示前缀和为0的情况。
   - 遍历数组时，计算当前的前缀和 `sum`，并检查 `sum` 是否已经存在于集合中：
     - 如果存在，说明从某个位置到当前位置的子数组和为0，计数器 `ans` 加1，并重置前缀和和集合。
     - 如果不存在，将当前前缀和插入集合中。

3. **重置机制**：
   - 当发现一个子数组和为0时，重置前缀和 `sum` 为0，并清空集合 `check`，重新开始计算前缀和。
   - 这样可以确保每个子数组和为0的区间是独立的。

---

### **关键点**
1. **前缀和的应用**：
   - 通过前缀和可以快速判断子数组的和是否为0。
   - 如果两个前缀和相等，说明这两个位置之间的子数组和为0。

2. **Set集合的作用**：
   - 用于存储已经出现过的前缀和，方便快速查找。
   - 初始化时插入0，表示前缀和为0的情况。

3. **重置机制**：
   - 当发现一个子数组和为0时，重置前缀和和集合，确保每个子数组和为0的区间是独立的。

---

### **时间复杂度分析**
1. **遍历数组**：
   - 代码中有一个 `for` 循环，遍历数组的每个元素，时间复杂度为 \(O(n)\)。

2. **Set操作**：
   - 每次插入和查找操作的时间复杂度为 \(O(\log k)\)，其中 \(k\) 是集合中的元素个数。
   - 在最坏情况下，集合中的元素个数为 \(n\)，因此每次操作的时间复杂度为 \(O(\log n)\)。

3. **总体时间复杂度**：
   - 对于每个测试用例，时间复杂度为 \(O(n \log n)\)。
   - 如果有 \(t\) 个测试用例，总时间复杂度为 \(O(t \cdot n \log n)\)。

---

### **空间复杂度分析**
1. **数组 `nums`**：
   - 数组大小为100010，空间复杂度为 \(O(1)\)（常数空间）。

2. **Set集合 `check`**：
   - 在最坏情况下，集合中可能存储 \(n\) 个元素，空间复杂度为 \(O(n)\)。

3. **总体空间复杂度**：
   - 对于每个测试用例，空间复杂度为 \(O(n)\)。

---

### **示例运行**
#### 输入：
```
2
4
1 -1 2 -2
5
1 2 3 -6 1
```

#### 输出：
```
2
1
```

#### 解释：
1. 对于数组 `[1, -1, 2, -2]`：
   - 子数组 `[1, -1]` 和为0。
   - 子数组 `[2, -2]` 和为0。
   - 满足条件的子数组个数为2。

2. 对于数组 `[1, 2, 3, -6, 1]`：
   - 子数组 `[1, 2, 3, -6]` 和为0。
   - 满足条件的子数组个数为1。

---

### **总结**
- 该代码通过前缀和和Set集合高效地解决了“统计子数组和为0的个数”问题。
- 时间复杂度为 \(O(t \cdot n \log n)\)，空间复杂度为 \(O(n)\)，适用于中等规模的数据。
- 代码逻辑清晰，实现简洁，但需要注意Set操作的时间复杂度。