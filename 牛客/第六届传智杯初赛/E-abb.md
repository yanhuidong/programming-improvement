[第六届传智杯初赛](https://ac.nowcoder.com/acm/contest/71300#question)

这是道刚看到第一时间想到的是三层for循环遍历，但是想都不要想，必超时，所以必须要剪枝了，也就是要用到动态规划，更具体来说应该是后缀和，可以看别人的[题解](https://ac.nowcoder.com/discuss/1241427)，
反正我自己几乎可以说是没有写过前后缀和的题目的，所以这道题是真的没一点思路，还是自己看看题解吧：

```cpp

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;
string s;
int check[200000][26];
int main() {
    cin >> n;
    cin >> s;
    for (int i = n - 1; i >= 0; --i) {
        for (int j = 0; j < 26; ++j)
            check[i][j] = check[i + 1][j];
        check[i][s[i] - 'a'] ++;
    }
    ll res = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 26; ++j) {
            if (s[i] - 'a' != j) {
                res += check[i + 1][j] * (check[i + 1][j] - 1) / 2;
            }
        }
    }
    cout << res;
    
    return 0;
}
```
