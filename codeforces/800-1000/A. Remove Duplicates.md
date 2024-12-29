# [A. Remove Duplicates](https://codeforces.com/contest/978/problem/A)

一道远古时期的div3的A题，感觉没有800分的样子，撑死400多分，但是这道题我多次看错题了，导致还写了蛮久，虽然还是写出来了就是了，看了洛谷的题解之后发现有人用什么桶排序，于是我就去B站学了一下桶排序是啥，
发现很多人都是把这玩意当作计数排序来讲的，但是又有不少人在评论区里说桶排序和计数排序不一样，然后我就问AI了，看看[桶排序和计数排序](../../库函数%20&%20扩展知识/桶排序和计数排序.md)。

下面是我错了N次之后写对的代码，其实真不难，先看懂题目，然后理清思路，其实真的很简单的，而且数据量也小，根本没难度好吧，还是我太轻敌了

```cpp

#include<bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    vector<int> nums;
    for (int i = 0; i < n; ++i) {
        int s; cin >> s;
        nums.push_back(s);
    }
    unordered_set<int> check;
    vector<int> ans;
    for (int i = n - 1; i >= 0; --i) {
        if (check.find(nums[i]) == check.end())
            ans.push_back(nums[i]);
        check.insert(nums[i]);
    }
    int cnt = ans.size();
    cout << cnt << endl;
    for (int i = cnt - 1; i >= 0; --i)
        cout << ans[i] << ' ';
}
```
