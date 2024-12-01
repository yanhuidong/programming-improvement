# [B. Rakhsh's Revival](https://codeforces.com/contest/2034/problem/B)

这是一道滑动窗口类型的题目，`m `是窗口长度，官方的[题解](https://codeforces.com/blog/entry/136579)的思路和我的是基本一样的，这里我就不多说了，但是思路有了也不一定就可以实现，一开始我以为输入的
那 `n` 个数字是分别输入的，搞得我一直都写不出来，之后才知道是一次性输入的，给我整不会了，但是我就算改回来了，结果还是会出错，明明我觉得我的思路是没有问题的啊。
下面是我的错误代码，到现在还不知道哪里错了（看来之后要学一下怎么调试代码了）,如果未来的我复习到了这道题目，希望你可以把这个代码给改正:

```cpp

#include <bits/stdc++.h>
using namespace std;
int t, n, m, k;
void solve() {
    cin >> n >> m >> k;
    string s;
    cin >> s;
    int res = 0;
    int cnt = 0;

    for (int i = 0; i < m - 1; ++i) {
        if (s[i] == '0')
            cnt++;
    }
    for (int i = m - 1; i < n; ++i) {
        if (s[i] == '0')
            cnt++;
        if (cnt == m) {
            res++;
            for (int j = i; j < min(i + k, n); ++j) {
                s[j] = '1';
            }
            cnt = 0;
            i = min(i + k - 1, n);
        }
        if (s[i - m + 1] == '0') {
            cnt--;
        }
    }
    cout << res << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
}
```
