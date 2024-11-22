# [B. Bogosort](https://codeforces.com/problemset/problem/1312/B)

这道题我看题也就花了一会就看懂了，虽然还是有些单词不懂意思，但是不影响，然后就用了3分钟左右就想出思路了，只要把整个数组降序（从大到小）输出就可以了，绝对是对的，下面是代码：

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n;
vector<int> nums;
void solve() {
    nums.clear();
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        nums.push_back(num);
    }
    sort(nums.rbegin(), nums.rend());
    for (int a : nums)
        cout << a << ' ';
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

由于这道题思路这么简单，题解我也就懒得贴了应该大部分人都是我这样写的。
