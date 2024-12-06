看起来你可能是想问 `isdigit` 函数的用法，而不是 `isdight`。`isdigit` 是一个在C++中用于检查字符是否为数字字符的函数。以下是 `isdigit` 的一些常见用法：

### 基本用法

```cpp
#include <iostream>
#include <cctype>

int main() {
    char ch = '5';
    if (isdigit(ch)) {
        std::cout << ch << " is a digit." << std::endl;
    } else {
        std::cout << ch << " is not a digit." << std::endl;
    }
    return 0;
}
```

### 检查字符串是否只包含数字

```cpp
#include <iostream>
#include <cctype>
#include <string>

bool isNumeric(const std::string& str) {
    for (char c : str) {
        if (!isdigit(c)) return false;
    }
    return true;
}

int main() {
    std::string text = "12345";
    if (isNumeric(text)) {
        std::cout << "The string contains only digits." << std::endl;
    } else {
        std::cout << "The string contains non-digit characters." << std::endl;
    }
    return 0;
}
```

### 提取字符串中的数字部分

```cpp
#include <iostream>
#include <cctype>
#include <string>
#include <algorithm>

std::string extractDigits(const std::string& str) {
    std::string result;
    std::copy_if(str.begin(), str.end(), std::back_inserter(result), ::isdigit);
    return result;
}

int main() {
    std::string text = "abc123def456";
    std::cout << "Extracted digits: " << extractDigits(text) << std::endl;
    return 0;
}
```

### 字符分类

`isdigit` 可以与其他字符分类函数结合使用：

```cpp
#include <iostream>
#include <cctype>

int main() {
    char ch = '5';
    if (isdigit(ch)) {
        std::cout << ch << " is a digit." << std::endl;
    } else if (isalpha(ch)) {
        std::cout << ch << " is an alphabetic character." << std::endl;
    } else {
        std::cout << ch << " is neither a digit nor a letter." << std::endl;
    }
    return 0;
}
```

### 注意事项：

- `isdigit` 函数定义在 `<cctype>` 头文件中。
- 它会根据当前的语言环境（locale）来判断字符是否为数字字符，这意味着在不同的环境下，`isdigit` 对某些字符的判断可能不同。
- 这个函数适用于所有数字字符，包括 ASCII 字符集中的数字字符（0-9）以及根据当前语言环境定义的其他数字字符。

`isdigit` 函数在处理字符串或字符数据时非常有用，特别是在需要验证或提取数字信息时。
