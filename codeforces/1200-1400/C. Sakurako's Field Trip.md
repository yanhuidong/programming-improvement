# [C. Sakurako's Field Trip](https://codeforces.com/contest/2033/problem/C)

一道div3的C题，直接干到1400了，算是一道动态规划题，运用了贪心思维，从局部最优得到全局最优，思路在下面

---

请注意，答案会受到相邻元素的影响。因此，我们可以将元素 $i$ 和 $n - i + 1$ 与元素 $i - 1$ 和 $n - i + 2$ 放在最佳位置。

因此，我们需要为由 $4$ 个元素组成的数组选择最佳顺序。让我们考虑几种类型的数组：

- $[1, x, y, 1]$ 或 $[x, 1, 1, y]$ （"1 "表示相等的元素）：交换不会改变答案；
- $[1, 1, y, 2]$ ：如果是 $y \ne 1$ ，交换将改善答案，否则答案不会改变；

因此，如果是 $a[i - 1] = a[i]$ 或 $a[n - i + 2] = a[n - i + 1]$ ，那么交换元素 $a[i]$ 和 $a[n - i + 1]$ 要么不会改变答案，要么会改善答案。在完成所有交换后，我们只需计算最终扰动。

---

我自己原本的的思路也基本和官解是一样的，可以看看下面的代码，是deepseek用我的代码生成的，基本就是我自己的思路

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    vector<int> nums(n + 1);
    for (int i = 1; i <= n; ++i)
        cin >> nums[i];

    // 交换逻辑
    for (int i = 1; i <= n / 2; ++i) {
        int j = n - i + 1;
        // 计算不交换的干扰
        int interference1 = (nums[i] == nums[i - 1]) + (nums[j] == nums[j + 1]);
        // 计算交换后的干扰
        swap(nums[i], nums[j]);
        int interference2 = (nums[i] == nums[i - 1]) + (nums[j] == nums[j + 1]);
        // 如果交换后干扰更大，则换回来
        if (interference2 > interference1)
            swap(nums[i], nums[j]);
    }

    // 计算总干扰
    int ans = 0;
    for (int i = 2; i <= n; ++i) {
        if (nums[i] == nums[i - 1])
            ans++;
    }
    cout << ans << endl;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int t; cin >> t;
    while (t--)
        solve();
    return 0;
}
```

然后根据官解的思路来修改的话，就是如下代码

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    vector<int> nums(n + 2, 0);
    for (int i = 1; i <= n; ++i)
        cin >> nums[i];
    for (int i = 1; i <= n / 2; ++i) {
        int j = n - i + 1;
        if (nums[i] == nums[i - 1] || nums[j] == nums[j + 1])
            swap(nums[i], nums[j]);
    }
    int ans = 0;
    for (int i = 1; i < n; ++i) {
        if (nums[i] == nums[i + 1])
            ans++;
    }
    cout << ans << endl;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int t; cin >> t;
    while (t--)
        solve();
    return 0;
}
```
