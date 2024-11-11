# [Buy a Shovel](https://codeforces.com/problemset/problem/732/A)  买一把铲子

先把结果贴出来：

```cpp
#include <iostream>
using namespace std;

int main() {
    int k, r;
    cin >> k >> r;
    int res = 1;
    
    while (true) {
        int lastDigit = (res * k) % 10;
        if (lastDigit == 0 || lastDigit == r) {
            break;
        }
        res++;
    }
    
    cout << res << endl;
    return 0;
}


```
很简单的一道题，但是我却测试了很多个都没通过，因为我没有考虑在买了 `k` 把铲子之后，费用可能刚好能被10整除，只考虑了对10取余之后的结果是否和 `r`相等，导致结果一直出错，
只能说我还是我啊，在简单的题也能漏条件，还是不行。
