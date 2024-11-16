# [Mahmoud and a Triangle](https://codeforces.com/problemset/problem/766/B)

这道题其实非常简单，题看懂了基本就知道要用 `三角形两边之和大于第三边` 这个性质了，之后就是如何实现了。然后我很幸运的立马就找到了方法，
而且我的方法也确实和别人想的一模一样，话不多说，上我自己写的代码：

```cpp

#include<bits/stdc++.h>
using namespace std;
int main() {
    int n = 0;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; ++i) {
        cin >> nums[i];
    }

    sort(nums.begin(), nums.end());
    string result = "NO";
    for (int i = 0; i < n - 2; ++i) {
        if (nums[i] + nums[i + 1] > nums[i + 2])
            result = "YES";
    }
    
    cout << result << endl;
    return 0;
}
```

这个方法可以说是相当的暴力，没有任何技巧，只有暴力，但是也是非常实用了。然后还有一个非常厉害的优化，具体可以看看这篇[题解](https://www.luogu.com.cn/article/azqxurwb)，虽然基本上没有变动什么，
但是却让运行时间缩减了相当多，可谓是很不错的想法了，这种精益求精的学习方法值得我学习。
