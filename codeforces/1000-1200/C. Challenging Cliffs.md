# [C. Challenging Cliffs](https://codeforces.com/problemset/problem/1537/C)

又是一道思维构造题，但是我还是没有像出来就是了😅，但是看了[题解](https://www.luogu.com.cn/article/ykk8cxjn)也是醍醐灌顶啊，下面是我自己根据题解自己写的代码，虽然刚写完后有不少的问题，
例如我把 `m` 设置成全局变量，导致每次循环后没有重新给 `m` 赋初始值，导致几次循环之后结果就出错了。

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n;

vector<int> nums;

void solve() {
    int m = INT_MAX;
    nums.clear();
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        nums.push_back(num);
    }

    sort(nums.begin(), nums.end());
    int k = 0;
    for (int i = 0; i < n - 1; ++i) {
        if (m > nums[i + 1] - nums[i]) {
            m = nums[i + 1] - nums[i];
            k = i;
        }
    }

    cout << nums[k] << ' ';
    for (int i = k + 2; i < n; ++i) {
        cout << nums[i] << ' ';
    }
    for (int i = 0; i < k; ++i) {
        cout << nums[i] << ' ';
    }
    cout << nums[k + 1] << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;
}
```
