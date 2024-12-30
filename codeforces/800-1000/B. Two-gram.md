# [B. Two-gram](https://codeforces.com/contest/977/problem/B)

这是道远古时期的Div3的B题，1000分，但是要是放到现在来看的话可能也就600分的样子，是道很简单的题。以下是我写这道题遇到的一些问题还有解决方法，我感觉很有用处

我写这道题的时候使用到了字符串拼接的方法，但是不能直接将两个单字符用 `+` 拼接起来，这种方法只适用于字符串。之后我问了AI，知道了[string构造函数](../../库函数%20&%20扩展知识/string构造函数.md)
方法（又是一招没见过的，果然多刷题就是有好处的，能够学到很多之前不知道的技巧），当然，也可以用 [append](../../库函数%20&%20扩展知识/append.md) 拼接字符，但是注意， `append` 也只能用于字符串的拼接，也需要特定用法防止出错

以下是使用 `append` 的代码

```cpp

#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main() {
    int n; cin >> n;
    string s; cin >> s;

    unordered_map<string, int> cnt;
    int ans = 0;
    string res;
    for (int i = 0; i < s.length() - 1; ++i) {
        string c = "";
        // 使用了 std::string::append 函数的一个版本，该版本接受两个参数：一个是要附加的字符数量，
        // 另一个是要附加的字符。这里，我们只附加一个字符 s[i]，所以第一个参数是 1
        c.append(1, s[i]).append(1, s[i + 1]);
        cnt[c]++;
        if (cnt[c] > ans) {
            res = c;
            ans = cnt[c];
        }
    }
    cout << res;
}
```

使用 `string构造函数` 方法

```cpp

#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main() {
    int n; cin >> n;
    string s; cin >> s;

    unordered_map<string, int> cnt;
    int ans = 0;
    string res;
    for (int i = 0; i < s.length() - 1; ++i) {
        string c = string(1, s[i]) + string(1, s[i + 1]);
        cnt[c]++;
        if (cnt[c] > ans) {
            res = c;
            ans = cnt[c];
        }
    }
    cout << res;
}
```
