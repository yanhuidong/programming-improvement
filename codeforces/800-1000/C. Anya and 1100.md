# [C. Anya and 1100](https://codeforces.com/contest/2036/problem/C)

这道题说实话，题目看着感觉还挺简单的，但是实际写了就会发现我是废物😅，官方题解虽然解释的很简单，但是代码实现起来还是十分复杂的，而且里面还有一些很厉害的操作，下面先把代粘（我根据官方题解自己写的）：

```cpp

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
char s[1000000];
ll t, q, n;

bool check(ll i) {
    if (i < 0 || i + 3 >= n)
        return false;
    if (s[i] == '1' && s[i + 1] == '1' && s[i + 2] == '0' && s[i + 3] == '0')
        return true;
    return false;
}

void solve() {
    cin >> s;
    n = strlen(s);
    ll count = 0;
    cin >> q;
    for (int i = 0; i < n; ++i) {
        if (check(i))
            count++;
    }
    while (q--) {
        ll i, v;
        cin >> i >> v;
        i--;
        if (check(i) != v + '0') {
            bool before = check(i - 3) || check(i - 2) || check(i - 1) || check(i);
            s[i] = v +'0';
            bool after = check(i - 3) || check(i - 2) || check(i - 1) || check(i);
            count += after - before;
        }

        cout << (count ? "YES" : "NO") << endl;
    }
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
```

## 以下是官方题解里的解释：

First, in a naive way, let's count $count$ — the number of times “1100” occurs in $s$.

Then for each of $q$ queries we will update $count$: consider the substring $s[\max(1, i - 3); \min(i + 3, n)]$ before changing $s_i$ and find $before$ — the number of times that “1100” occurs in it. Then update $s_i = v$ and similarly find $after$ — the number of times that “1100” occurs in $s[\max(1, i - 3); \min(i + 3, n)]$ after applying the query.

Thus, by doing $count = count + (after - before)$, we get the number of times that “1100” occurs in $s$ after the query is applied. If $count &gt; 0$, the answer to the query is “YES”, otherwise it is “NO”.

Complexity: $O(|s| + q)$

## 相信你应该很快就能理解了，我接下来指出这里面很重要的一些技巧：

```cpp

bool check(ll i) {
    if (i < 0 || i + 3 >= n)
        return false;
    if (s[i] == '1' && s[i + 1] == '1' && s[i + 2] == '0' && s[i + 3] == '0')
        return true;
    return false;
}
```
这里的 `if (i < 0 || i + 3 >= n)` 是用来判断边界的，由于 `i` 在 `solve()` 输入之后立刻就被减1，所以传入 `check()` 里的是正确的下标，所以 `i` 本来的取值范围是 `[0, n - 3)`,
所以如果要判断是否出界的话，就要反着取范围，也就是 `i < 0 || i + 3 >= n`。

作为一道 **div 3** 比赛里的第三题，这道题看着不难，但是还是要看考验做题者对一些构造技巧的熟练度的，没用到什么算法，但是很考验基本功，是个值得多多推敲的题。
