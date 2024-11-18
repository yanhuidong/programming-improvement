# [B. Startup](https://codeforces.com/contest/2036/problem/B)

wc，这道题给我写难受了，浪费一堆时间，本来挺简单一道题的，我的思路和官方题解的一模一样，先粘上代码来嘲笑一波🤣：

```cpp

#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        vector<int> hash(200001, 0);
        int n, k;
        cin >> n >> k;
        while (k--) {
            int b, c;
            cin >> b >> c;
            hash[b] += c;
        }
        sort(hash.rbegin(), hash.rend());
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += hash[i]; 
        }

        cout << res << endl;
    } 
    return 0;
}

```

虽然我看了 `n` 的范围， $n$ and $k$ ($1 \le n, k \le 2 \cdot 10^5$)，但是忘了看 `b` 的范围， $b_i$ and $c_i$ ($1 \le b_i \le k, 1 \le c_i \le 1000$) ，
导致我把数组的长度设到200001去了，你说这要是数据一多，不超时谁超时，官方题解就是数组的长度设置的和我不一样，我只能说题目要看全啊😅，下面是官方题解：

```cpp

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;
    vector<int> brand_cost(k, 0);
    for (int i = 0; i < k; i++) {
        int b, c;
        cin >> b >> c;
        brand_cost[b - 1] += c;
    }
    sort(brand_cost.rbegin(), brand_cost.rend());
    long long ans = 0;
    for (int i = 0; i < min(n, k); i++) {
        ans += brand_cost[i];
    }
    cout << ans << '\n';
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
```
