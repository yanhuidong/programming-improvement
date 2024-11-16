# [Nastia and Nearly Good Numbers](https://codeforces.com/problemset/problem/1521/A)

虽然这次的题目很好理解，不看翻译也能看个大概，就是写不出来就是了😂,写完以后再去看看[题解](https://www.luogu.com.cn/article/jej828bo)吧。

### **注**：这篇题解有个问题就是这个题目的测试用例到后面会非常大，不能用 `int` 了，而要用 `long long`，但是为了我在之前所知道的 `printf` 比 `cout` 的 `I/O` 操作速度更快，所以我就试了一下用 `print` 打印输出，然后一直出错，明明我在 `Clion` 上运行的结果是没问题的，然后问了GPT才知道是什么问题，我先把代码粘上来：

```cpp

#include <iostream>
using namespace std;

int main() {
    long long t;
    cin >> t;
    while (t--) {
        long long a, b;
        cin >> a >> b;
        if (b == 1)
            cout << "NO" << endl;

        else if (b == 2) {
            cout << "YES" << endl;
            b = 4;
            printf("%d %d %d\n", a, a * (b - 1), a * b);
        }

        else {
            cout << "Yes" << endl;
            printf("%d %d %d\n", a, a * (b - 1), a * b);
        }
    }
    return 0;
}
```

在codeforces上如果我按照给出的测试用例来测试，输入 `a = 5, b = 3`，得到的结果是 `5 0 10`，但是预期结果是 `5 10 15`，原来 `long long` 类型是不能用 `%d` 的，
要用 `%lld`，只能说不知道的还多着呢。
