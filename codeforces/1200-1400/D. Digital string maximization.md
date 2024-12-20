# [D. Digital string maximization](https://codeforces.com/contest/2050/problem/D)

一道div3的D题，1300分，果然还是有一定难度的，思路说实话没有什么弯弯绕，其实还是比较好想的，虽然我依旧想不出来就是了，但是这道题也是很有意思的，有用到贪心思想，下面是官方题解，看一下就懂了

让我们来看数位 $s_i$ 。我们可以看到，我们不能将它向左移动超过 $s_i$ 次，因为它之后将是 $0$ 。因此，我们可以说，只有从 $i$ 到 $i+9$ 的指数上的数字才能站在指数 $i$ 上，
因为最大的数字 $9$ 向左移动的次数不能超过 $9$ 。

因此，对于每一个 $i$ ，我们可以强求从 $s_i$ 到 $s_{i+9}$ 的所有数字，并选取 $j$ 中的 $s_j - (j - i)$ 为最大值；如果有多个最大值选项，我们将最小化 $j$ 。之后，我们将 $s_j$ 向左移动，
直到它位于索引 $i$ 上。

下面是根据官方题解写的代码，真的很简单易懂，值得学习

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    string s; cin >> s;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
        int best = s[i] - '0', pos = i;
        for (int j = i; j < min(i + 9, n); ++j) {
            if (s[j] - '0' - (j - i) > best) {
                pos = j;
                best = s[j] - '0' - (j - i);
            }
        }

        while (pos > i) {
            swap(s[pos], s[pos - 1]);
            pos--;
        }
        s[i] = static_cast<char> (best + '0');
    }
    cout << s << '\n';
}

int main() {
    int t; cin >> t;
    while (t--)
        solve();
}
```
