# [B. Intercepted Inputs](https://codeforces.com/contest/2037/problem/B)

这是道div3的B题，只有800分，但是里面有一个坑，就是如果使用哈希表来查找的话，必定是超时的，官方在题解中有说明，我也确实用了哈希表写，我说怎么测试案例全通过，脑内模拟也全都通过了怎么可能会错，没办法，
官方喜欢搞这种东西，所以我觉得以后写代码的话，能直接用数组的话优先要用数组，就是要避免官方搞事情

下面是我自己写的代码，写的时候一堆错误，特别是在第二个for循环里的if判断这里的逻辑我写的很混乱，导致我竟然看了很久都没找出问题，最后还是浪费了不少时间才把代码该对，难受

```cpp

#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n; 
    cin >> n;  // 输入一个正整数 n，表示输入的数字范围

    // 创建一个大小为 n+1 的数组，每个初始值为 0
    // 用于记录每个数字在输入数据中的出现次数
    vector<int> nums(n + 1, 0);  

    // 循环读取 n 个输入的数字，并更新它们在 `nums` 中的计数
    for (int i = 0; i < n; ++i) {
        int num; 
        cin >> num;  // 读取一个数字 num
        nums[num]++; // 对应的数字计数累加
    }

    // 遍历从 1 到 n 的所有整数，查找是否存在满足条件的因子对
    for (int i = 1; i <= n; ++i) {
        // 如果当前数字 i 在输入中存在，并且 (n-2) 可以整除 i
        if (nums[i] != 0 && (n - 2) % i == 0) {
            // 计算 (n-2) / i 的值，得到另一个可能的因子 it
            int it = (n - 2) / i;

            // 如果另一个因子 it 存在于 nums 数组中
            if (nums[it]) {
                cout << i << ' ' << it << '\n';  // 输出当前因子对 i 和 it
                return; // 已找到解，立即返回，不再继续查找
            }
        }
    }
}

int main() {
    int t; 
    cin >> t;

    while (t--)
        solve();

    return 0;
}

```
