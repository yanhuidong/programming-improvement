# [C. Sasha and the Casino](https://codeforces.com/problemset/problem/1929/C)

这道题纯粹就是考验数学功底的啊，而且只看一篇[题解](https://www.luogu.com.cn/problem/solution/CF1929C)还不够，要看两篇，因为[第一篇](https://www.luogu.com.cn/article/btratn94)的讲解
比较详细易懂，但是代码写的过于简单导致看不懂，还要看[第二篇](https://www.luogu.com.cn/article/7hygbi0h)的公式讲解才能搞懂，真是浪费了我不少时间啊，但是也还算一道挺有意思的构造题的。
代码我贴下面了，记得配合题解使用：

```cpp

#include<bits/stdc++.h>
using namespace std;
int t;

void solve()
{
	int k, x, a;
    cin >> k >> x >> a;
	long long sum = 0;
	for(int i = 1; i <= x + 1; i ++){
		sum += sum / (k - 1) + 1;
		if(sum > a) {
            cout << "NO\n"; return;
        }
	}
	cout << "YES\n";
}

int main() {
    scanf("%d", &t);
    while (t--) {
        solve();
    }
    return 0;
}
```
