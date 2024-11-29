# [C. Fishingprince Plays With Array](https://codeforces.com/problemset/problem/1696/C)

说实话，这道题才1400分是有点低了的，代码是真挺长的，思路还算比较好想，就是两个数组都可以通过不断拆分最终变成同一个和数组，也就是说，只要先将一个数组拆分，然后另一个数组逐个拆分后进行比较，
就能得到结果了，但是给我思路要我用代码实现，说实话我写不出来，看题解也看了半天才看懂，但是人家写的确实很厉害，还用到了结构体，只能说C++的应用还是太广泛了，我只学了皮毛中的皮毛，下面是我根据
[题解](https://www.luogu.com.cn/article/zn5bxyuf)写的代码，但是说实话不如直接看题解上的代码，至少人家还有注释😑：

```cpp

#include<bits/stdc++.h>
using namespace std;
const int N = 55000;

struct resolve {
    int d, sum;
}tmp;

int t, n, m, nn;
long long s1, s2;
int a[N], b[N];

void solve() {
    deque<resolve> p;
    cin >> n >> m;
    s1 = 0; s2 = 0;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i]; s1 += a[i];
        int k = 1;
        while (a[i] % m == 0) {
            a[i] /= m; k *= m;
        }
        p.push_back(resolve{a[i], k});
    }

    cin >> nn;
    for (int i = 1; i <= nn; ++i) {
        cin >> b[i]; s2 += b[i];
    }

    if (s1 != s2) {
        cout << "No" << endl;
        return;
    }
    int flag = 0;
    for (int i = 1; i <= nn; ++i) {
        int k = 1;
        while (b[i] % m == 0) {
            b[i] /= m; k *= m;
        }

        while (k) {
            if (p.empty()) {
                flag = 1; break;
            }
            tmp = p.front();
            p.pop_front();
            if (tmp.d != b[i]) {
                flag = 1; break;
            }
            if (tmp.sum <= k) 
                k -= tmp.sum;
            else {
                p.push_front(resolve{b[i], tmp.sum - k}); k = 0;
            }
        }
    }

    cout << (flag ? "No" : "Yes") << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
```
