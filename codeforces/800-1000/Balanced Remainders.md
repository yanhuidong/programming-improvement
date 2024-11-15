# [Balanced Remainders](https://codeforces.com/problemset/problem/1490/B)

这道题说实话没有翻译的话我肯定是看不懂的，只能说英语是真的很重要啊。

这道题我自己没有想出来，是直接看的别人的[题解](https://www.luogu.com.cn/article/93wasrbo)

下面是题解代码（我用leetcode的代码格式化修改过了）：

```cpp

#include <bits/stdc++.h>
using namespace std;
int T, n, k, cnt[5], f, ccnt, ans;
int main() {
    cin >> T;
    for (int TT = 1; TT <= T; TT++, ccnt = ans = 0) {
        cin >> n;
        k = n / 3;
        cnt[0] = cnt[2] = cnt[1] = -k;
        for (int i = 1; i <= n; i++) {
            cin >> f;
            cnt[f % 3]++;
        }
        for (int i = 1; i <= 3; i++) {
            // cout<<cnt[i-1]<<' ';
            if (cnt[i - 1] > 0)
                ccnt++;
        }
        // cout<<endl;
        if (ccnt == 1) // 只有一个多出,说明这个要匀给其他两个
        {
            if (cnt[0] > 0)
                ans = (-cnt[1]) + (-cnt[2] * 2);
            if (cnt[1] > 0)
                ans = (-cnt[2]) + (-cnt[0] * 2);
            if (cnt[2] > 0)
                ans = (-cnt[0]) + (-cnt[1] * 2);
        }
        if (ccnt == 2) // 有两个多出,说明负的要匀负给其他两个
        {
            if (cnt[0] < 0)
                ans = (cnt[2]) + (cnt[1] * 2);
            if (cnt[1] < 0)
                ans = (cnt[0]) + (cnt[2] * 2);
            if (cnt[2] < 0)
                ans = (cnt[1]) + (cnt[0] * 2);
        }
        cout << ans << endl;
    }
    return 0;
}
```
虽然看起来写的很啰嗦，但是已经很详细了，通俗易懂，基本把实现过程都实现了，虽然代码多，但是已经很厉害了。

下面是我直接发题目复制给GPT写的代码：

```cpp

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        
        // Reading the array
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        // Counting the remainders when elements are divided by 3
        vector<int> count(3, 0);
        for (int i = 0; i < n; i++) {
            count[a[i] % 3]++;
        }
        // Calculate the target count for each remainder
        int target = n / 3;
        int moves = 0;
        // Balancing process
        for (int i = 0; i < 6; i++) {
            int index = i % 3;
            if (count[index] > target) {
                int excess = count[index] - target;
                moves += excess;
                count[(index + 1) % 3] += excess;
                count[index] -= excess;
            }
        }
        // Output the result for the current test case
        cout << moves << endl;
    }
    return 0;
}

```

前半部分两个代码都是一样的意思，关键是看后面的 `for` 循环，下面是用 `grok` 详细描述这段代码的执行过程：

**代码执行过程**

```cpp
for (int i = 0; i < 6; i++) {
    int index = i % 3;
    if (count[index] > target) {
        int excess = count[index] - target;
        moves += excess;
        count[(index + 1) % 3] += excess;
        count[index] -= excess;
    }
}
```

**假设**：
- `count`是一个大小为3的数组，分别存储了输入数组中数字模3的余数的计数。
- `target`是每个余数应该有的目标数量，即`n / 3`。
- `moves`是记录需要移动的次数。

**详细描述**：

1. **外层循环 (`i`从0到5)**:
   - 这个循环会运行6次，因为`i`从0到5，意味着`index`会循环两次（0, 1, 2, 0, 1, 2）。

2. **计算当前索引 (`index = i % 3`)**:
   - `index`的值会是0, 1, 2, 0, 1, 2，分别对应`count`数组的三个元素。

3. **检查是否需要调整 (`if (count[index] > target)`)**:
   - 如果当前余数的数量大于目标数量`target`，则进入调整逻辑。

4. **计算多余的数量 (`excess = count[index] - target`)**:
   - `excess`表示当前余数的数量超过目标数量的部分。

5. **记录移动次数 (`moves += excess`)**:
   - 将需要移动的数量加到`moves`中。

6. **将多余的数量分配给下一个余数 (`count[(index + 1) % 3] += excess`)**:
   - 使用`(index + 1) % 3`来确定下一个余数的索引，将多余的数量加到下一个余数的计数中。

7. **调整当前余数数量 (`count[index] -= excess`)**:
   - 从当前余数的计数中减去多余的数量。

### 解释

- 这个循环的设计是为了确保每个余数的数量尽可能接近`target`。通过循环两次（0, 1, 2, 0, 1, 2），它允许余数之间的数量在两次循环中进行调整。
- 如果某个余数的数量超过`target`，则将多余的部分移动到下一个余数。这种移动是重复进行的，直到所有的余数数量都接近或等于`target`。
- 这种方法确保了即使在第一次循环中某些余数已经平衡了，它们在第二次循环中仍然有机会调整其他余数的数量，从而达到整体平衡。
- `moves`变量记录了所有这些调整操作的总次数。

这种方法虽然看起来简单，但它有效地利用了循环来确保每个余数的数量尽可能接近目标值，同时尽量减少操作的次数。
