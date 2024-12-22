# [C. Superultra's Favorite Permutation](https://codeforces.com/contest/2037/problem/C)

一道1000分的构造题啊，主要就是要懂一些关于质数的性质，然后就能很快写出来了，这就是构造题的有趣之处。以下是官方题解的英文加翻译，一看就懂了

Remember that all even numbers greater than $2$ are composite. As $1+3 &gt; 2$, any two numbers with same parity sum up to a composite number. 
Now you only have to find one odd number and one even number that sum up to a composite number. One can manually verify that there is no such pair in $n \leq 4$, 
but in $n=5$ there exists $(4,5)$ which sums up to $9$, a composite number.

**翻译**：请记住，所有大于 $2$ 的偶数都是合数。正如 $1+3 &gt; 2$ ，任何两个奇偶性相同的数相加都是一个合数。现在只需找到一个奇数和一个偶数相加为一个合数。
我们可以手动验证 $n \leq 4$ 中不存在这样的一对数，但是在 $n=5$ 中存在 $(4,5)$ ，它的和为 $9$ ，是一个合数。

下面是我根据题解自己写的代码：

```cpp

#include<iostream>
using namespace std;

void solve() {
    int n; cin >> n;
    if (n <= 4) {
        cout << -1 << '\n';
        return;
    } else {
        for (int i = 1; i <= n; i += 2) {
            if (i != 5)
                cout << i << ' ';
        }
        cout << "5 4" << ' ';
        for (int i = 2; i <= n; i += 2)
            if (i != 4)
                cout << i << ' ';
    }
}

int main() {
    int t; cin >> t;
    while (t--)
        solve();
    return 0;
}
```
