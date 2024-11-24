# [B. Phoenix and Beauty](https://codeforces.com/problemset/problem/1348/B)

又是一道考验思维的构造题，看[题解](https://www.luogu.com.cn/article/5u76o8rd)的话很好看懂，但是自己想还是挺难想出来的，还是要靠多练习，下面是我看题解自己敲的代码，
我发现我如果是吧数组或者哈希表这类存储结构定义在开头的话，老是会忘了用[clear](../../库函数%20&%20扩展知识/clear.md)来清空，导致结果出错，这就很不应该。

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n, k;
unordered_set<int> check;
void solve() {
    check.clear();
    cin >> n >> k;
    for (int i = 0; i < n; ++i) {
        int c;
        cin >> c;
        check.insert(c);
    }
    if (check.size() > k) {
        cout << -1 << endl;
        return;
    }
    cout << n * k << endl;
    for (int i = 0; i < n; ++i) {
        for (int cnt : check) 
            cout << cnt << ' ';
        
        for (int i = 0; i < k - check.size(); ++i) 
            cout << n << ' ';
    }
    cout << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;  
}
```
