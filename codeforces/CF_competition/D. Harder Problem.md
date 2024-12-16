# [D. Harder Problem](https://codeforces.com/contest/2044/problem/D)

这是道 Div4 的比赛的第四题，这道题说实话我的思路基本是正确的，就是优先将没有出现过的数字排列出来，直到所有数字全部出现了一遍，我确实是这样写的，但是我看错题了，把范围规定在了10以内，搞得一直错，
不过我那种写法，就算没看错题，应该也会一直超时，难受啊。

### 下面是我在比赛的时候写的

```cpp

#include<bits/stdc++.h>
using namespace std;
int t, n;

void solve() {
    int cnt[10]{}, max_cnt = 0;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        if (cnt[num] == 0) {
            cnt[num]++;
            cout << num << ' ';
            max_cnt = 1;
        } else {
            int min_cnt = INT_MAX, ans = 0;
            for (int j = 1; j < 10; ++j) {
                if (cnt[j] < min_cnt) {
                    min_cnt = cnt[j];
                    ans = j;
                }
                if (min_cnt == max_cnt) {
                    max_cnt++;
                    ans = num;
                }
            }
            cnt[ans]++;
            cout << ans << ' ';
        }
    }
    cout << '\n';
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }
}
```

### 下面是看别人提交的代码学会的，用AI写了点注释

```cpp

#include<bits/stdc++.h>
using namespace std;

// 定义全局变量
int t;  // 测试用例数
int n;  // 每个测试用例的数组大小
set<int> cnt;  // 使用set存储可用数字，自动排序且去重

// 解决单个测试用例的函数
void solve() {
    // 读取当前测试用例的数组大小
    cin >> n;
    
    // 清空集合，确保每个测试用例都从干净的集合开始
    cnt.clear();
    
    // 将1到n的所有数字插入集合
    // 注意：set会自动排序，所以最小的数字总是可以快速获取
    for (int i = 1; i <= n; ++i)
        cnt.insert(i);
    
    // 处理输入的数组
    for (int i = 1; i <= n; ++i) {
        // 读取一个数字
        int s;
        cin >> s;
        
        // 如果读取的数字不在集合中
        // 这意味着这个数字已经被使用过
        if (!cnt.count(s))
            // 选择集合中最小的可用数字
            // *cnt.begin() 获取set中的最小元素
            s = *cnt.begin();
        
        // 输出选择的数字
        cout << s << ' ';
        
        // 从集合中删除已使用的数字
        // 防止重复使用
        cnt.erase(s);
    }
    
    // 每个测试用例结束后换行
    cout << '\n';
}

int main() {
    // 读取测试用例总数
    cin >> t;
    
    // 对每个测试用例执行solve()函数
    while (t--) {
        solve();
    }
    
    return 0;
}

// 算法思路解析：
// 1. 对于每个测试用例，先将1到n的数字放入集合
// 2. 读取输入数组中的每个数字
// 3. 如果数字不在集合中（已被使用），选择集合中最小的可用数字
// 4. 输出选择的数字
// 5. 从集合中删除已使用的数字
// 
// 时间复杂度：O(n log n)
// 空间复杂度：O(n)

```
