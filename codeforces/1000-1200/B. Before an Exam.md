# [B. Before an Exam](https://codeforces.com/problemset/problem/4/B)

这是一道典型的贪心题，通过局部最优达到全局最优，看看别人的[题解](https://www.luogu.com.cn/article/99p93bqf)，思路很简单，就是先判断是否有正确输出，然后通过每次改变最小元素数组中的元素大小，
使其变为该天数的最大值，知道不能变为止，这样就实现了从局部最优到全局最优的方法了，我自己根据题解写的代码贴在下面了：

```cpp

#include<bits/stdc++.h>
using namespace std;
vector<int> a, b;
int d, sum;
int main() {
    a.clear();
    b.clear();
    cin >> d >> sum;
    int min_sum = 0, max_sum = 0;
    for (int i = 0; i < d; ++i) {
        int max_s, min_s;
        cin >> min_s >> max_s;
        min_sum += min_s;
        max_sum += max_s;
        a.push_back(min_s);
        b.push_back(max_s);
    }

    if (min_sum <= sum && max_sum >= sum) {
        cout << "YES" << endl;
        int i = 0;
        sum -= min_sum;
        while (sum) {
            if (sum > b[i] - a[i]) {
                sum -= b[i] - a[i];
                a[i] = b[i];
            }

            else {
                a[i] += sum;
                sum = 0;
            }
            ++i;
        }

        for (int n : a) {
            cout << n << ' ';
        }
    }

    else
        cout << "NO";
    return 0;
}
```

---

下面是我把我的代码复制给GPT让他修改了一下的，不知道为毛在codeforces上运行后比我的代码的空间要少,但至少看上去是比我自己的代码要简洁一些的：

```cpp

#include<bits/stdc++.h>
using namespace std;

vector<int> a, b;
int d, sum;

int main() {
    a.clear();
    b.clear();
    cin >> d >> sum;
    
    int min_sum = 0, max_sum = 0;
    
    // Read the minimum and maximum hours for each day
    for (int i = 0; i < d; ++i) {
        int min_s, max_s;
        cin >> min_s >> max_s;
        min_sum += min_s;
        max_sum += max_s;
        a.push_back(min_s);
        b.push_back(max_s);
    }

    // Check if it's possible to form a valid timetable
    if (min_sum <= sum && max_sum >= sum) {
        cout << "YES" << endl;
        
        sum -= min_sum;  // Distribute the remaining time after setting the minimum values
        
        // Distribute remaining hours to each day
        for (int i = 0; i < d; ++i) {
            // Calculate the maximum additional hours we can assign to this day
            int add_time = min(b[i] - a[i], sum);
            a[i] += add_time;
            sum -= add_time;  // Subtract the allocated time from the remaining time
            
            // If all time is distributed, break out of the loop early
            if (sum == 0) break;
        }

        // Output the final schedule
        for (int n : a) {
            cout << n << ' ';
        }
    } else {
        cout << "NO";
    }
    
    return 0;
}

```
