# [K-divisible Sum](https://codeforces.com/problemset/problem/1476/A)

很快啊，啪的一下就有了思路，然后在错误提交了两三次之后才知道还有不少条件没考虑到。
首先就是在 `n > k` 的部分中，我没有考虑到 `n % k == 0` 的情况，导致结果出错，然后同样的，在 `n < k` 的部分中，我忘了 `k % n == 0` 的情况，这些错误都是不应该出现的，
每次都是**读题读一半，写题错一堆**，毁了啊。

下面是我经过四五次的错误提交之后得到的正确结果，虽然之前没有接触过，但是我的思路确实运用到了[抽屉原理](../库函数%20&%20扩展知识/抽屉原理.md)的知识：

```cpp

#include<bits/stdc++.h>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        if (n == 1) {
            cout << k << endl;
            continue;
        }
        if (n == k)
            cout << 1 << endl;
        else if (n < k) {
            int d = k / n;
            if (k % n == 0)
                cout << d << endl;
            else
                cout << d + 1 << endl;
        }
        else {
            if (n % k == 0)
                cout << 1 <<endl;
            else
                cout << 2 << endl;
        }
    }
    return 0;
}
```
