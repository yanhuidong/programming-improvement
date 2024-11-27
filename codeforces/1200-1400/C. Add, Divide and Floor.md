# [C. Add, Divide and Floor](https://codeforces.com/contest/1901/problem/C)

这道题我和赵子奥一起想了十多分钟，想到了不少情况，但是和正确的思路相差的有点远了，我们过分专注于规律这个东西了，导致我们忘记了最重要的东西，无论怎么变，原来数组内所有元素的
大小顺序都是不变的，这样就只要关注最大值和最小值就可以了，这一点很重要，然后就是判断一下奇偶了，可以看看洛谷的[题解](https://www.luogu.com.cn/article/nhj54fg5)，但是他
写的挺繁琐的，之后可以看看官方的[题解](https://codeforces.com/blog/entry/122645)，虽然题解是用python写的，但是还是能看懂的，下面是我根据官方题解写的C++代码：

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n;
vector<int> arr;

void solve() {
    arr.clear();
    cin >> n;
    int a = INT_MIN, b = INT_MAX;
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        a = max(a, num);
        b = min(b, num);
    }
    int res = 0;
    while (a != b) {
        res = b & 1 ? 1 : 0;
        a = (a + res) / 2;
        b = (b + res) / 2;
        arr.push_back(res);
    }
    cout << arr.size() << endl;
    if (arr.size() <= n) {
        for (int c : arr)
            cout << c << ' ';
        cout << endl;
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
