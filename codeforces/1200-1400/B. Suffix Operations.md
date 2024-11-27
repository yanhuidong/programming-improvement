# [B. Suffix Operations](https://codeforces.com/problemset/problem/1453/B)

这道题是我看了[题解](https://www.luogu.com.cn/article/8wun78li)的思路但是没有看代码之后，自己按照题解写出来的，虽然中间写出了不少问题，但最终在我的不断排错之后，还是通过了，感觉还是很高兴的，
下面是我自己写的代码：

```cpp

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n;
vector<ll> nums(200100);
void solve() {
    cin >> n;
    ll res = 0;
    for (int i = 0; i < n; ++i) {
        cin >> nums[i];
        if (i > 0)
            res += abs(nums[i] - nums[i - 1]);
    }
    ll result;
    for (int i = 0; i < n; ++i) {
        ll sum = res;
        if (i == 0)
            sum -= abs(nums[1] - nums[0]);
        
        else if (i == n - 1) 
            sum -= abs(nums[n - 1] - nums[n - 2]);

        else {
            sum += abs(nums[i + 1] - nums[i - 1]) - abs(nums[i] - nums[i - 1]) - abs(nums[i + 1] - nums[i]);
        }
        result = min(result, sum);
    }
    cout << result << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
```

这道题说实话思路感觉也不是那么难想，但是我自己就是想不出来，只能说还是不够聪明啊，但是我会不断练习提高自己的👍。
