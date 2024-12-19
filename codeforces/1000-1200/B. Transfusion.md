# [B. Transfusion](https://codeforces.com/contest/2050/problem/B)

这是一道div3的B题，直接干到1100分了，虽然这道题的标签里面没有构造，但是我感觉这道题可以看作是一道构造题，根据[官方题解](https://codeforces.com/blog/entry/137018)的方法来说，只需要找到规律
就可以很快写出来。但是我写的时候思路有点偏，我想的是能否通过每次遍历将左边的数变成最大值，右边的数变成1，然后通过比较是否符合规律来判断是否能实现，但是我还是太嫩了，这样那个是完全不对的，然后我
就用这个错误的思路写了半个多小时,然后就毁了，看了官方题解才恍然大悟。

下面是我只根据官方题解自己写的代码，不需要像官方题解那样还要多创建一个数组，可以使用常数级的空间

```cpp

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n;

void solve() {
    cin >> n;
    ll odds = 0, evens = 0, os = 0, es = 0;
    for (int i = 1; i <= n; ++i) {
        int c;
        cin >> c;
        if (i % 2 == 0) {
            evens += c;
            es++;
        }
        else {
            odds += c;
            os++;
        }
    }
    if (odds % os != 0 || evens % es != 0 || odds / os != evens / es) {
        cout << "NO" << '\n';
        return;
    }
    cout << "YES" << '\n';
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
```
