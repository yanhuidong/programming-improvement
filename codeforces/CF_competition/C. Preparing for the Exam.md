# [C. Preparing for the Exam](https://codeforces.com/contest/2051/problem/C)

一道div3的C题，堪堪1000分，思路一般好想，只需要特殊判断一些案例就可以，当 `k = n` 时所有题都会，全部都输出1，当 `k = n - 1` 时，说明只有有一道题不会，其他题都会，意思就是说你只能写没有这道题的
题单，意思就是说只能有一个1，其他的都是0，因为其他的题单是一定会有这道不会的题的。于是结果就显而易见了，直接看我写的代码，虽然是看了官方题解写的

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n, m, k;
    cin >> n >> m >> k;
    int question[n + 1];
    bool answer[n + 1];
    fill(answer + 1, answer + n + 1, false);
    for (int i = 1; i <= m; ++i)
        cin >> question[i];
    for (int i = 1; i <= k; ++i) {
        int s; cin >> s;
        answer[s] = true;
    }
    for (int i = 1; i <= m; ++i) {
        if (k == n || (k == n - 1 && !answer[question[i]]))
            cout << '1';
        else
            cout << '0';
    }
    cout << '\n';
}

int main() {
    int t; cin >> t;
    while (t--) 
        solve();
    return 0;
}
```
