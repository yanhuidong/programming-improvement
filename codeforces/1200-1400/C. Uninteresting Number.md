# [C. Uninteresting Number](https://codeforces.com/contest/2050/problem/C)

感觉构造题写多了，这道题好像也是一道构造题，需要自己找到规律。这道题最重要的规律就是**能被9整除的数，每位数之和一定时9的倍数**，于是就需要往这方面去补充思路，下面是官方题解，写的很详细

数字必须是数字这一要求对变换有如下限制：我们可以将 $0$ 变换为 $0$ ，将 $1$ 变换为 $1$ ，将 $2$ 变换为 $4$ ，将 $3$ 变换为 $9$ 。任何其他数字的平方都会超过 9，因此无法变换。
涉及 $0$ 和 $1$ 的变换都是无用的，因此我们有两种可能的操作：将数字 $2$ 或数字 $3$ 平方。

我们将使用 $9$ 的可除规则。它规定，当且仅当一个数字的数位之和能被 $9$ 整除时，这个数字才能被 $9$ 整除。让我们来看看数位之和在可能的变换中会发生怎样的变化。
如果我们对 $2$ 进行平方运算，数位之和将增加 $2^2 - 2 = 2$ ；如果我们对 $3$ 进行平方运算，数位之和将增加 $3^2 - 3 = 6$ 。

我们将计算数字中 $2$ 的位数和数字中 $3$ 的位数。我们可以从可用的数位 $2$ 和 $3$ 中选择转换的个数。变换超过 8 个 2 和超过 8 个 3 的余数是没有意义的，因为它们的变换加到总和中的余数模 $9$ 会重复。

因此，最终的解法是这样的：我们计算数字的位数之和，数出 $2$ 和 $3$ 的位数。我们将遍历改变 $2$ 的位数（可能为 0，但不超过 8 位），以及改变 $3$ 的位数（可能为 0，但也不超过 8 位）。
假设我们改变了 $x$ 个位数 $2$ 和 $y$ 个位数 $3$，那么这个数的个位数之和就增加了 $x * 2 + y * 6$ 。如果新的和能被 $9$ 整除，那么答案就是"是"。如果在迭代过程中从未出现过这种情况，则答案为 "否"。

于是根据以上方法，写出了以下代码（用AI把官方题解里的python代码改成的C++代码）

```cpp

#include<bits/stdc++.h>
using namespace std;
void solve() {
    string input;
    cin >> input;
    vector<int> s;
    for (char c : input) {
        s.push_back(c - '0'); 
    }

    int sm = accumulate(s.begin(), s.end(), 0);
    int twos = count(s.begin(), s.end(), 2);
    int threes = count(s.begin(), s.end(), 3);

    for (int i = 0; i <= min(8, twos); ++i) {
        for (int j = 0; j <= min(8, threes); ++j) {
            if ((sm + i * 2 + j * 6) % 9 == 0) {
                cout << "YES" << endl;
                return;
            }
        }
    }
    cout << "NO" << endl;
}

int main() {
    int t;
    cin >> t;
    for (int _ = 0; _ < t; ++_) {
        solve();
    }
    return 0;
}

```

以下是我自己优化的不使用额外空间的代码

```cpp

#include<bits/stdc++.h>
using namespace std;
int t;
string s;

void solve() {
    cin >> s;
    int sum = 0, twos = 0, threes = 0;
    for (char c : s) {
        int n = c - '0';
        sum += n;
        if (n == 2)
            twos++;
        if (n == 3)
            threes++;
    }

    for (int i = 0; i <= min(8, twos); ++i) {
        for (int j = 0; j <= min(8, threes); ++j) {
            if ((sum + i * 2 + j * 6) % 9 == 0) {
                cout << "YES" << '\n';
                return;
            }
        }
    }
    cout << "NO" << '\n';
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
}
```
