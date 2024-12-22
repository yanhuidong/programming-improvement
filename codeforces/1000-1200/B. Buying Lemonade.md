# [B. Buying Lemonade](https://codeforces.com/problemset/problem/2024/B)

这就是道div2的B题，也就1100分，但是我写的时候很痛苦啊，思路是非常好想的，但是实现起来就很不容易了，花了我几乎一整天的时间来写这玩意，写完以后发现一堆东西没考虑的，用脑子想感觉没漏啥啊，但就是一直
通不过，在写了一下午加半个晚上之后的第二天，我终于靠在平板上模拟一遍之后，发现还是少考虑了许多东西，在不断缝缝补补之后也算是通过了，虽然吃了两次整数溢出的WA，于是索性全都用 `long long` 了

下面是我自己写的代码

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    long long n, k; cin >> n >> k;
    int nums[200010]{};
    for (int i = 0; i < n; ++i) {
        cin >> nums[i];
    }
    
    sort(nums, nums + n);
    if (k <= nums[0] * n) {
        cout << k << '\n';
        return;
    }
    long long cnt0 = 0, cnt = 0, ans = 0;
    for (int i = 0; i < n; ++i) {
        if (nums[i] == 0) {
            cnt0++;
            nums[i + 1] -= cnt;
            continue;
        } else if (k > nums[i] * (n - i)){
            cnt += nums[i];
            nums[i + 1] -= cnt;
            k -= nums[i] * (n - i);
            ans += nums[i] * (n - i);
            cnt0++;
        } else {
            ans += k;
            break;
        }
    }
    cout << ans + cnt0 << '\n';
}

int main() {
    int t; cin >> t;
    while (t--)
        solve();
}
```
