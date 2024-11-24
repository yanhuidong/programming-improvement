# [B. Random Teams](https://codeforces.com/problemset/problem/478/B)

这道题有用到[抽屉原理](../库函数%20&%20扩展知识/抽屉原理.md)的原理，在计算最小值时，先平均地将每一组人数等分，直到多余的人数无法等分，此时朋友数最小，可以看看这篇
[题解](https://www.luogu.com.cn/article/tdq4ojwj)，写的还可以，虽然不如我写的那么详细，略过了一些判断条件，也不知道他的能不能过，反正就看我在下面贴的代码就ok了。

```cpp

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll add(ll a) {
    return a * (a - 1) / 2;
}

void solve() {
    ll n, m;
    cin >> n >> m;
    if (n == m) {
        cout << 0 << ' ' << 0;
        return;
    }

    else if (n - m == 1) {
        cout << 1 << ' ' << 1;
        return;
    }

    else {
        ll maximum = add(n - m + 1);
        ll x = n / m;
        ll y = n % m;
        ll minimum = (m - y) * add(x) + y * add(x + 1);
        cout << minimum << ' ' << maximum;
    }
}

int main() {
    solve();
    return 0;
}

```
