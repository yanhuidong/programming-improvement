# [C. Trinity](https://codeforces.com/contest/2032/problem/C)

一道div2的C题，1400分，有难度的兄弟们。类不定长滑动窗口思路，没有给出窗口长度，需要做题者自己找出规律，[官方题解](https://codeforces.com/blog/entry/135622)就写的非常好，不过官方题解的代码用的是
C++23的，有些写法看不太懂，我自己改得简单一点，看起来舒服一些

### 下面是官方题解的中文翻译（AI翻译）：

为了不失一般性，我们假设下面提到的每个数组都是按非降序排序的。

一个包含 k 个元素（k≥3）的数组 b，若满足 b[1] + b[2] > b[k]，则满足问题要求。
证明如下：b[1] + b[2] 是数组 b 中任意两个不同元素的最小和，如果这个和大于数组 b 的最大元素，那么数组 b 中的任意一对不同元素之和都将大于 b 中任何单个元素。

我们答案的上限是 n - 2。可以这样做：将 a[2] 到 a[n-1] 的所有值变为 a[n]，这样我们就只剩下两种类型的三角形：(a[1], a[n], a[n]) 和 (a[n], a[n], a[n])。
因为 a[1] ≥ 1 > 0，所以我们有 a[1] + a[n] > a[n]，这意味着前一种类型的三角形是非退化的。后者也显然是非退化的，因为它是一个正三角形。

否则，我们需要一对索引 (i, j)（1 ≤ i ≤ n-2，i+2 ≤ j ≤ n），这样在对数组 a 应用操作后的最终数组中，a[i] 和 a[i+1] 分别是最小和次小的元素，而 a[j] 是最大的元素。
这对索引必须满足条件 a[i] + a[i+1] > a[j]。

考虑满足上述条件的一对 (i, j)，我们需要将 i 之前和 j 之后的元素转变为在 [a[i+1], a[j]] 范围内的某个元素，实际上我们可以将它们都变为 a[i+1]，这样就保持了 a[i]、a[i+1] 和 a[j] 的相对排名不变。
因此，对于这样的一个对 (i, j)，所需的操作数为 n - (j - i + 1)。这意味着对于每一个 i，我们需要找到满足条件的最大 j > i，这可以通过双指针方法轻松实现。

- 排序复杂度：O(n log n)。
- 双指针复杂度：O(n)。

### 下面是我根据官方题解翻新的代码

```cpp

#include<bits/stdc++.h>
using namespace std;
vector<int> nums;

void solve() {
    int n; cin >> n;
    nums.clear(); nums.resize(n);
    for (int i = 0; i < n; ++i)
        cin >> nums[i];
    sort(nums.begin(), nums.end());
    int l = 0, ans = n - 2;
    for (int r = 2; r < n; ++r) {
        while (r - l >= 2 && nums[l] + nums[l + 1] <= nums[r])
            l++;
        ans = min(ans, n - (r - l + 1));
    }
    cout << ans << endl;
}

int main() {
    int t; cin >> t;
    while (t--)
        solve();
}
```
