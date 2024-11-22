# [B. Sorted Adjacent Differences](https://codeforces.com/problemset/problem/1339/B)

这道题我没想到正确的思路，然后就直接去看别人的[题解](https://www.luogu.com.cn/problem/solution/CF1339B)了，然后就感觉知道了可以先排序，然后从中间的数字开始，一左一右的交替输出数组元素，
这样就可以得到正确答案。我以为自己也可以实现了，然后就自己去写，一直都想不出如何让数组交替输出左右的元素，本来是想通过 `q` 来实现 `mid - q` 控制输出，然后再与 `pre = -1` 相乘来控制左右，
但是发现我这种方法行不通，应该说是太难实现了，就没办法了。下面是我自己写的未完成的代码：

```cpp

#include<bits/stdc++.h>
using namespace std;

int t, n;
vector<long long> nums;

void solve() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        nums.push_back(num);
    }
    sort(nums.begin(), nums.end());
    long long mid = n / 2;
    long long q = 1, pre = -1;
    cout << nums[mid] << ' ';
    
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;
}
```

---
然后我就让GPT帮我补全了剩余的代码，发现GPT的解决方法才是真不错，下面就是：

```cpp

#include<bits/stdc++.h>
using namespace std;

int t, n;
vector<long long> nums;

void solve() {
    cin >> n;
    nums.clear();  // 清空之前的测试数据
    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;
        nums.push_back(num);
    }
    
    sort(nums.begin(), nums.end());
    
    // 中间位置
    int mid = n / 2;
    int left = mid - 1, right = mid + 1;
    
    // 首先输出中间元素
    cout << nums[mid] << ' ';
    
    // 交替输出左右两边的元素
    while (left >= 0 || right < n) {
        if (left >= 0) {
            cout << nums[left] << ' ';
            left--;
        }
        if (right < n) {
            cout << nums[right] << ' ';
            right++;
        }
    }
    cout << endl;
}

int main() {
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;
}

```

---

GPT用双指针很巧妙的实现了左右交替输出的问题，这真是很不错的解决方法，比我的脑残方法要简单易懂的多，感谢我学算法的时候能有这么好用的AI😘。
