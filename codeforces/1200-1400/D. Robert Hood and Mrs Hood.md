# [D. Robert Hood and Mrs Hood](https://codeforces.com/contest/2014/problem/D)

一道div3的D题，1400多分，还是有点难度的，看题需要花一点时间，但是也不难理解，这道题我第一时间想到的就是使用滑动窗口写，因为 `d` 是确定的，所以我以为可以用定长滑动窗口写，但是之后我发现不太行，因为
每次移动窗口我都无法确定当前的最大覆盖任务数量是多少，所以我就一直写不出来，直到看了官方题解才知道该怎么写，

以下是我根据官方题解写的基本一样的代码

```cpp

#include <iostream>
#include <vector>

using namespace std;

// 解决单个测试用例的函数
void solve() {
    int n, d, k; // n: 总天数, d: 访问持续天数, k: 工作数量
    cin >> n >> d >> k; // 读取 n, d, k

    // 定义两个数组 start 和 end，用于记录每个工作区间的开始和结束
    // start[i]: 表示有多少个工作从第 i 天开始
    // end[i]: 表示有多少个工作在第 i 天结束
    vector<int> start(n + 1, 0), end(n + 1, 0);

    // 处理每个工作区间
    for (int i = 0; i < k; ++i) {
        int a, b; // 工作的起始日和结束日
        cin >> a >> b; // 读取工作区间 [a, b]
        start[a]++; // 记录从第 a 天开始的工作数量
        end[b]++;   // 记录在第 b 天结束的工作数量
    }

    // 计算前缀和
    // start[i]: 表示从第 1 天到第 i 天开始的工作总数
    // end[i]: 表示从第 1 天到第 i 天结束的工作总数
    for (int i = 0; i < n; ++i) {
        start[i + 1] += start[i]; // 计算 start 的前缀和
        end[i + 1] += end[i];     // 计算 end 的前缀和
    }

    // 初始化变量
    int most = 0;   // 覆盖最多工作的数量
    int least = 200000; // 覆盖最少工作的数量（初始化为一个较大的值）
    int bro = 0;    // 兄弟的最佳起始日
    int mon = 0;    // 母亲的最佳起始日

    // 遍历所有可能的起始日，寻找最优解
    for (int i = d; i <= n; ++i) {
        // 计算从第 i-d+1 天到第 i 天覆盖的工作数量
        int cur = start[i] - end[i - d];

        // 如果当前覆盖的工作数量大于最大值，更新最大值和兄弟的起始日
        if (cur > most) {
            most = cur;
            bro = i - d + 1;
        }

        // 如果当前覆盖的工作数量小于最小值，更新最小值和母亲的起始日
        if (cur < least) {
            least = cur;
            mon = i - d + 1;
        }
    }

    // 输出兄弟和母亲的最佳起始日
    cout << bro << ' ' << mon << endl;
}

int main() {
    // 优化输入输出，提高效率
    cin.tie(nullptr);
    ios::sync_with_stdio(false);

    int t; // 测试用例的数量
    cin >> t; // 读取测试用例的数量
    while (t--) { // 处理每个测试用例
        solve();
    }

    return 0;
}
```

然后下面是看了洛谷的一个题解，这个题解只需要一个额外的差分数组，空间上可以减少一点消耗，但是要注意差分数组大小最少要是 `n+2` ，因为在后面的 `cover[r + 1]--` 中会数组越界，我就这样提交错误了
一次，然后这里的 `cover[max(1, l - d + 1)]++` 和 `cover[r + 1]--` 需要理解一下，看一下注释就可以了，本质上和第一种方法是一模一样的，都是前缀和加差分数组，这种题我还没怎么写过，还要刷！！

```cpp

#include<bits/stdc++.h>
using namespace std;

int main() {
    int t; // 测试用例的数量
    cin >> t; // 读取测试用例的数量
    while (t--) { // 处理每个测试用例
        int n, d, k; // n: 总天数, d: 访问持续天数, k: 工作数量
        cin >> n >> d >> k; // 读取 n, d, k

        // 差分数组，用于记录每个起始日覆盖的工作数量变化
        // 数组大小为 n+2，避免越界
        vector<int> cover(n + 2, 0);

        // 处理每个工作区间
        for (int i = 0; i < k; ++i) {
            int l, r; // 工作的起始日和结束日
            cin >> l >> r; // 读取工作区间 [l, r]

            // 计算该工作影响的起始日范围
            // 起始日的最小值为 max(1, l - d + 1)，确保起始日不小于 1
            // 结束日为 r + 1，表示从 r + 1 天开始不再覆盖该工作
            cover[max(1, l - d + 1)]++; // 起始日覆盖的工作数量 +1
            cover[r + 1]--; // 结束日之后覆盖的工作数量 -1
        }

        // 计算前缀和，得到每个起始日覆盖的工作数量
        for (int i = 1; i <= n; ++i) {
            cover[i] += cover[i - 1]; // 前缀和计算
        }

        // 初始化变量
        int bday = 1; // 兄弟的最佳起始日
        int mday = 1; // 母亲的最佳起始日
        int maxn = -1; // 覆盖最多工作的数量
        int minn = INT_MAX; // 覆盖最少工作的数量

        // 遍历所有可能的起始日，寻找最优解
        for (int day = 1; day <= n - d + 1; ++day) {
            // 如果当前起始日覆盖的工作数量大于最大值，更新最大值和兄弟的起始日
            if (cover[day] > maxn) {
                maxn = cover[day];
                bday = day;
            }
            // 如果当前起始日覆盖的工作数量小于最小值，更新最小值和母亲的起始日
            if (cover[day] < minn) {
                minn = cover[day];
                mday = day;
            }
        }

        // 输出兄弟和母亲的最佳起始日
        cout << bday << ' ' << mday << '\n';
    }
    return 0;
}
```
