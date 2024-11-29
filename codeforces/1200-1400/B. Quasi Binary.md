# [B. Quasi Binary](https://codeforces.com/problemset/problem/538/B)

有些人说简单，有些人又说难，只能说因人而异，但是我觉得还是有点难度的，因为我想不到😅，但是看了[题解](https://www.luogu.com.cn/article/7ld351er)之后感觉只是想到思路的话还是挺简单的，但是要用代码实现的话就有点困难了，下面是根据题解写的代码

```cpp

#include<bits/stdc++.h>
using namespace std;
int n;
int nums[10];

void solve() {
    cin >> n;
    int res = 0;
    for (int bit = 1; bit <= n; bit *= 10) {
        int single = (n / bit) % 10;
        res = max(res, single);
        for (int i = 0; i < single; ++i)
            nums[i] += bit;
    }

    printf("%d\n", res);
    for (int i = 0; i < res; ++i)
        cout << nums[i] << ' ';
    printf("\n");
}

int main () {
    solve();
    return 0;
}
```
