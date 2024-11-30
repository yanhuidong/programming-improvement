# [B. Composite Coloring](https://codeforces.com/problemset/problem/1332/B)

这又是一道考验数学功底的题，这道题这样出是有理由的，思路的话看看[题解](https://www.luogu.com.cn/article/cwq1yede)看看这哥们的就差别不多了，虽然我看了老半天才看懂，然后过会就忘了，
但是多少还是有收获的，至少以后碰到类似的题目可以有一点思路。下面是我根据题解写的代码：

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n, nums[1001], tep[11], use;
int gcb[11] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

void solve() {
    memset(tep, 0, sizeof(tep));
    scanf("%d", &n);
    use = 0;
    for (int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 11; ++j) {
            if (nums[i] % gcb[j] == 0) {
                if (tep[j] == 0) {
                    use++;
                    tep[j] = use;
                }
                nums[i] = tep[j];
                break;
            }
        }
    }

    printf("%d\n", use);
    for (int i = 0; i < n; ++i)
        printf("%d ", nums[i]);
    printf("\n");
}

int main() {
    scanf("%d", &t);
    while (t--) {
        solve();
    }
    return 0;
}
```
